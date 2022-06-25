import java.util.Scanner;

public class BaiTapNop4 {

	public static void timKetQua(Scanner scan) {
		System.out.println("Mời bạn nhập số nguyên X :");
		short x = Short.parseShort(scan.nextLine());
		System.out.println("Mời bạn nhập số nguyên n :");
		short n = Short.parseShort(scan.nextLine());
		
		long ketQua = 0; //Lưu gia trị lớn 
		for (int i = 1; i <= n; i++) {
			ketQua += tinhLuyThua(x, i);
		}
		
		System.out.println("Kết quả theo yêu cầu đề bài : " + ketQua);
	}

	 public static long tinhLuyThua(int coSo, int soMu) {
	        long ketQua = 1;
	         
	        for (int i = 0; i < soMu; i++) {
	            ketQua *= coSo;
	        }
	        return ketQua;
	    }

	public static void main(String arg[]) {
		/*
		 * Thông báo nhập n và x
		 * không cần check nhập âm dương
		 * Tìm tổng lũy thừa s(n) = x +.... x^n 
		 */
		Scanner scan = new Scanner(System.in);
		timKetQua(scan);
	}

}
