import java.util.Scanner;
/*
 * Mục đích: Quản lý thông tin giáo viên , học sinh của trường học
 * Người tạo: Minh Luân
 * Ngày tạo: 06/01/2021
 * Version: 1.0
 * */

public class ThongTin implements NhapXuat {
	// 1. attributes
	// Mã cá nhân để quản lý thông tin
	protected String maCaNhan;
	protected String hoten;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;

	// 2. get, set
	public String getMaCaNhan() {
		return maCaNhan;
	}

	public void setMaCaNhan(String maCaNhan) {
		this.maCaNhan = maCaNhan;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public String getNoiSinh() {
		return noiSinh;
	}

	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	// 3. constructor
	public ThongTin() {
		// TODO Auto-generated constructor stub
	}

	public ThongTin(String maCaNhan, String hoTen, int namSinh, String noiSinh, String diaChi) {
		this.maCaNhan = maCaNhan;
		this.hoten = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	// 4. input, output
	@Override
	public void xuat() {
		System.out.print("Mã cá nhân " + this.maCaNhan + "\t Họ tên " + this.hoten + "\t Năm sinh: " + this.namSinh
				+ "\t Nơi sinh: " + this.noiSinh + "\t Địa chỉ: " + this.diaChi + "\t");
	}

	@Override
	public void nhap(Scanner scan) {
		System.out.println("Mã cá nhân:");
		this.maCaNhan = scan.nextLine();
		
		System.out.println("Họ tên:");
		this.hoten = scan.nextLine();

		System.out.println("Năm sinh:");
		this.namSinh = Integer.parseInt(scan.nextLine());

		System.out.println("Nơi sinh: ");
		this.noiSinh = scan.nextLine();

		System.out.println("Địa chỉ:");
		this.diaChi = scan.nextLine();
	}
	// 5. bussiness methods
	
}
