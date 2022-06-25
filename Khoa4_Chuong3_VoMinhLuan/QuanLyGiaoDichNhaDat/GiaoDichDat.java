import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
/*
 * Mục đích: Lớp con quản lý các giao dịch đất
 * Người tạo: Minh Luân
 * Ngày tạo: 04/01/2022
 * Version: 1.0
 * */
public class GiaoDichDat extends GiaoDich {
	// 1. attributes
	private char loaiDat;
	private double thanhTien;
	// format tiền tệ
	Locale locale = new Locale("vi", "VN");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	// 2. get, set
	/**
	 * @return the loaiDat
	 */
	public char getLoaiDat() {
		return loaiDat;
	}

	/**
	 * @param loaiDat the loaiDat to set
	 */
	public void setLoaiDat(char loaiDat) {
		this.loaiDat = loaiDat;
	}

	/**
	 * @return the thanhTien
	 */
	public double getThanhTien() {
		return thanhTien;
	}

	// 3. constructor
	public GiaoDichDat() {
		super();
	}

	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 * @param loaiDat
	 */
	public GiaoDichDat(int maGiaoDich, String ngayGiaoDich, float dienTich, double donGia, char loaiDat) {
		super(maGiaoDich, ngayGiaoDich, dienTich, donGia);
		this.loaiDat = loaiDat;
		if (loaiDat == 'A') {
			this.thanhTien = donGia * dienTich * 1.5f;
		} else
			this.thanhTien = donGia * dienTich;
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		boolean flag = false;
		System.out.println("Nhập loại đất (A,B,C):");
		Locale ENGLISH = Locale.forLanguageTag("en");
		do {
			this.loaiDat = Character.toUpperCase(scan.nextLine().charAt(0));
			if (this.loaiDat != 'A' & this.loaiDat != 'B' & this.loaiDat != 'C') {
				System.out.println("Nhập lại loại đất (nhập A, B hoặc C): ");
				flag = true;
			} else
				flag = false;
		} while (flag);
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out.println("\t Loại Đất: " + this.loaiDat + "\t Thành tiền: " + currencyFormatter.format(this.thanhTien));
	}
	// 5. business methods

}
