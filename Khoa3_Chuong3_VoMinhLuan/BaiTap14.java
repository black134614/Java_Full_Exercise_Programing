import java.util.Scanner;

public class BaiTap14 {
	public static int xacDinhSoChan(int n) {
		if (n % 2 == 0) {
			return n;
		}
		else return 0;
	}
	
	public static int tong(int n) {
		if (n < 10) {
			return xacDinhSoChan(n);
		} else {
			return xacDinhSoChan(n % 10) + tong(n / 10);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập chữ số nguyên dương n = ");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Tổng các chữ số chẵn của n là = " + tong(n));
	}
}
