import java.util.Iterator;
import java.util.Scanner;

public class BaiTapNop7 {
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

	public static int timGiaTriPhuHop(int arr[], int x, int y) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= x && arr[i] <= y) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);

		int[] arr = taoMangNgauNhien(min, max, soPhanTu);
		xuatMang(arr);
		System.out.println("Nhập khoảng giá trị x - y: \n X =");
		int x = Integer.parseInt(scan.nextLine());
		int y = 0;
		do {
			System.out.println("Y = ");
			y = Integer.parseInt(scan.nextLine());
			if (x >= y) {
				System.out.println("Nhập lại giá trị x < y");
			}
		} while (x >= y);
		System.out.println("Giá trị đầu tiên thuộc đoạn x - y là: " + timGiaTriPhuHop(arr, x, y));
	}
}
