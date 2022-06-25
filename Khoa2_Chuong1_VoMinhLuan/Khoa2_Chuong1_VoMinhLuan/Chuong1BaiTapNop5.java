import java.util.Scanner;

public class Chuong1BaiTapNop5 {
	public static int[] taoMangNgauNhieuCoDieuKien(int batDau, int ketThuc, int n) {
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

	public static void timSoChanTrongMangTheoDieuKien(int[] arr) {
		System.out.println("\nDanh sách số có giá trị số đầu tiên là số chẵn là:");
		int demSoVongLap = 0;

		for (int i = 0; i < arr.length ; i++) {
			if (xacDinhGiaTriSoDauTienChan(arr[i])) {
				System.out.print(arr[i] + "\t");
				demSoVongLap++;
			}
		}
		if (demSoVongLap == 0) {
			System.out.println("Không có giá trị nào có chữ số đầu tiên là chẵn.");
		}
	}

	private static boolean xacDinhGiaTriSoDauTienChan(int number) {
		while (number != 0 & Math.abs(number) >= 10) {
			number /= 10;
		}
		if (number % 2 == 0)
			return true; //Số chẵn
		else
			return false; //Số lẻ
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

		int batDau = 0, ketThuc = 0; // đề bài không yêu cầu mảng tự nhập hoặc khởi tạo ngẫu nhiên.
		do {
			System.out.println("Mời bạn nhập khoảng giá trị của các phần tử mảng (giá trị bắt đầu < giá trị kết thúc).");
			System.out.println("Giá trị bắt đầu:");
			batDau = Integer.parseInt(scan.nextLine());
			System.out.println("Giá trị kết thúc:");
			ketThuc = Integer.parseInt(scan.nextLine());
			if (batDau > ketThuc) {
				flag = true;
				System.out.println("Nhập lại giới hạn giá trị.");
			} else
				flag = false;
		} while (flag);
		int[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		timSoChanTrongMangTheoDieuKien(arr);
	}
}
