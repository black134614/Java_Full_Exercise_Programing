import java.util.Scanner;

public class BaiTap12 {
	public static long tong(int n) {
		if (n < 10) {
			return n;
		} else {
			return tong(n / 10);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập chữ số nguyên dương n = ");
		int n = Integer.parseInt(scan.nextLine());
		System.out.println("Chữ số đầu tiên của chữ số n là = " + tong(n));
	}
}
