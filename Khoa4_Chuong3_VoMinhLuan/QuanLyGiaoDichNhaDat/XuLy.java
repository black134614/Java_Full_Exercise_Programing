import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class XuLy {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		DanhSachGiaoDich danhSachGD = new DanhSachGiaoDich();
		// dummy data for test
		danhSachGD.dummyData();
		doMenu(danhSachGD);
	}

	private static void inMenu() {
		System.out.println("\nVui lòng chọn thực hiện:");
		System.out.println("1. Nhập giao dịch");
		System.out.println("2. Tổng giao dịch đất");
		System.out.println("3. Tổng giao dịch nhà");
		System.out.println("4. Trung bình thành tiền giao dịch đất");
		System.out.println("5. Xuất ra các giao dịch của tháng 9 năm 2013");
		System.out.println("6. Xuất tất cả giao dịch");
		System.out.println("0. Thoát");
	}

	private static void doMenu(DanhSachGiaoDich danhSachGD) throws ParseException {
		// format tiền tệ
		Locale locale = new Locale("vi", "VN");
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		do {

			inMenu();
			System.out.print("Mời chọn:");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				danhSachGD.nhap(scan);
				break;
			case 2:
				danhSachGD.tinhTongGiaoDichDat();
				System.out.println("Tổng giao dịch đất là: " + danhSachGD.getTongGDDat());
				break;
			case 3:
				danhSachGD.tinhTongGiaoDichNha();
				System.out.println("Tổng giao dịch nhà là: " + danhSachGD.getTongGDNha());
				break;
			case 4:
				danhSachGD.tinhTBThanhTienGDDat();
				System.out.println("Trung bình thành tiền giao dịch đất là: " + currencyFormatter.format(danhSachGD.getTBThanhTienGDDat()));
				break;
			case 5:
				danhSachGD.xuatTheoDK();
				break;
			case 6:
				danhSachGD.xuat();
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
}
