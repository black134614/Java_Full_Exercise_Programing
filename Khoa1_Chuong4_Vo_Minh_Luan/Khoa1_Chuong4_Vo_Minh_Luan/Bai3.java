import java.util.Scanner;

public class Bai3 {

	public static int electricPrice(float electricUse) {//return int vì tiền vn nhiều số không không ngại 1-2 số thập phân.
		float accumulated = electricUse / 50; 
		if (accumulated <= 1) {
			return (int) (electricUse * 500);
		} else if (accumulated > 1 & accumulated <= 2) {
			return (int) ((50 * 500) + ((electricUse - 50) * 650));
		} else if (accumulated > 2 & accumulated <= 4) {
			return (int) (50 * 500 + 50 * 650 + (electricUse - 100) * 850);
		} else if (accumulated > 4 & accumulated <= 7) {
			return (int) (50 * 500 + 50 * 650 + 100 * 850 + (electricUse - 200) * 1100);
		} else
			return (int) (50 * 500 + 50 * 650 + 100 * 850 + 250 * +1100 + (electricUse - 350) * 1300);
	}

	public static void printResult(String yourName, float electricUse, int electricPrice) {
		System.out.println("Tiền điện " + electricUse + " của " + yourName + " là: " + electricPrice);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập tên của bạn: ");
		String yourName = scan.nextLine();
		System.out.println("Số Kw điện tiêu thụ: ");
		float electricUse = Float.parseFloat(scan.nextLine()); // Số kí điện có lẻ
		//tính tiền điện
		int electricPrice = electricPrice(electricUse);
		//in kết quả
		printResult(yourName, electricUse, electricPrice);
	}

}
