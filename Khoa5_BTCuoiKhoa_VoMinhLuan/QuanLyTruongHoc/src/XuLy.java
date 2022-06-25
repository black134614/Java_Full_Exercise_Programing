import java.util.ArrayList;
import java.util.Scanner;

public class XuLy {

	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		TruongHoc truong = new TruongHoc();
		// tạo dữ liệu từ file
		truong.taoDuLieuHocSinh();
		truong.taoDuLieuGiaoVien();
		truong.dummyData();
		
		doMenu(truong);
	}

	private static void inMenu() {
		System.out.println("Vui lòng chọn thực hiện:");
		System.out.println("1. Thêm học sinh, giáo viên");
		System.out.println("2. Xuất danh sách học sinh");
		System.out.println("3. Xuất danh sách giáo viên");
		System.out.println("4. Cập nhật thông tin HS / GV");
		System.out.println("5. Xuất giáo viên có thâm niên cao nhất");
		System.out.println("6. Xuất giáo viên có thâm niên > 5 và thuộc khối tự nhiên");
		System.out.println("7. Xuất học sinh có điểm trung bình cao nhất");
		System.out.println("8. Xuất danh sách học sinh sắp xếp theo điểm trung bình");
		System.out.println("9. Xuất danh sách học sinh sắp xếp theo tên");
		System.out.println("0. Thoát");
	}

	private static void doMenu(TruongHoc truong) {
		boolean flag = true;
		Scanner scan = new Scanner(System.in);
		do {
			inMenu();
			System.out.print("Mời chọn:");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				truong.nhap(scan);
				break;
			case 2:
				truong.tinhDiemTrungBinh();
				truong.xepLoaiHocSinh();
				truong.xuatHocSinh();
				break;
			case 3:
				truong.tinhThamNienGV();
				truong.xuatGiaoVien();
				break;
			case 4:
				//Bug dữ liệu nhập từ file không nhận được mã cá nhân là int và khi sử dụng String thì dòng đầu tiên không tìm được.
				truong.capNhatThongTin(scan);
				break;
			case 5:
				//tính thâm niên trước
				truong.tinhThamNienGV();
				//Tìm & Xuất danh sách giáo viên có thâm niên cao nhất 
				ArrayList<ThongTin> list = truong.timGVThamNienCaoNhat();
				for (ThongTin cx : list) {
					cx.xuat();
				}
				break;
			case 6:
				//tính thâm niên trước
				truong.tinhThamNienGV();
				//Tìm & Xuất danh sách giáo viên có thâm niên cao nhất 
				list = truong.timGVKhoiTuNhien();
				for (ThongTin cx : list) {
					cx.xuat();
				}
				break;
			case 7:
				//tính điểm trung bình, xếp loại trước
				truong.tinhDiemTrungBinh();
				truong.xepLoaiHocSinh();
				
				truong.xepLoaiHocSinh();
				
				//Tìm & Xuất danh sách giáo viên có thâm niên cao nhất 
				list = truong.timHSCoDTBCaoNhat();
				for (ThongTin cx : list) {
					cx.xuat();
				}
				break;
			case 8:
				truong.tinhDiemTrungBinh();
				truong.sapXepDSHS();
				break;
			case 9:
				truong.sapSepHSTheoTen();
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}
	
}
