import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/*
 * Mục đích: Lớp cha quản lý các giao dịch cả nhà và đất
 * Người tạo: Minh Luân
 * Ngày tạo: 04/01/2022
 * Version: 1.0
 * */
public class GiaoDich {
	// 1. Attributes
	protected int maGiaoDich;
	protected String ngayGiaoDich;
	protected double donGia;
	protected float dienTich;
	// format tiền tệ
	Locale locale = new Locale("vi", "VN");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	// 2. get, set
	/**
	 * @return the maGiaoDich
	 */
	public int getMaGiaoDich() {
		return maGiaoDich;
	}

	/**
	 * @param maGiaoDich the maGiaoDich to set
	 */
	public void setMaGiaoDich(int maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}

	/**
	 * @return the ngayGiaoDich
	 */
	public String getNgayGiaoDich() {
		return ngayGiaoDich;
	}

	/**
	 * @param ngayGiaoDich the ngayGiaoDich to set
	 */
	public void setNgayGiaoDich(String ngayGiaoDich) {
		this.ngayGiaoDich = ngayGiaoDich;
	}

	/**
	 * @return the donGia
	 */
	public double getDonGia() {
		return donGia;
	}

	/**
	 * @param donGia the donGia to set
	 */
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	/**
	 * @return the dienTich
	 */
	public float getDienTich() {
		return dienTich;
	}

	/**
	 * @param dienTich the dienTich to set
	 */
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}

	// 3. constructor
	public GiaoDich() {
	}

	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 */
	public GiaoDich(int maGiaoDich, String ngayGiaoDich, float dienTich, double donGia) {
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	// 4. input, output
	public void nhap(Scanner scan) {
		System.out.println("Nhập mã giao dịch: ");
		this.maGiaoDich = Integer.parseInt(scan.nextLine());

		// Kiểm tra date nhập ngày
		boolean flag = false;
		System.out.println("Nhập ngày gia dịch (dd/MM/yyyy): ");
		String stringDateInput = "";
		do {
			stringDateInput = scan.nextLine();
			if (isValidDate(stringDateInput) == false) {
				flag = true;
				System.out.println("Nhập sai định dạng ngày. Nhập lại.");
			} else {
				flag = false;
			}
		} while (flag);
		this.ngayGiaoDich = stringDateInput;

		System.out.println("Nhập đơn giá:");
		this.donGia = Double.parseDouble(scan.nextLine());

		System.out.println("Nhập diện tích:");
		this.dienTich = Float.parseFloat(scan.nextLine());

	}

	public void xuat() {
		System.out.print("Mã giao dich: " + this.maGiaoDich + "\t Ngày giao dịch: " + this.ngayGiaoDich + "\t Đơn giá: "
				+ currencyFormatter.format(this.donGia) + "\t Diện tích: " + this.dienTich);
	}

	// 5. business methods
	// 6. Support Function

	// xác định ngày đúng định dạng
	public boolean isValidDate(String dateStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(dateStr);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}
