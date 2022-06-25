import java.util.Scanner;

public class BaiTap13 {
	public static int soSanh(int a, int b) {
		if (a < b) {
			return b;
		} else
			return a;
	}

	public static int tong(int n) {
		if (n < 10) {
			return soSanh(n % 10, n / 10);
		} else {
			return soSanh(n % 10, tong(n / 10));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập chữ số nguyên dương n = ");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Chữ số lớn nhất của chữ số n là = " + tong(n));
	}
}
