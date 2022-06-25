import java.util.Scanner;

public class BaiTap7 {
	public static long deQuy(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + deQuy(n - 1);
		}
	}

	public static double tong(int n) {
		if (n == 1) {
			return 1;
		} else {
			return tong(n - 1) + (double) 1 / deQuy(n);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập n > 0:");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng Sn = " + tong(n));
	}
}
