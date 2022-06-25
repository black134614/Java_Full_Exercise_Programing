import java.util.Scanner;

public class Chuong1BaiTapNop10 {
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

	public static void tinhTrungBinhCong(int[] arr, int x) {
		int tongGiaTri = 0, demVongLap = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > x) {
				tongGiaTri += arr[i];
				demVongLap++;
			}
		}
		if (demVongLap == 0) {
			demVongLap = 1;
		}
		System.out.println("\nTrung bình cộng các số lớn hơn "+ x + " là:" + (float) tongGiaTri / demVongLap);
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

		System.out.println("Mời bạn nhập giá trị x cần thực hiện: x =");
		int x = Integer.parseInt(scan.nextLine());

		xuatMang(arr);

		tinhTrungBinhCong(arr, x);
	}
}
