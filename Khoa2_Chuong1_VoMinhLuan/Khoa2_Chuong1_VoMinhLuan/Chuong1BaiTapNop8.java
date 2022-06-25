import java.util.Scanner;

public class Chuong1BaiTapNop8 {
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

	public static void tinhTongTheoDieuKien(int[] arr) {
		int tongGiaTri = 0;
		for (int i = 0; i < arr.length -1; i++) {
			if (arr[i] > Math.abs(arr[i + 1])) {
				tongGiaTri += arr[i];
			}
		}
			System.out.println("\nTổng các phần tử có giá trị lớn hơn giá trị tuyệt đối của phần tử đứng liền sau nó là:" + tongGiaTri);
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		// cờ hiệu báo lỗi nhập.
		boolean flag = false;
		System.out.println("Nhập số phần tử mảng n > 2:");
		int n = 0;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n <= 1) {
				flag = true;
				System.out.println("Nhập lại n > 2");
			} else
				flag = false;
		} while (flag);

		short batDau = -1000, ketThuc = 1000;
		int[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		tinhTongTheoDieuKien(arr);
	}
}
