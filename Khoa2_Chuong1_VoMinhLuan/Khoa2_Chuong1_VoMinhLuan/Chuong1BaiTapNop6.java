import java.util.Scanner;

public class Chuong1BaiTapNop6 {

	public static float[] taoMangNgauNhieuCoDieuKien(short batDau, short ketThuc, int n) {
		float[] arr = new float[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = batDau + (float) (Math.random() * ((ketThuc - batDau) + 1));
		}
		return arr;
	}

	public static void xuatMang(float arr[]) {
		System.out.println("\nMảng số thực bạn đã tạo ngẫu nhiên là:");
		for (float phanTu : arr) {
			System.out.print(phanTu + "\t");
		}
	}

	public static void tongSoDuong(float[] arr) {
		System.out.print("\nTổng các giá trị dương là:");
		float tongSoDuong = 0;

		for (int i = 0; i < arr.length; i++) {
			if (xacDinhSoDuong(arr[i])) {
				tongSoDuong += arr[i];
			}
		}
			System.out.print(tongSoDuong);
	}

	private static boolean xacDinhSoDuong(float number) {
		if (number > 0) {
			return true;// là số dương
		} else
			return false;// là số âm
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		// cờ hiệu báo lỗi nhập.
		boolean flag = false;
		System.out.println("Nhập số phần tử mảng n > 0:");
		int n = 0;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n <= 0) {
				flag = true;
				System.out.println("Nhập lại n > 0");
			} else
				flag = false;
		} while (flag);

		short batDau = -1000, ketThuc = 1000; // khởi tạo giá trị của phần tử ngẫu nhiên
		float[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		tongSoDuong(arr);
	}

}
