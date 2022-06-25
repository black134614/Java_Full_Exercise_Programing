import java.util.Enumeration;
import java.util.Iterator;
import java.util.Scanner;

public class BaiTapNop8 {
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

	public static int ketQuaTimKiem(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			if (xacDinhGiaTriDung(arr[i])) {
				return arr[i];
			}
		}
		return 0;
	}
	
	public static boolean xacDinhGiaTriDung(int number) {
		if (number < 0) {
			return false;
		}
		do {
			if (number % 2 != 0) {
				return false;
			}
			number /= 2;
		}
		while(number != 1);
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);

		int[] arr = taoMangNgauNhien(min, max, soPhanTu);
		xuatMang(arr);
		
		System.out.println("\nGiá trị đầu tiên có dạng 2^K là: " + ketQuaTimKiem(arr));
	}
}
