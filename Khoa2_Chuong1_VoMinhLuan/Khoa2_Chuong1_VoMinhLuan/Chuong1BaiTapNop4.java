import java.util.Scanner;

public class Chuong1BaiTapNop4 {

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

	public static void timSoToanLe(int[] arr) {
		int demSoVongLap = 0;
		System.out.println("\nCác giá trị toàn lẻ là:");
		
		for (int i = 0; i < arr.length; i++) {
			if (xacDinhGiaTriToanLe(arr[i])) {
				System.out.print(arr[i] + "\t");
				demSoVongLap++;
			}
		}
		if (demSoVongLap == 0) {
			System.out.println("\nKhông có giá trị nào có chữ số toàn lẻ.");
		}
	}

	private static boolean xacDinhGiaTriToanLe(int number) {
		boolean flag = true;
		while (number != 0 & flag) {
			if (number % 2 == 0) {
				flag = false; // Có số chẵn
				break;
			} else {
				number /= 10;
			}
		}
		return flag;
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

		short batDau = -1000, ketThuc = 1000; // tái sử dụng nhiều lần nên phải có biến
		int[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		timSoToanLe(arr);
	}
}
