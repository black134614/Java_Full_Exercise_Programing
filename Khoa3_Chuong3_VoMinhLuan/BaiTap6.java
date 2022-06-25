import java.util.Scanner;

public class BaiTap6 {
	public static double tong(int x, int n) {
		if (n == 1) {
			return x;
		} else {
			return Math.pow(x, n) + tong(x, n - 1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập x");
		int x = Integer.parseInt(scan.nextLine());
		System.out.println("Mời bạn nhập n > 0:");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng Sn = " + tong(x, n));
	}
}
