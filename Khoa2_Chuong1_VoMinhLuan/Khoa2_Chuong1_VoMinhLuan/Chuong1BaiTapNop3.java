import java.util.Scanner;

public class Chuong1BaiTapNop3 {

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

	public static void timSoChanTrongMangTheoDieuKien(int[] arr, int x, int y) {
		System.out.println("Danh sách số chẵn mảng arr thuộc đoạn x - y là:");
		int demSoVongLap = 0;
		for (; x < y; x++) {
			if (arr[x] % 2 == 0) {
				System.out.print(arr[x] + "\t");
				demSoVongLap++;
			}
			if (demSoVongLap == 0) {
				System.out.println("Không có giá trị nào là số chẵn.");
			}
		}
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		// cờ bắt lỗi nhập
		boolean flag = false;
		System.out.println("Nhập số phần tử mảng n > 2:");
		int n = 0;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n <= 1) {
				flag = true;
				System.out.println("Nhập lại n > 2");
			}
			else 
				flag = false;
		} while (flag);

		short batDau = -100, ketThuc = 100; // tái sử dụng nhiều lần
		int[] arr = taoMangNgauNhieuCoDieuKien(batDau, ketThuc, n);
		xuatMang(arr);

		System.out.println("\nNhập đoạn x-y kiểm tra trên mảng::");
		System.out.println("giá trị từ 0 - " + (n - 1) + " và x < y");
		int x = 0;

		System.out.println("y:");
		int y = 0;

		do {
			System.out.println("x =");
			x = Integer.parseInt(scan.nextLine());
			System.out.println("y =");
			y = Integer.parseInt(scan.nextLine());
			if (x > y | x < 0 | y > n) {
				flag = true;
				System.out.println("Nhập lại");
			} else
				flag = false;
		} while (flag);

		timSoChanTrongMangTheoDieuKien(arr, x, y);
	}

}
