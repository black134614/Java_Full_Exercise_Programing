import java.util.Scanner;

public class BaiTap8 {
	public static double tong(int n) {
		if (n == 0) {
			return 0;
		} else {
			return 1 + tong(n / 10);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập chữ số nguyên dương n = ");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Số lượng chữ số của n là = " + tong(n));
	}
}
