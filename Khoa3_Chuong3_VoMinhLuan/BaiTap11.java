import java.util.Scanner;

public class BaiTap11 {
	public static int xacDinhSoLe(int n) {
		if (n % 2 == 0) {
			return 0;
		}
		else return 1;
	}
	
	public static int tong(int n) {
		if (n < 10) {
			return xacDinhSoLe(n);
		} else {
			return xacDinhSoLe(n % 10) + tong(n / 10);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập chữ số nguyên dương n = ");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Số lượng các chữ số lẻ của n là = " + tong(n));
	}
}
