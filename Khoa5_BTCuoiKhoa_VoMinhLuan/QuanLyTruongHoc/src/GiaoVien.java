import java.time.LocalDate;
import java.util.Scanner;

/*
 * Mục đích: Quản lý thông tin giáo viên
 * Người tạo: Minh Luân
 * Ngày tạo: 06/01/2021
 * Version: 1.0
 * */
public class GiaoVien extends ThongTin {
	// 1. attribute
	private int namBatDauDay;
	// t: chuyên môn tự nhiên, x: chuyên môn xã hội.
	private char chuyenMon;
	private int thamNien;

	// 2. get , set
	public int getNamBatDauDay() {
		return namBatDauDay;
	}

	public void setNamBatDauDay(int namBatDauDay) {
		this.namBatDauDay = namBatDauDay;
	}

	public char getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(char chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	public int getThamNien() {
		return thamNien;
	}

	public void setThamNien(int thamNien) {
		this.thamNien = thamNien;
	}
	// 3. constructor
	public GiaoVien() {
		super();
	}

	public GiaoVien(String maCaNhan, String hoTen, int namSinh, String noiSinh, String diaChi, int namBatDauDay,
			char chuyenMon) {
		super(maCaNhan, hoTen, namSinh, noiSinh, diaChi);
		this.namBatDauDay = namBatDauDay;
		this.chuyenMon = chuyenMon;
		this.thamNien = 0;
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.println("Năm bắt đầu dạy:");
		this.namBatDauDay = Integer.parseInt(scan.nextLine());

		System.out.println("Chuyên môn dạy:");
		System.out.println("T: Tự nhiên, X: Xã hội");
		boolean flag = false;
		do {
			this.chuyenMon = Character.toUpperCase(scan.nextLine().charAt(0));
			if (this.chuyenMon != 'T' & this.chuyenMon != 'X') {
				System.out.println("Nhập lại chuyên môn: (T: tự nhiên, X: xã hội) ");
				flag = true;
			} else
				flag = false;
		} while (flag);
	}

	@Override
	public void xuat() {
		super.xuat();
		// temp để chuyển kí tự chuyên môn thành chuỗi.
		String temp = "";
		if (this.chuyenMon == 'T') {
			temp = "Tự Nhiên";
		} else
			temp = "Xã hội";
		System.out.println("Năm bắt đầu dạy: " + this.namBatDauDay + "\t Chuyên môn: " + temp + "\t Thâm niên: " + this.thamNien);
	}
	// 5. business methods

	//Tính thâm niên giáo viên
	public int tinhThamNiem() {
		LocalDate currentDate = LocalDate.now();
		return this.thamNien = currentDate.getYear() - this.namBatDauDay;
	}
}
