import java.util.Scanner;

public class BaiTapNop1 {
	final static byte min = -100;
	final static byte max = 100;

	public static int[] taoMaTranNgauNhien(byte min, byte max, byte soPhanTu) {
		int[] arr = new int[soPhanTu];
			for (int i = 0; i < soPhanTu; i++) {
				arr[i] = min + (int) (Math.random() * (max - min + 1));
			}
		return arr;
	}

	public static void xuatMang(int arr[]) {
		System.out.println("Mảng đã tạo là: ");
		for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
		}
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}

	public static void timViTriGiaTriNhoNhat(int arr[]) {
		int minValue = xacDinhGiaTriNhoNhat(arr);
		System.out.println("\nVị trí có giá trị nhỏ nhất là: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == minValue) {
				System.out.print(i + 1 + "\t");
			}
		}
	}
	
	public static int xacDinhGiaTriNhoNhat(int arr[]) {
		int minValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < minValue) {
				minValue = arr[i];
			}
		}
		return minValue;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);
		
		int[] arr = taoMaTranNgauNhien(min, max, soPhanTu);
		xuatMang(arr);
		
		timViTriGiaTriNhoNhat(arr);
	}
}
