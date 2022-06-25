import java.util.Scanner;

public class Chuong1BaiTapNop1 {

	public static int[] nhapMang(int n, Scanner scan) {
		int arr[] = new int[n];
		System.out.println("Nhập mảng");
		for (int i = 0; i < n; i++) {
			System.out.print("arr[" + i + "] = ");
			arr[i] = Integer.parseInt(scan.nextLine());
		}
		return arr;

	}

	public static void lietKeGiaTri(int[] arr, short k) {
		long dieuKien = tinhLuyThua(3, k);
		int countNumber = 0;
		System.out.println("\nSố phần tử trong dãy số nguyên có giá trị 3^k là:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == dieuKien) {
				System.out.println("Vị trí " + (i + 1));
				countNumber++;
			}
		}
		if (countNumber == 0) {
			System.out.println("0");
		}
	}

	public static long tinhLuyThua(int coSo, int soMu) {
		long ketQua = 1;

		for (int i = 0; i < soMu; i++) {
			ketQua *= coSo;
		}
		return ketQua;
	}

	public static void main(String[] args) {
		/*
		 * Nhập mảng 1 chiều số nguyên nhập k liệt kê vị trí của phần từ mảng có giá trị
		 * bằng 3^k lưu ý k > 0, nếu k < 0 thì mảng số thực mới dc...
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		int arrLength = Integer.parseInt(scan.nextLine());

		int[] arr = nhapMang(arrLength, scan);

		boolean flag = false;
		short k = 0;
		do {
			System.out.println("Mời bạn nhập k:");
			k = Short.parseShort(scan.nextLine());
			if (k < 0) {
				flag = true;
				System.out.println("k lớn hơn hoặc bằng 0");
			} else
				flag = false;
		} while (flag);


		lietKeGiaTri(arr, k);
	}

}
