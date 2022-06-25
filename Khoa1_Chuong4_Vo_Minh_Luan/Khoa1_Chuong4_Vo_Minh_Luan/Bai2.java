import java.util.Scanner;

public class Bai2 {
	
	public static int tinhThuNhapChiuThue (int thuNhapChiuThue ) {
		//Tạo biến tạm để quy ra tiền triệu hay để máy xử lý dữ liệu sẽ ok hơn?
		if (thuNhapChiuThue / 1000000  <= 60) {
			thuNhapChiuThue *= 0.05;
		}
		else if (thuNhapChiuThue / 1000000 > 60 && thuNhapChiuThue / 1000000 <= 120 ) {
			thuNhapChiuThue *= 0.1;	
		}
		else if (thuNhapChiuThue / 1000000 > 120 && thuNhapChiuThue / 1000000 <= 216 ) {
			thuNhapChiuThue *= 0.15;	
		}
		else if (thuNhapChiuThue / 1000000 > 216 && thuNhapChiuThue / 1000000 <= 384 ) { 
			thuNhapChiuThue *= 0.2;	
		}
		else if (thuNhapChiuThue / 1000000 > 384 && thuNhapChiuThue / 1000000 <= 624 ) {
			thuNhapChiuThue *= 0.25;	
		}
		else if (thuNhapChiuThue / 1000000 > 624 && thuNhapChiuThue / 1000000 <= 960 ) {
			thuNhapChiuThue *= 0.3;	
		}	
		else thuNhapChiuThue *= 0.35;
		return thuNhapChiuThue;
	}
	
	public static void inKetQua(int thuNhapChiuThue, String hoTen) {
		System.out.println("Thuế thu nhập cá nhân của" + hoTen + " trong năm nay là: " + thuNhapChiuThue);
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Bạn hãy nhập thông tin\nHọ tên: ");
		String hoTen = scan.nextLine();
		System.out.println("Tổng thu nhập cá nhân: ");
		int thuNhapNam = Integer.parseInt(scan.nextLine()); //Lưu ý: chương trình chỉ hỗ trợ người có thu nhập năm dưới 2 tỉ vài trăm triệu :)
		System.out.println("Số người phụ thuộc: ");
		byte soNguoiPhuThuoc = Byte.parseByte(scan.nextLine());
		
		int thuNhapChiuThue = thuNhapNam - (4000000 + soNguoiPhuThuoc * 1600000); 
		//thuNhapNam - 4 triệu và trừ tiếp 1,6trieu nhân với số người phụ thuộc*
		//Tính thu nhập chịu thuế
		thuNhapChiuThue = tinhThuNhapChiuThue(thuNhapChiuThue);
		//In kết quả
		inKetQua(thuNhapChiuThue, hoTen);
	}
}
