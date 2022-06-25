import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Mục đích: Quản lý thông tin danh sách thông tin của toàn trường 
 * Nghiệp vụ: nhập, xuất, tạo dữ liệu từ file, dummy data, cập nhật thông tin cá nhân học sinh, giáo viên, 
 * 				Tìm học sinh có điểm trung bình cao nhất, Sắp xếp danh sách học sinh giảm dần theo DTB bằng quick sort,
 * 				Sắp xếp danh sách học sinh theo họ tên và tăng dần theo bảng chữ cái ABC 
 * Người tạo: Minh Luân
 * Ngày tạo: 06/01/2021
 * Version: 1.0
 * */
public class DanhSachThongTin implements NhapXuat {
	// 1. attributes
	private ArrayList<ThongTin> DSThongTin;

	// 2. get, set
	public ArrayList<ThongTin> getDSThongTin() {
		return DSThongTin;
	}

	public void setDSThongTin(ArrayList<ThongTin> dSThongTin) {
		DSThongTin = dSThongTin;
	}

	// 3. constructor
	public DanhSachThongTin() {
		// TODO Auto-generated constructor stub
		init();

	}

	public void init() {
		this.DSThongTin = new ArrayList<ThongTin>();
	}

	// 4. input, output
	@Override
	public void nhap(Scanner scan) {
		ThongTin thongTin;
		boolean flag = true;
		do {
			System.out.println("Nhập 1. Nhập học sinh");
			System.out.println("Nhập 2. Nhập giáo viên");
			System.out.println("Nhập 0. Thoát nhập");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				thongTin = new HocSinh();
				thongTin.nhap(scan);
				this.DSThongTin.add(thongTin);
				break;
			case 2:
				thongTin = new GiaoVien();
				thongTin.nhap(scan);
				this.DSThongTin.add(thongTin);
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

	// xuất tất cả
	@Override
	public void xuat() {
		// TODO Auto-generated method stub
		for (ThongTin thongTin : DSThongTin) {
			thongTin.xuat();
		}
	}

	public void xuatHocSinh() {
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof HocSinh) {
				thongTin.xuat();
			}
		}
	}

