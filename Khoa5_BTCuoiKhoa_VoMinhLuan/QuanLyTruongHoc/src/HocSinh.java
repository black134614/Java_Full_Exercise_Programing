import java.util.Scanner;

/*
 * Mục đích: Quản lý thông tin học sinh và nghiệp vụ tính điểm trung bình và xếp loại
 * Người tạo: Minh Luân
 * Ngày tạo: 06/01/2021
 * Version: 1.0
 * */
public class HocSinh extends ThongTin {
	// 1. attributes
	private float diemToan;
	private float diemVan;
	private float diemNgoaiNgu;
	private float diemTrungBinh;
	private String xepLoai;

	// 2. get, set
	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	public float getDiemNgoaiNgu() {
		return diemNgoaiNgu;
	}

	public void setDiemNgoaiNgu(float diemNgoaiNgu) {
		this.diemNgoaiNgu = diemNgoaiNgu;
	}

	public float getDiemTrungBinh() {
		return diemTrungBinh;
	}

	public String getXepLoai() {
		return xepLoai;
	}

	// 3. constructor
	public HocSinh() {
		// TODO Auto-generated constructor stub
		super();

	}

	public HocSinh(String maCaNhan,String hoTen, int namSinh, String noiSinh, String diaChi, float diemToan, float diemVan,
			float diemNgoaiNgu) {
		// TODO Auto-generated constructor stub
		super(maCaNhan,hoTen, namSinh, noiSinh, diaChi);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
		// khởi tạo
		this.diemTrungBinh = 0;
		this.xepLoai = "Chưa xếp loại";
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		// TODO Auto-generated method stub
		super.nhap(scan);
		System.out.println("Điểm toán:");
		this.diemToan = Float.parseFloat(scan.nextLine());

		System.out.println("Điểm văn:");
		this.diemVan = Float.parseFloat(scan.nextLine());

		System.out.println("Điểm ngoại ngữ:");
		this.diemNgoaiNgu = Float.parseFloat(scan.nextLine());
	}

	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		super.xuat();
		System.out.println("Điểm toán: " + this.diemToan + "\t Điểm văn: " + this.diemVan + "\t Điểm ngoại ngữ: "
				+ this.diemNgoaiNgu + "\t Điểm trung bình: " + this.diemTrungBinh + "\t Xếp loại: " + this.xepLoai);
	}

	// 5. business methods
	// điểm trung bình bằng trung bình 3 môn văn, toán, ngoại ngữ
	public Float tinhDiemTrungBinh() {
		return this.diemTrungBinh = (float) Math.round((this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3 * 10) / 10;
	}

	// Xếp loại học sinh
	public void xepLoai() {
		if (this.diemTrungBinh >= 9) {
			this.xepLoai = "Xuất Sắc";
		} else if (this.diemTrungBinh >= 8) {
			this.xepLoai = "Giỏi";
		} else if (this.diemTrungBinh >= 7) {
			this.xepLoai = " Khá";
		} else if (this.diemTrungBinh >= 5) {
			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}
	}

}
