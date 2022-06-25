import java.util.Scanner;

public class Chuong1BaiTapNop7 {
	public static int[] nhapMang(int n, Scanner scan) {
		int arr[] = new int[n];
		System.out.println("Nhập mảng");
		for (int i = 0; i < n; i++) {
			System.out.print("arr[" + i + "] = ");
			arr[i] = Integer.parseInt(scan.nextLine());
		}
		return arr;

	}

	public static void xuatMang(int arr[]) {
		System.out.println("\nMảng bạn đã nhập là:");
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void timSoChanTrongMangTheoDieuKien(int[] arr) {
		int tongGiaTri = 0;

		for (int i = 0; i < arr.length ; i++) {
			if (xacDinhSoHangChuc(arr[i])) {
				tongGiaTri += arr[i];
			}
		}
			System.out.println("Tổng giá trị các phần tử có giá trị hàng chục là 5 là: " + tongGiaTri);
	}

	private static boolean xacDinhSoHangChuc(int number) {
		number /= 10;
		if (number %10 == 5) {
			return true; //số hàng chục là 5
		}
		else 
			return false;//số hàng chục khác 5
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
		int[] arr = nhapMang(n, scan);
		
		xuatMang(arr);

		timSoChanTrongMangTheoDieuKien(arr);
	}
}
