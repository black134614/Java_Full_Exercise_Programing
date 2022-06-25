import java.util.Scanner;

public class BaiTapNop2 {

	final static byte min = -50;
	final static byte max = 50;

	public static int[][] taoMaTranNgauNhien(byte min, byte max, byte soDong, byte soCot) {
		int[][] arr = new int[soDong][soCot];
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				arr[i][j] = min + (int)(Math.random() * (max - min + 1));
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
	
	public static int tinhTongSoChan(int a[][], byte soDong, byte soCot) {
		int tongSoChan = 0;
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				if (a[i][j] % 2 == 0) {
					tongSoChan += a[i][j];
				}
			}
		}
		return tongSoChan;
	}
	
	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}
	
	public static void main(String[] args) {
		// Test số dòng khá nhỏ cho dữ liệu về byte
		Scanner scan =  new Scanner(System.in);
		System.out.println("Mời bạn nhập số dòng của ma trận:");
		byte soDong = Byte.parseByte(scan.nextLine());
		soDong = kiemTraSo(soDong, scan);
		System.out.println("Mời bạn nhập số cột của ma trận:");
		byte soCot = Byte.parseByte(scan.nextLine());
		soCot = kiemTraSo(soCot, scan);
		int[][] arr = taoMaTranNgauNhien(min, max, soDong, soCot);
		xuatMaTran(arr, soDong, soCot);
		int tongSoChan = tinhTongSoChan(arr, soDong, soCot);
		System.out.println("Tổng số chẵn thuộc ma trận "+  soDong + "x" + soCot  +  " là: " + tongSoChan);
		
	}

}
