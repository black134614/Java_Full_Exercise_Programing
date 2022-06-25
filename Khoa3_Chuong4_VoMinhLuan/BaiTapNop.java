import java.util.Scanner;

public class BaiTapNop {

	final static byte min = -100;
	final static byte max = 100;

	public static int[] taoMangNgauNhien(byte min, byte max, byte soPhanTu) {
		int[] arr = new int[soPhanTu];
		for (int i = 0; i < soPhanTu; i++) {
			arr[i] = min + (int) (Math.random() * (max - min + 1));
		}
		return arr;
	}

	public static void xuatMang(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public static int[] InterchangeSort(int arr[]) {
		int i, j;
		for (i = 0; i < arr.length - 1; i++) {
			for (j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					int tam = arr[i];
					arr[i] = arr[j];
					arr[j] = tam;
				}
			}
		}
		return arr;
	}
/*
 *Trộn mảng giam dần
 * so sánh a[--lengthA] > b[--lengthB] ? c[0] = a[lengthA--] : c[0] = b[lengthB--]
 * Đến khi lengthA = -1 => return b[lengthB]ngược lại lengthB = -1  ==> return a[lengthA] gán cho c[lengthC]
 * */
 
	public static int[] tronMangGiamdan(int arrA[], int arrB[]) {
		int[] arrC = new int[arrA.length + arrB.length];
		int phanTuMangA = arrA.length - 1, phanTuMangB = arrB.length - 1;
		for (int PhanTuMangC = 0; PhanTuMangC < arrC.length; PhanTuMangC++) {
			if (phanTuMangA > -1 && phanTuMangB > -1) {
				if (arrA[phanTuMangA] >= arrB[phanTuMangB]) {
					arrC[PhanTuMangC] = arrA[phanTuMangA--];
				}
				else {
					arrC[PhanTuMangC] = arrB[phanTuMangB--];
				}
			}
			else if (phanTuMangB == -1) {
				arrC[PhanTuMangC] = arrA[phanTuMangA--];
			}
			else if (phanTuMangA == -1){
				arrC[PhanTuMangC] = arrB[phanTuMangB--];
			}
		}
		return arrC;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng A ( nhập > 0):");
		byte soPhanTuA = Byte.parseByte(scan.nextLine());
		int[] arrA = taoMangNgauNhien(min, max, soPhanTuA);
		System.out.println("Mảng A đã tạo: ");
		xuatMang(arrA);

		System.out.println("\nMời bạn nhập số phần tử của mảng B ( nhập > 0):");
		byte soPhanTuB = Byte.parseByte(scan.nextLine());
		int[] arrB = taoMangNgauNhien(min, max, soPhanTuB);
		System.out.println("Mảng B đã tạo: ");
		xuatMang(arrB);

		InterchangeSort(arrA);
		InterchangeSort(arrB);

		System.out.println("\nMảng A tăng dần sau sắp xếp: ");
		xuatMang(arrA);
		System.out.println("\nMảng B giảm dần sau sắp xếp: ");
		xuatMang(arrB);
		
//		test trộn mảng
//		int[] x = {1,1,1,1,1};
//		int[] y = {0,0,0,0,0};
//		int[] x = {1,2,2,3,3};
//		int[] y = {1,2,2,3,4};
//		int[] x = {-1,0,1,2};
//		int[] y = {4,5,6,7,8};
//		int [] arrC =tronMangGiamdan(x, y);
		
		System.out.println("\nMảng C sau trộn: ");
		int [] arrC =tronMangGiamdan(arrA, arrB);
		xuatMang(arrC);
	}
}
