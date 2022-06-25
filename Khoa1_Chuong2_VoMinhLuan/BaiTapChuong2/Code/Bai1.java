import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		int number;
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số thứ nhất:");
		number = Integer.parseInt(scan.nextLine());
		System.out.println("Mời bạn nhập số thứ hai:");
		number += Integer.parseInt(scan.nextLine());
		System.out.println("Mời bạn nhập số thứ ba:");
		number += Integer.parseInt(scan.nextLine());
		System.out.println("Mời bạn nhập số thứ tư:");
		number += Integer.parseInt(scan.nextLine());
		System.out.println("Mời bạn nhập số thứ năm:");
		number += Integer.parseInt(scan.nextLine());
		float average = (float) number / 5;
		System.out.println("Giá trị trung bình của 5 số là: " + average);
	}

}