	public void xuatGiaoVien() {
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof GiaoVien) {
				thongTin.xuat();
			}
		}
	}
	// 5. business methods

	public void tinhDiemTrungBinh() {
		for (ThongTin thongTin : this.DSThongTin) {
			if (thongTin instanceof HocSinh) {
				// Casting thongTin thành hocSinh
				HocSinh hocSinh = ((HocSinh) thongTin);
				hocSinh.tinhDiemTrungBinh();
			}
		}
	}

	public void xepLoaiHocSinh() {
		for (ThongTin thongTin : this.DSThongTin) {
			if (thongTin instanceof HocSinh) {
				// Casting thongTin thành hocSinh
				HocSinh hocSinh = ((HocSinh) thongTin);
				hocSinh.xepLoai();
			}
		}
	}

	// Khởi tạo có tham số
	public void dummyData() {
		ThongTin thongTin = new HocSinh("13", "1", 1998, "Tây Ninh", "Tây Ninh", 7, 6, 8);
		DSThongTin.add(thongTin);

		thongTin = new HocSinh("14", "Nguyễn thị em", 1999, "Tây Ninh", "Tây Ninh", 8, 7, 9);
		DSThongTin.add(thongTin);

		thongTin = new HocSinh("15", "Nguyễn thị Chị", 1999, "Tây Ninh", "Tây Ninh", 9.8f, 10, 9.9f);
		DSThongTin.add(thongTin);

		thongTin = new GiaoVien("16", "Lê Ngọc", 1982, "Tây Ninh", "Tây Ninh", 2010, 'T');
		DSThongTin.add(thongTin);

		thongTin = new GiaoVien("17", "Thị Bé", 1983, "Tây Ninh", "Tây Ninh", 2020, 'X');
		DSThongTin.add(thongTin);
	}

	// Thêm dữ liệu từ file
	public void taoDuLieuHocSinh() {
		try {
			FileReader reader = new FileReader("src/DSHS.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				HocSinh hs = new HocSinh();
				// Tạo dữ liệu cho mỗi học sinh
				hs.setMaCaNhan(listInfo[0]);
				hs.setHoten(listInfo[1]);
				hs.setNamSinh(Integer.parseInt(listInfo[2]));
				hs.setNoiSinh(listInfo[3]);
				hs.setDiaChi(listInfo[4]);
				hs.setDiemToan(Float.parseFloat(listInfo[5]));
				hs.setDiemVan(Float.parseFloat(listInfo[6]));
				hs.setDiemNgoaiNgu(Float.parseFloat(listInfo[7]));
				// Thêm nhân sự vào list
				this.DSThongTin.add(hs);
			}
			reader.close();// Đóng tập tin
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void taoDuLieuGiaoVien() {
		try {
			FileReader reader = new FileReader("src/DSGV.txt");
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] listInfo = line.split(" # ");
				GiaoVien gv = new GiaoVien();
//				 Tạo dữ liệu cho mỗi giáo viên
				gv.setMaCaNhan(listInfo[0]);
				gv.setHoten(listInfo[1]);
				gv.setNamSinh(Integer.parseInt(listInfo[2]));
				gv.setNoiSinh(listInfo[3]);
				gv.setDiaChi(listInfo[4]);
				gv.setNamBatDauDay(Integer.parseInt(listInfo[5]));
				gv.setChuyenMon(listInfo[6].charAt(0));
				// Thêm nhân sự vào list
				this.DSThongTin.add(gv);
			}
			reader.close();// Đóng tập tin
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Cập nhật thông tin ( tìm theo tên + năm sinh) vì không có mã độc nhất nên sẽ
	// cập nhật những thông tin trùng nhau.
	public void capNhatThongTin(Scanner scan) {

		boolean flag = true;
		String maCaNhan;
		byte chon;
		do {
			System.out.println("///////////////////");
			System.out.println("Mời chọn: ");
			System.out.println("1. Chỉnh sửa thông tin học sinh");
			System.out.println("2. Chỉnh sửa thông tin giáo viên");
			System.out.println("0. Thoát chỉnh sửa");
			chon = Byte.parseByte(scan.nextLine());

			int count = 0;
			switch (chon) {
			case 1:
				System.out.println("Mời bạn nhập mã cá nhân của HS:");
				maCaNhan = scan.nextLine();

				for (ThongTin cx : this.DSThongTin) {
					if (cx instanceof HocSinh & cx.getMaCaNhan().compareToIgnoreCase(maCaNhan) == 0) {
						// Casting thongTin -> HocSinh
						HocSinh hs = ((HocSinh) cx);
						System.out.println("Nhập tên HS cần cập nhật:");
						hs.setHoten(scan.nextLine());
						System.out.println("Nhập năm sinh HS cần cập nhật:");
						hs.setNamSinh(Integer.parseInt(scan.nextLine()));
						System.out.println("Nhập nơi sinh HS cần cập nhật:");
						hs.setNoiSinh(scan.nextLine());
						System.out.println("Nhập địa chỉ HS cần cập nhật:");
						hs.setNoiSinh(scan.nextLine());
						count++;
					}
				}
				// count = 0 -> không có dữ liệu
				if (count == 0) {
					System.out.println("Không có dữ liệu.");
				}
				// reset count
				else
					count = 0;
				break;
			case 2:
				System.out.println("Mời bạn nhập mã cá nhân của GV:");
				maCaNhan = scan.nextLine();

				for (ThongTin cx : this.DSThongTin) {
					if (cx instanceof GiaoVien & cx.getMaCaNhan().compareToIgnoreCase(maCaNhan) == 0) {
						// Casting thongTin -> GiaoVien
						GiaoVien gv = ((GiaoVien) cx);
						System.out.println("Nhập tên GV cần cập nhật:");
						gv.setHoten(scan.nextLine());
						System.out.println("Nhập năm sinh GV cần cập nhật:");
						gv.setNamSinh(Integer.parseInt(scan.nextLine()));
						System.out.println("Nhập nơi sinh GV cần cập nhật:");
						gv.setNoiSinh(scan.nextLine());
						System.out.println("Nhập địa chỉ GV cần cập nhật:");
						gv.setNoiSinh(scan.nextLine());
						System.out.println("Nhập năm bắt đầu dạy GV cần cập nhật:");
						gv.setNamBatDauDay(Integer.parseInt(scan.nextLine()));
						// Kiểm soát nhập chuyên môn
						flag = false;
						do {
							System.out.println("Nhập chuyên môn của GV cần cập nhật:");
							gv.setChuyenMon(Character.toUpperCase(scan.nextLine().charAt(0)));
							if (gv.getChuyenMon() != 'T' & gv.getChuyenMon() != 'X') {
								System.out.println("Nhập lại chuyên môn: (T: tự nhiên, X: xã hội) ");
								flag = true;
							} else
								flag = false;
						} while (flag);

						count++;
					}
				}
				// count = 0 -> không có dữ liệu
				if (count == 0) {
					System.out.println("Không có dữ liệu.");
				}
				// reset count
				else
					count = 0;
				break;
			case 0:
				// Đảo cờ -> Thoát
				flag = false;
				break;
			default:
				System.out.println("Chọn lại.");
				break;
			}
		} while (flag);
	}

	public void tinhThamNienGV() {
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof GiaoVien) {
				// casting for call tinhThamNien
				GiaoVien gv = (GiaoVien) thongTin;
				gv.tinhThamNiem();
			}
		}
	}

	// Tìm DS giáo viên có thâm niên cao nhất
	public ArrayList<ThongTin> timGVThamNienCaoNhat() {
		// Tìm giá trị thâm niên max
		int max = 0;
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof GiaoVien) {
				GiaoVien gv = (GiaoVien) thongTin;
				if (gv.getThamNien() > max) {
					max = gv.getThamNien();
				}
			}
		}
		ArrayList<ThongTin> list = new ArrayList<ThongTin>();
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof GiaoVien) {
				GiaoVien gv = (GiaoVien) thongTin;
				if (gv.getThamNien() == max) {
					list.add(gv);
				}
			}
		}

		return list;
	}

	// Tìm DS giáo viên có thâm niên > 5 và thuộc khối tự nhiên T
	public ArrayList<ThongTin> timGVKhoiTuNhien() {
		ArrayList<ThongTin> list = new ArrayList<ThongTin>();
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof GiaoVien) {
				GiaoVien gv = (GiaoVien) thongTin;
				if (gv.getThamNien() > 5 & gv.getChuyenMon() == 'T') {
					list.add(gv);
				}
			}
		}

		return list;
	}

	// Tìm DS học sinh có điểm TB cao nhất
	public ArrayList<ThongTin> timHSCoDTBCaoNhat() {
		// Tìm giá trị thâm niên max
		float max = 0;
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof HocSinh) {
				HocSinh hs = (HocSinh) thongTin;
				if (hs.getDiemTrungBinh() > max) {
					max = hs.getDiemTrungBinh();
				}
			}
		}
		ArrayList<ThongTin> list = new ArrayList<ThongTin>();
		for (ThongTin thongTin : DSThongTin) {
			if (thongTin instanceof HocSinh) {
				HocSinh hs = (HocSinh) thongTin;
				if (hs.getDiemTrungBinh() == max) {
					list.add(hs);
				}
			}
		}

		return list;
	}

	// Sắp xếp HS theo DTB sử dụng quick sort
	public void sapXepDSHS() {
		ArrayList<HocSinh> list = new ArrayList<HocSinh>();
		for (ThongTin thongTin : this.DSThongTin) {
			if (thongTin instanceof HocSinh) {
				// add casting thongtin -> hocsinh
				list.add((HocSinh) thongTin);
			}
		}
		quickSort(list, 0, list.size() - 1);
		for (ThongTin cx : list) {
			cx.xuat();
		}
	}

	// Hàm hỗ trợ quicksort
	public void quickSort(ArrayList<HocSinh> list, int left, int right) {
		if (list == null || list.size() == 0)
			return;
		if (left >= right)
			return;
		int middle = left + (right - left) / 2;
		ThongTin cxMiddle = list.get(middle);
		// casting ThongTin context -> HocSinh
		HocSinh cxMiddleCast = ((HocSinh) cxMiddle);
		int i = left, j = right;
		while (i <= j) {
			while (((HocSinh) list.get(i)).getDiemTrungBinh() > cxMiddleCast.getDiemTrungBinh()) {
				i++;
			}
			while (((HocSinh) list.get(j)).getDiemTrungBinh() < cxMiddleCast.getDiemTrungBinh()) {
				j--;
			}
			if (i <= j) {
				// Swap vị trí
				Collections.swap(list, i, j);
				i++;
				j--;
			}
		}
		if (left < i - 1)
			// Đệ quy tiếp tục sắp xếp bên trái
			quickSort(list, left, j);
		if (right > i)
			// Đệ quy tiếp tục sắp xếp bên phải
			quickSort(list, i, right);
	}

	public void sapSepHSTheoTen() {
		ArrayList<HocSinh> list = new ArrayList<HocSinh>();
		for (ThongTin thongTin : this.DSThongTin) {
			if (thongTin instanceof HocSinh) {
				// add casting thongtin -> hocsinh
				list.add((HocSinh) thongTin);
			}
		}
		bubbleSort(list);
		for (ThongTin cx : list) {
			cx.xuat();
		}
	}

	// Hàm hỗ trợ bubbleSort
	public void bubbleSort(ArrayList<HocSinh> list) {
		if (list == null) {
			return;
		}
		// Khởi tạo 2 chuỗi để dễ thao tác
		String tempString1, tempString2;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				// Lấy chữ cuối cùng của 2 chuỗi cần so sánh
				tempString1 = list.get(i).getHoten().substring(list.get(i).getHoten().lastIndexOf(" ") + 1);
				tempString2 = list.get(j).getHoten().substring(list.get(j).getHoten().lastIndexOf(" ") + 1);
				// Xóa dấu và chuyển về chữ thường
				tempString1 = VNCharacterUtils.removeAccent(tempString1).toLowerCase();
				tempString2 = VNCharacterUtils.removeAccent(tempString2).toLowerCase();
				// So sánh 2 kí tự đầu tiên từ 2 chuỗi trên: nếu > 0 thì tempString1 >
				// tempString 2 và swap 2 vị trí với nhau
				if (Character.compare(tempString1.charAt(0), tempString2.charAt(0)) > 0) {
					Collections.swap(list, i, j);
				}
			}
		}
	}

}
