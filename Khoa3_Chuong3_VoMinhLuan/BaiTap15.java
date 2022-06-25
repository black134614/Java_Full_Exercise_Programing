import java.util.Scanner;

public class BaiTap15 {
	public static double tong(int n) {
		if (n == 0) {
			return 1;
		} else {
			return tong(n - 1) + (double) 1 / (2 * n + 1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập n > 0:");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng Sn = " + tong(n));
	}
}
