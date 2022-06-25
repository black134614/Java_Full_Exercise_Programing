import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/*
 * Mục đích: Quản lý danh sách giao dịch nhà , đất và các nghiệp vụ nhập, xuất, thống kê giao dịch nhà, đất
 * 			tính trung bình thành tiền giao dịch đất, xuất các giao dịch trong tháng 9/2013
 * Người tạo: Minh Luân
 * Ngày tạo: 04/01/2022
 * Version: 1.0
 * */
public class DanhSachGiaoDich {
	// 1. attributes
	private ArrayList<GiaoDich> danhSachGD;
	private int tongGiaoDichDat;
	private int tongGiaoDichNha;
	private double tbThanhTienGDDat;

	// 2. get , set
	/**
	 * @return the danhSachGD
	 */
	public ArrayList<GiaoDich> getDanhSachGD() {
		return danhSachGD;
	}

	/**
	 * @param danhSachGD the danhSachGD to set
	 */
	public void setDanhSachGD(ArrayList<GiaoDich> danhSachGD) {
		this.danhSachGD = danhSachGD;
	}

	/**
	 * @return the tongGiaoDichDat
	 */
	public int getTongGDDat() {
		return tongGiaoDichDat;
	}

	/**
	 * @return the tongGiaoDichNha
	 */
	public int getTongGDNha() {
		return tongGiaoDichNha;
	}

	/**
	 * @return the tbThanhTienGDDat
	 */
	public double getTBThanhTienGDDat() {
		return tbThanhTienGDDat;
	}

	// 3. constructor
	public DanhSachGiaoDich() {
		this.danhSachGD = new ArrayList<GiaoDich>();
	}

	// 4. input, output
	public void nhap(Scanner scan) {
		GiaoDich giaoDich;
		boolean flag = true;
		do {
			System.out.println("Nhập 1. Giao dịch đất");
			System.out.println("Nhập 2. Giao dịch nhà");
			System.out.println("Nhập 0. Thoát nhập");
			int chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				giaoDich = new GiaoDichDat();
				giaoDich.nhap(scan);
				this.danhSachGD.add(giaoDich);
				break;
			case 2:
				giaoDich = new GiaoDichNha();
				giaoDich.nhap(scan);
				this.danhSachGD.add(giaoDich);
				break;
			case 0:
				flag = false;
				break;
			}
		} while (flag);
	}

	public void xuat() {
		for (GiaoDich cx : this.danhSachGD) {
			cx.xuat();
		}
	}

	// 5. bussiness method
	// Tính tổng giao dịch đất
	public void tinhTongGiaoDichDat() {
		this.tongGiaoDichDat = 0;
		for (GiaoDich cx : this.danhSachGD) {
			if (cx instanceof GiaoDichDat) {
				this.tongGiaoDichDat++;
			}
		}
	}

	// Tính tổng giao dịch nhà
	public void tinhTongGiaoDichNha() {
		this.tongGiaoDichNha = 0;
		for (GiaoDich cx : this.danhSachGD) {
			if (cx instanceof GiaoDichNha) {
				this.tongGiaoDichNha++;
			}
		}
	}

	// Tính trung bình thành tiền giao dịch đất
	public void tinhTBThanhTienGDDat() {
		int countLoop = 0;
		double thanhTien = 0;
		for (GiaoDich cx : this.danhSachGD) {
			if (cx instanceof GiaoDichDat) {
				// Casting
				GiaoDichDat giaoDichDat = ((GiaoDichDat) cx);
				thanhTien += giaoDichDat.getThanhTien();
				countLoop++;
			}
		}
		if (countLoop == 0) {
			this.tbThanhTienGDDat = 0;
		} else {
			this.tbThanhTienGDDat = thanhTien / countLoop;
		}
	}

	public void xuatTheoDK() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date stringToDate;
		LocalDate dateToLocalDate ;
		int month, year;
		for (GiaoDich giaoDich : danhSachGD) {
			stringToDate = dateFormat.parse(giaoDich.ngayGiaoDich);
			dateToLocalDate = stringToDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			month = dateToLocalDate.getMonthValue();
			year = dateToLocalDate.getYear();
			if (month == 9 & year == 2013) {
				giaoDich.xuat();
			}
		}
	}
	
	// dummy data for test
	public void dummyData() {
		GiaoDich giaoDich;
		giaoDich = new GiaoDichDat(1, "01/09/2013", 10, 1000, 'A');
		this.danhSachGD.add(giaoDich);

		giaoDich = new GiaoDichDat(2, "01/01/2022", 10, 8000, 'B');
		this.danhSachGD.add(giaoDich);

		giaoDich = new GiaoDichDat(3, "01/01/2021", 10, 7000, 'C');
		this.danhSachGD.add(giaoDich);

		giaoDich = new GiaoDichNha(4, "06/09/2013", 10, 2500, 'C');
		this.danhSachGD.add(giaoDich);

		giaoDich = new GiaoDichNha(5, "01/01/2021", 10, 5000, 'T');
		this.danhSachGD.add(giaoDich);

		giaoDich = new GiaoDichDat(6, "01/09/2013", 10, 900, 'A');
		this.danhSachGD.add(giaoDich);
	}
}
