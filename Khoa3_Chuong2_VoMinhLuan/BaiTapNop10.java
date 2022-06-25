import java.util.Iterator;
import java.util.Scanner;

public class BaiTapNop10 {
	final static int min = 2019;
	final static int max = 2020;

	public static float[] taoMangNgauNhien(int min, int max, byte soPhanTu) {
		float[] arr = new float[soPhanTu];
		for (int i = 0; i < soPhanTu; i++) {
			arr[i] = (float) (min + (Math.random() * (max - min + 1)));
		}
		return arr;
	}

	public static void xuatMang(float arr[]) {
		System.out.println("Mảng số thực đã tạo là: ");
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

	public static void ketQuaTimKiem(float arr[]) {
		System.out.println("\nChỉ số & giá trị đầu tiên lớn hơn giá trị 2020: ");
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 2020) {
				System.out.println("Chỉ số: " + i + 1 + ", Giá trị: " + arr[i]);
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("-1");
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nMời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);

		float[] arr = taoMangNgauNhien(min, max, soPhanTu);
		xuatMang(arr);
		ketQuaTimKiem(arr);
	}
}
