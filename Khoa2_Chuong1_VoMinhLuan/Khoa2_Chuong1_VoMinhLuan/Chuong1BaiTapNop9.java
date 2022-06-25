import java.util.Iterator;
import java.util.Scanner;

public class Chuong1BaiTapNop9 {
	public static int[] taoMangNgauNhieuCoDieuKien(short batDau, short ketThuc, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = batDau + (int) (Math.random() * ((ketThuc - batDau) + 1));
		}
		return arr;
	}

	public static void xuatMang(int arr[]) {
		System.out.println("\nMảng bạn đã tạo ngẫu nhiên là");
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void tinhTBCCacSoNguyenTo(int[] arr) {
		int tongGiaTri = 0, demVongLap = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (xacDinhSoNguyenTo(arr[i])) {
				tongGiaTri += arr[i];
				demVongLap ++;
			}
		}
		if (demVongLap == 0) {
			demVongLap = 1;
		}
		System.out.println("\nTrung bình cộng các số nguyên tố trong mảng là:" + (float) tongGiaTri / demVongLap);
	}

	public static boolean xacDinhSoNguyenTo(int number) {
		if (number < 2) {
			return false;
		} else if (number == 2)
			return true;
		else {
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
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

		short batDau = -1000, ketThuc = 1000;
		int[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		tinhTBCCacSoNguyenTo(arr);
	}
}
