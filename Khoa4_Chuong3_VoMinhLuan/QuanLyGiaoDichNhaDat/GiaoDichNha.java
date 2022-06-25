import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 * Mục đích: Lớp con quản lý các giao dịch nhà
 * Người tạo: Minh Luân
 * Ngày tạo: 04/01/2022
 * Version: 1.0
 * */
public class GiaoDichNha extends GiaoDich {
	// 1. attribute
	private char loaiNha;
	private double thanhTien;
	// format tiền tệ
	Locale locale = new Locale("vi", "VN");
	NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

	// 2. get, set
	/**
	 * @return the loaiNha
	 */
	public char getLoaiNha() {
		return loaiNha;
	}

	/**
	 * @param loaiNha the loaiNha to set
	 */
	public void setLoaiNha(char loaiNha) {
		this.loaiNha = loaiNha;
	}

	/**
	 * @return the thanhTien
	 */
	public double getThanhTien() {
		return thanhTien;
	}

	// 3. constructor
	public GiaoDichNha() {
		super();
	}

	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 * @param loaiNha
	 */
	public GiaoDichNha(int maGiaoDich, String ngayGiaoDich, float dienTich, double donGia, char loaiNha) {
		super(maGiaoDich, ngayGiaoDich, dienTich, donGia);
		this.loaiNha = loaiNha;
		if (loaiNha == 'C') {
			this.thanhTien = donGia * dienTich;
		} else
			this.thanhTien = donGia * dienTich * 0.9f;
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		boolean flag = false;
		System.out.println("Nhập loại nhà (C, T) ");
		System.out.println("C: nhà cao cấp, T: nhà loại thường:");
		Locale ENGLISH = Locale.forLanguageTag("en");
		do {
			this.loaiNha = Character.toUpperCase(scan.nextLine().charAt(0));
			if (this.loaiNha != 'T' & this.loaiNha != 'C') {
				System.out.println("Nhập lại loại nhà (nhập T hoặc C): ");
				flag = true;
			} else
				flag = false;
		} while (flag);
	}

	@Override
	public void xuat() {
		super.xuat();
		System.out
				.println("\t Loại nhà: " + this.loaiNha + "\t Thành tiền: " + currencyFormatter.format(this.thanhTien));
	}
	// 5. business methods
}
