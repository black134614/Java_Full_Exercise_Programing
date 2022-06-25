import java.util.Scanner;

public class Bai1 {
	// Hàm thông báo kết quả
	// Hàm xử lý điểm cộng khu vực
	// Hàm xử lý điểm cộng đối tượng
	// Hàm tính tổng điểm
	// Hàm xét điểm
	public static float diemKhuVuc(char khuVuc) {
		khuVuc = Character.toUpperCase(khuVuc);
		switch (khuVuc) {
		case 'A':
			return 2;
		case 'B':
			return 1;
		case 'C':
			return 0.5f;
		default:
			return 0;
		}
	}

	public static float diemDoiTuong(short doiTuong) {
		switch (doiTuong) {
		case 1:
			return 2.5f;
		case 2:
			return 1.5f;
		case 3:
			return 1;
		default:
			return 0;
		}
	}

	public static boolean xetDiem(float diemChuan, float diemMon1, float diemMon2, float diemMon3, float tongDiem) {
		if (diemMon1 == 0 | diemMon2 == 0 | diemMon3 == 0 | diemChuan > tongDiem) {
			return true;
			//true là thi rớt
		} else
			return false;
			//false là thi đậu
	}
	
	public static void inKetQua(float tongDiem, boolean thiRot ) {
		System.out.println("Tổng điểm của bạn là :" + tongDiem);
		if(thiRot) {
			System.out.println("Bạn đã thi rớt");
		}
		else 
			System.out.println("Bạn đã thi đậu");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final float diemChuan;
		float diemMon1, diemMon2, diemMon3, tongDiem;
		float diemCongThem = 0;
		Boolean thiRot;

		System.out.println("Nhập điểm chuẩn của trường: ");
		diemChuan = Float.parseFloat(scan.nextLine());
		System.out.println("Nhập điểm môn thi thứ 1: ");
		diemMon1 = Float.parseFloat(scan.nextLine());
		System.out.println("Nhập điểm môn thi thứ 2: ");
		diemMon2 = Float.parseFloat(scan.nextLine());
		System.out.println("Nhập điểm môn thi thứ 3: ");
		diemMon3 = Float.parseFloat(scan.nextLine());

		System.out.println("Nhập khu vực ưu tiên\nA. Khu vực A\nB.Khu vực B\nC.Khu vực C");
		diemCongThem += diemKhuVuc(scan.nextLine().charAt(0));
		// Nhập khác A,B,C,X hàm diemKhuVuc đều trả 0;

		System.out.println("Nhập đối tượng được hưởng điểm cộng\n1. Đối tượng 1\n2.Đối tượng 2\n3.Đối tượng 3");
		diemCongThem += diemDoiTuong(Short.parseShort(scan.nextLine()));
		// Nhập khác 1,2,3,0 hàm diemDoiTuong đều trả 0;

		//Xét đậu rớt
		tongDiem = diemMon1 + diemMon2 + diemMon3 + diemCongThem;
		thiRot = xetDiem(diemChuan, diemMon1, diemMon2, diemMon3, tongDiem);
		//in kết quả
		inKetQua(tongDiem, thiRot);
	}

}
