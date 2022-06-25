import java.util.Scanner;

public class BaiTapNop9 {
	final static byte min = -50;
	final static byte max = 50;

	public static int[][] taoMaTranNgauNhien(byte min, byte max, byte soDong, byte soCot) {
		int[][] arr = new int[soDong][soCot];
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				arr[i][j] = min + (int) (Math.random() * (max - min + 1));
			}
		}
		return arr;
	}

	public static void xuatMaTran(int a[][], byte soDong, byte soCot) {
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\t");
		}
	}

	public static void tinhTongGiaTriLe(int a[][], byte cotKiemTra, byte soDong) {
		int tongGiaTri = 0;
		for (int i = 0; i < soDong; i++) {
			if (xacDinhSoLe(a[i][cotKiemTra - 1])) {
				tongGiaTri += a[i][cotKiemTra - 1];
			}
		}
		System.out.println("Tổng giá trị lẻ cột thứ " + cotKiemTra + "là: " + tongGiaTri);
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}

	public static boolean xacDinhSoLe(int number) {
		if (number % 2 == 0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số dòng của ma trận:");
		byte soDong = Byte.parseByte(scan.nextLine());
		soDong = kiemTraSo(soDong, scan);
		System.out.println("Mời bạn nhập số cột của ma trận:");
		byte soCot = Byte.parseByte(scan.nextLine());
		soCot = kiemTraSo(soCot, scan);
		int[][] arr = taoMaTranNgauNhien(min, max, soDong, soCot);
		System.out.println("Nhập cột cần tính tổng:");
		byte cotKiemTra = 0;
		boolean flag = true;
		do {
			cotKiemTra = Byte.parseByte(scan.nextLine());
			if (cotKiemTra <= 0 | cotKiemTra > soCot) {
				System.out.println("Nhập số cột không hợp lệ. Số cột > 0 và nhỏ hơn tổng số cột của ma trận.");
			}
			else flag = false;
		}
		while (flag);
		
		xuatMaTran(arr, soDong, soCot);
		tinhTongGiaTriLe(arr, cotKiemTra, soDong);
	}
}
