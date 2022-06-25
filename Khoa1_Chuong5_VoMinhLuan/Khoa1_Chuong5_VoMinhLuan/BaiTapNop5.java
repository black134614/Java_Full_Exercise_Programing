import java.util.Scanner;

public class BaiTapNop5 {

	public static void tinhGiaiThua(Scanner scan) {
		boolean flag = false;
		short n = 0;
		do {
			System.out.println("Mời bạn nhập số nguyên dương n >= 0 :");
			n = Short.parseShort(scan.nextLine());
			flag = kiemTraSoNguyenDuong(n);
			if (flag) {
				System.out.println("Vui lòng nhập số dương n lớn hơn hoặc bằng 0.");
				continue;
			}
		}
		while(flag);
		
		System.out.println("Kết quả giai thừa của " + n + "! là: " + giaiThua(n));
	}
	
	public static long giaiThua(short n) {
		long ketQua = 1;
		switch (n) {
		case 0: case 1: {
			ketQua = 1;
		}
		default:
			for (int i = 1; i <= n; i++) {
				ketQua *= i;
			}
		}
		return ketQua;
	}
	
	public static Boolean kiemTraSoNguyenDuong(int n) {
		if (n < 0) {
			return true; // nhập lại
		} else
			return false; //ok
	}

	public static void main(String[] args) {
		/*
		 * Thông báo nhập n >= 0
		 */
		Scanner scan =  new Scanner(System.in);
		tinhGiaiThua(scan);
	}

}
