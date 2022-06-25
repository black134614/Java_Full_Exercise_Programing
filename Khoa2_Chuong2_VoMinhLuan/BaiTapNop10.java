import java.util.Scanner;

public class BaiTapNop10 {
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

	public static void kiemTraDongCoSoAm(int a[][],  byte soDong, byte soCot) {
		byte demSoDong = 0;
		boolean flag = false;
		System.out.println("Các dòng có chứa giá trị âm là: ");
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				if (xacDinhSoAm(a[i][j])) {
					flag = true;
					demSoDong++;
					break;
				}
			}
			if (flag) {
				System.out.print(i + 1 + "\t");
				flag = false;
			}
		}
		if(demSoDong == 0) {
			System.out.print("Không có dòng nào.");
		}
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}

	public static boolean xacDinhSoAm(int number) {
		if (number < 0) {
			return true;
		}
		return false;
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

		xuatMaTran(arr, soDong, soCot);
		kiemTraDongCoSoAm(arr, soDong, soCot);
	}
}
