import java.util.Scanner;

public class BaiTapNop5 {
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

	public static void timSoNguyenToDauTien(int a[][], byte soDong, byte soCot) {
		boolean flag = false;
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				if (xacDinhSoNguyenTo(a[i][j])) {
					System.out.println("Số nguyên tố đầu tiên là: " + a[i][j]);
					flag = true;
				}
				if (flag) {
					return;
				}
			}
		}
		if (!flag) {
			System.out.println("Ma trận không có số nguyên tố.");
		}
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}

	public static boolean xacDinhSoNguyenTo(int number) {
		if (number < 2) {
			return false;
		} else {
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;
		}
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
//		int[][] arr = {{2,1},{3,4}}; //Kiểm tra số 2
		
		xuatMaTran(arr, soDong, soCot);
		timSoNguyenToDauTien(arr, soDong, soCot);
	}
}
