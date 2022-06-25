import java.util.Scanner;

public class BaiTapNop3 {
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
	
	public static void timSoDuongDauTien(int a[][], byte soDong, byte soCot) {
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				if (a[i][j] > 0) {
					System.out.println("Số dương đầu tiên của ma trận là: " + a[i][j]);
					return;
				}
			}
		}
	}
	
	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}
	
	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		System.out.println("Mời bạn nhập số dòng của ma trận:");
		byte soDong = Byte.parseByte(scan.nextLine());
		soDong = kiemTraSo(soDong, scan);
		System.out.println("Mời bạn nhập số cột của ma trận:");
		byte soCot = Byte.parseByte(scan.nextLine());
		soCot = kiemTraSo(soCot, scan);
		int[][] arr = taoMaTranNgauNhien(min, max, soDong, soCot);
		xuatMaTran(arr, soDong, soCot);
		timSoDuongDauTien(arr, soDong, soCot);
		
	}
}
