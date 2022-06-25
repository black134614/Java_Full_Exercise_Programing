import java.util.Scanner;

public class BaiTapNop8 {
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

	public static void tinhTong1Dong(int a[][], byte dongKiemTra, byte soCot) {
		int tongGiaTri = 0;
		for (int i = 0; i < soCot; i++) {
			tongGiaTri += a[dongKiemTra - 1][i];
		}
		System.out.println("Tổng giá trị dòng " + dongKiemTra + " là: " + tongGiaTri);
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
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
		System.out.println("Nhập dòng cần tính tổng:");
		byte dongKiemTra = 0;
		boolean flag = true;
		do {
			dongKiemTra = Byte.parseByte(scan.nextLine());
			if (dongKiemTra <= 0 | dongKiemTra > soDong) {
				System.out.println("Nhập số dòng không hợp lệ. Số dòng > 0 và nhỏ hơn tổng số dòng của ma trận.");
			}
			else flag = false;
		}
		while (flag);
		
		xuatMaTran(arr, soDong, soCot);
		tinhTong1Dong(arr, dongKiemTra, soCot);
	}
}
