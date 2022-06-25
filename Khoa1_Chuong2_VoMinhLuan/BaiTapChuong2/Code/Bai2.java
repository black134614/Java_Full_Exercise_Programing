import java.util.Scanner;

public class Bai2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int rate = 23500;
		System.out.println("Nhập số tiền USD cần quy đổi:");
		float money = Float.parseFloat(scan.nextLine());
		money *= 23500;
		System.out.println("Số tiền quy đổi là: " + money + " VND");
	}

}
