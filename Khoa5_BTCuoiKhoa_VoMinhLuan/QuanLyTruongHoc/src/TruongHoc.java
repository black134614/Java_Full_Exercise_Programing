import java.util.ArrayList;
import java.util.Scanner;

/*
 * Mục đích: Quản lý các nghiệp vụ liên quan đến thông tin của trường
 * Người tạo: Minh Luân
 * Ngày tạo: 06/01/2022
 * Version: 1.0
 * */
public class TruongHoc implements NhapXuat {
	// 1. attributes
	private DanhSachThongTin DSThongTin = new DanhSachThongTin();

	// 2. get, set
	public DanhSachThongTin getDSThongTin() {
		return DSThongTin;
	}

	public void setDSThongTin(DanhSachThongTin dSThongTin) {
		DSThongTin = dSThongTin;
	}

	// 3. constructor
	public TruongHoc() {
		// TODO Auto-generated constructor stub
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		this.DSThongTin.nhap(scan);
	}

	@Override
	public void xuat() {
		this.DSThongTin.xuat();
	}

	// 5. business methods
	public void themThongTin(Scanner scan) {
		this.DSThongTin.nhap(scan);
	}

	public void xuatHocSinh() {
		this.DSThongTin.xuatHocSinh();
	}

	public void xuatGiaoVien() {
		this.DSThongTin.xuatGiaoVien();
	}

	public void tinhDiemTrungBinh() {
		this.DSThongTin.tinhDiemTrungBinh();
	}

	public void xepLoaiHocSinh() {
		this.DSThongTin.xepLoaiHocSinh();
	}

	public void taoDuLieuHocSinh() {
		this.DSThongTin.taoDuLieuHocSinh();
	}

	public void taoDuLieuGiaoVien() {
		this.DSThongTin.taoDuLieuGiaoVien();
	}

	public void dummyData() {
		this.DSThongTin.dummyData();
	}

	public void capNhatThongTin(Scanner scan) {
		this.DSThongTin.capNhatThongTin(scan);
	}

	public void tinhThamNienGV() {
		this.DSThongTin.tinhThamNienGV();
	}

	public ArrayList<ThongTin> timGVThamNienCaoNhat() {
		return this.DSThongTin.timGVThamNienCaoNhat();
	}

	public ArrayList<ThongTin> timGVKhoiTuNhien() {
		return this.DSThongTin.timGVKhoiTuNhien();
	}

	public ArrayList<ThongTin> timHSCoDTBCaoNhat() {
		return this.DSThongTin.timHSCoDTBCaoNhat();
	}

	public void sapXepDSHS() {
		this.DSThongTin.sapXepDSHS();
	}

	public void sapSepHSTheoTen() {
		this.DSThongTin.sapSepHSTheoTen();
	}

}
