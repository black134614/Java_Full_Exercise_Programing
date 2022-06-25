import java.util.Scanner;

public class BaiTapNop6 {

	public static void tinhSoNamMuaXe(Scanner scan) {
		boolean flag = false;
		float laiSuatNam = 0;
		long tienGui = 0, tienMuaXe =0; //tiền mua xe tiền gửi là tiền tỉ.
		
		do {
			System.out.println("Mời bạn nhập số tiền gửi:");
			tienGui = Long.parseLong(scan.nextLine());
			flag = kiemTraSoNguyenDuong(tienGui);
			if (flag) {
				System.out.println("Nhập số tiền lớn hơn 0");
			}
		}
		while(flag);
		
		do {
			System.out.println("Mời bạn nhập số tiền cần để mua xe:");
			tienMuaXe = Long.parseLong(scan.nextLine());
			flag = kiemTraSoNguyenDuong(tienMuaXe);
			if (flag) {
				System.out.println("Nhập số tiền mua xe lớn hơn 0");
				continue;
			}
			if (tienGui >= tienMuaXe) {
				System.out.println("Nhập số tiền mua xe lớn hơn tiền gửi");
				flag = true;
				continue;
			}
		}
		while(flag);
		
		do {
			System.out.println("Mời bạn nhập lãi suất năm của ngân hàng: (%)");
			laiSuatNam = Float.parseFloat(scan.nextLine());
			flag = kiemTraSoNguyenDuong(laiSuatNam);
			if (flag) {
				System.out.println("Nhập lãi suất hơn 0.");
			}
		}
		while(flag);
		
		short soNam = 0;
		double tongTienTietKiem = 0;
		do {
			tongTienTietKiem += tienLaiCua1Nam(tienGui, laiSuatNam);
			soNam ++;
		}
		while(tienMuaXe > (tienGui + tongTienTietKiem));
		
		System.out.println("Tổng số năm để bạn mua được xe là: " + soNam);
	}
	
	public static int tienLaiCua1Nam(double tienGui, float laiSuat) {
		return (int) (tienGui * laiSuat / 100); //Lãi 1 năm không lớn hơn 2 tỉ vài trăm triệu
	}

	public static Boolean kiemTraSoNguyenDuong(double n) { //double vì có dùng chung cho lãi xuất.
		if (n <= 0) {
			return true; // nhập lại
		} else
			return false; // ok
	}

	public static void main(String arg[]) {
		// Nhập tiền gửi , lãi suất của một năm tiết kiêm, tiền mua ô tô
		// Tiền gửi , lãi, tiền mua ô tô lớn hơn 0
		// Xuất số năm chờ đợi
		Scanner scan = new Scanner(System.in);
		tinhSoNamMuaXe(scan);
	}
}
