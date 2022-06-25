import java.util.Scanner;

public class BaiTapNop7 {

	public static void veTamGiacCanDac(Byte doCaoTamGiac) {
		System.out.println("Tam giác cân đặc n = " + doCaoTamGiac);
		short soDong = 1;
		for (int i = 0; i < doCaoTamGiac ; i++) {
			for (int j = 0; j < (doCaoTamGiac * 2 - 1); j++) {
				if( j >= (doCaoTamGiac - soDong ) & j <= (doCaoTamGiac + soDong - 2) )
					veNgoiSao();
				else veKhoangTrang();
			}
			soDong++;
			xuongDong();
		}
	}
	
	public static void veTamGiacCanRong(Byte doCaoTamGiac) {
		System.out.println("Tam giác cân rỗng n = " + doCaoTamGiac);
		short soDong = 1;
		for (int i = 0; i < doCaoTamGiac ; i++) {
			for (int j = 0; j < (doCaoTamGiac * 2 - 1); j++) {
				if( j == (doCaoTamGiac - soDong ) | j == (doCaoTamGiac + soDong - 2) | soDong == doCaoTamGiac)
					veNgoiSao();
				else veKhoangTrang();
				
			}
			soDong++;
			xuongDong();
		}
	}
	
	public static void veNgoiSao() {
		System.out.print("*");
	}
	
	public static void veKhoangTrang() {
		System.out.print(" ");
	}
	
	public static void xuongDong() {
		System.out.println("");
	}
	
	public static Boolean kiemTraSoNguyenDuong(Byte n) {
		if (n < 0) {
			return true; // nhập lại
		} else
			return false; //ok
	}


	public static void main(String[] args) {
		/*
		 * quy tắc vẽ tam giác cân đặc: lặp n lần dòng độ cao mỗi dòng tăng 2 đơn vị kí
		 * tự * dòng đầu có n-1 kí tự rỗng và sau đó * dòng tiếp theo (n-1) -1 vẽ 3*
		 * Minh họa n = 4
		 * /*
			 3
	   	  * 234
		 * 12345
		* 0123456
		* Tương tự tam giác cân rỗng.
		 */
		 
		Scanner scan = new Scanner(System.in);
		boolean flag = false;
		Byte doCaoTamGiac = 0;
		do {
			System.out.println("Mời bạn nhập độ cao của tam giác cân:");
			doCaoTamGiac = Byte.parseByte(scan.nextLine());
			flag = kiemTraSoNguyenDuong(doCaoTamGiac);
			if (flag) {
				System.out.println("Nhập lại số nguyên dương.");
			}
		}
		while(flag);
		veTamGiacCanDac(doCaoTamGiac);
		veTamGiacCanRong(doCaoTamGiac);
	}
}
