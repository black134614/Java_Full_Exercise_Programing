import java.util.Scanner;

public class BaiTap2 {

	public static double tong(int n) {
		if (n == 0) {
			return 0;
		} else {
			return Math.sqrt(n + tong(n - 1));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập n > 0:");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng Rn = " + tong(n));
	}
}
