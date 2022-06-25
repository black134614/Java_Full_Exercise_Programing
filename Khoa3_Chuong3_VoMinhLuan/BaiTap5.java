import java.util.Scanner;

public class BaiTap5 {
	public static double tong(int n) {
		if (n == 2) {
			return (double)1 / 2;
		} else {
			return (double) 1 / (n * (n - 1)) + tong(n -1);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập n > 0:");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng Sn = " + tong(n));
	}
}
