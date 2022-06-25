import java.util.Scanner;

public class Bai4 {

	public static float tinhPhiXuLyHoaDon(byte maKhachHang) {
		if (maKhachHang == 1) {
			return 4.5f;
		} else
			return 15;
	}

	public static float tinhPhiDichVuCoBan(byte maKhachHang, short ketNoiThem) { // kết nối thêm doanh nghiệp > 127
		switch (maKhachHang) {
		case 1:
			return 20.5f;
		default:
			if (ketNoiThem > 10) {
				return 75 + ((ketNoiThem - 10) * 5);
			} else
				return 75;
		}
	}

	public static float tinhPhiKenhCaoCap(byte maKhachHang, short soKenhCaoCap) { // kênh cao cấp thêm doanh nghiệp >
																					// 127
		switch (maKhachHang) {
		case 1:
			return 7.5f * soKenhCaoCap;
		default:
			return 50 * soKenhCaoCap;
		}
	}

	public static void printBill(byte maKhachHang, String maTaiKhoan, short ketNoiThem, short soKenhCaoCap,
			float phiXuLyHoaDon, float phiDichVuCoBan, float phiKenhCaoCap) {
		switch (maKhachHang) {
		case 1:
			System.out.println("***********************Hóa Đơn cá nhân***********************");
			System.out.println(String.format("%-50s", "Số tài khoản cá nhân:") + maTaiKhoan);
			System.out.println(String.format("%-50s", "Phí xử lý hóa đơn:") + phiXuLyHoaDon);
			System.out.println(String.format("%-50s", "Phí dịch vụ cơ bản:") + phiDichVuCoBan);
			System.out.println(String.format("%-50s", "Phi kênh thuê cao cấp:") + phiKenhCaoCap + " (Kênh c.cấp:" + soKenhCaoCap + ")");
			System.out.println(String.format("%-50s", "Tổng chi phí:") + (phiDichVuCoBan + phiKenhCaoCap + phiXuLyHoaDon));
			break;

		default:
			System.out.println("***********************Hóa Đơn doanh nghiệp***********************");
			System.out.println(String.format("%-50s", "Số tài khoản doanh nghiệp:") + maTaiKhoan);
			System.out.println(String.format("%-50s", "Phí xử lý hóa đơn:") + phiXuLyHoaDon);
			System.out.println(String.format("%-50s", "Phí dịch vụ cơ bản:") + phiDichVuCoBan + " (Kết nối:" + ketNoiThem + ")");
			System.out.println(String.format("%-50s", "Phi kênh thuê cao cấp:") + phiKenhCaoCap + " (Kênh c.cấp:" + soKenhCaoCap + ")");
			System.out.println(String.format("%-50s", "Tổng chi phí:") + (phiDichVuCoBan + phiKenhCaoCap + phiXuLyHoaDon));
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập mã khách hàng\n1. Nhà dân\n2. Doanh nghiệp");
		byte maKhachHang = Byte.parseByte(scan.nextLine()); // Chưa xử lý bắt lỗi nhập
		System.out.println("Nhập số tài khoản: ");
		String soTaiKhoan = scan.nextLine(); // Sô tài khoản có thể bắt đầu bằng con số 0
		//Tính phí xử lý hóa đơn
		float phiXuLyHoaDon = tinhPhiXuLyHoaDon(maKhachHang);

		short ketNoiThem = 0, soKenhCaoCap = 0;
		float phiDichVuCoBan, phiKenhCaoCap;
		if (maKhachHang == 1) { //khách nhà dân
			phiDichVuCoBan = tinhPhiDichVuCoBan(maKhachHang, ketNoiThem);
			//Tính phí kênh cao cấp
			System.out.println("Mời bạn nhập số kênh cao cấp gia đình sử dụng: ");
			soKenhCaoCap = Short.parseShort(scan.nextLine());
			phiKenhCaoCap = tinhPhiKenhCaoCap(maKhachHang, soKenhCaoCap);

			printBill(maKhachHang, soTaiKhoan, ketNoiThem, soKenhCaoCap, phiXuLyHoaDon, phiDichVuCoBan, phiKenhCaoCap);
		} else { //khách doanh nghiệp
			//Tính phí dịch vụ cơ bản doanh nghiệp
			System.out.println("Nhập số kênh doanh nghiệp kết nối thêm");
			ketNoiThem = Short.parseShort(scan.nextLine());
			phiDichVuCoBan = tinhPhiDichVuCoBan(maKhachHang, ketNoiThem);
			//Tính phí kênh cao cấp
			System.out.println("Mời bạn nhập số kênh cao cấp doanh nghiệp sử dụng: ");
			soKenhCaoCap = Short.parseShort(scan.nextLine());
			phiKenhCaoCap = tinhPhiKenhCaoCap(maKhachHang, soKenhCaoCap);
			//in hóa đơn
			printBill(maKhachHang, soTaiKhoan, ketNoiThem, soKenhCaoCap, phiXuLyHoaDon, phiDichVuCoBan, phiKenhCaoCap);
		}

	}

}
