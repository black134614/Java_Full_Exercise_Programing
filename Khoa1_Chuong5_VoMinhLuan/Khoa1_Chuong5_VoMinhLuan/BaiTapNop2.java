import java.util.Iterator;

public class BaiTapNop2 {

	public static short timSoThoaDieuKien() {
		short i = 1, n = 0;
		int tong = 0;
		while (tong < 10000) {
			tong += ++i;
		}
		return i;
	}
	
	/*public static void kiemTra() { //kiểm tra
		int tong = 0;
		for (int i = 1; i <= 141; i++) {
			tong +=i;
		}
		System.out.println(tong);
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ketQua =  timSoThoaDieuKien();
		System.out.println("kết quả thỏa điều kiện là n = " + ketQua);
		//kiemTra();
	}

}
