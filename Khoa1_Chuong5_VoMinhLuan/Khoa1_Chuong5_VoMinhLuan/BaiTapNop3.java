import java.util.Scanner;

public class BaiTapNop3 {

	public static void timTongSoLeNhoHonN(Scanner scan) {
		System.out.println("Mời bạn nhập số nguyên dương n:");
		int n = 0;
		long tongSoLe = 0; //vì n int ==> tổng phải có kiểu dữ liệu lưu gia trị lớn hơn n để đảm bảo lưu được giá trị đúng.
		boolean flag = false;
		do {
			n = Integer.parseInt(scan.nextLine());
			flag = kiemTraSoNguyenDuong(n);
			if (flag) {
				System.out.println("Mời bạn nhập lại số dương n lớn hơn 0");
				continue;
			}
			tongSoLe = tinhTongSoLe(n);
		} while (flag);

		System.out.println("Tổng các số lẻ nhỏ hơn n là : " + tongSoLe);
	}

	public static long tinhTongSoLe(int n) {
		long tongSoLe = 0;
		for (int i = 1; i < n; i+=2) {
			tongSoLe += i;
		}
		return tongSoLe;
	}
	
	public static Boolean kiemTraSoNguyenDuong(int n) {
		if (n <= 0) {
			return true; // nhập lại
		} else
			return false; //ok
	}

	public static void main(String arg[]) {
		/*
		 * Thông báo nhập n > 0 
		 * Cờ check nhập
		 *  Tìm tổng của các số lẻ nguyên dương bé hơn n
		 */
		Scanner scan = new Scanner(System.in);
		timTongSoLeNhoHonN(scan);
	}
}
