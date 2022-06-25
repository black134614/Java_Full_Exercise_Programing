import java.util.Scanner;

public class BaiTapNop7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Mời bạn nhập số dòng > 1:");
		byte soDong = Byte.parseByte(scan.nextLine());
		soDong = kiemTraNhap(soDong, scan);
		System.out.println("Mời bạn nhập số cột:");
		byte soCot = Byte.parseByte(scan.nextLine());
		soCot = kiemTraNhap(soCot, scan);
		byte cotKiemTra = 0;
		do {
			System.out.println("Mời bạn nhập cột cần kiểm tra " + "1 - " + soCot + " :");
			cotKiemTra = Byte.parseByte(scan.nextLine());
			if (cotKiemTra > soCot) {
				System.out.println("Nhập lại.");
			}
		}
		while(cotKiemTra > soCot);
		int arr[][] = nhapMang(soDong, soCot, scan);
		xuatMang(arr, soDong, soCot);
		if (kiemTraMaTran(arr, soDong, cotKiemTra)) {
			System.out.println("Cột thứ " + cotKiemTra + " giảm dần.");
		}
		else
			System.out.println("Cột thứ " + cotKiemTra + " không giảm dần.");

	}
	
public static byte kiemTraNhap(byte number, Scanner scan) {
	while (number <= 1) {
		System.out.println("Nhập lại số > 1:");
		number = Byte.parseByte(scan.nextLine());
	}
	return number;
}
	
	public static int[][] nhapMang(int soDong, int soCot, Scanner scan) {
		int a[][] = new int[soDong][soCot];

		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print("a[" + i + "]" + "[" + j + "] = ");
				a[i][j] = Integer.parseInt(scan.nextLine());
			}
		}

		return a;

	}


	public static void xuatMang(int a[][], byte soDong, byte soCot) {
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\t");
		}
	}
	
	public static boolean kiemTraMaTran(int arr[][], byte soDong, byte cotKiemTra) {
		for(int i = 0; i < soDong - 1; i++) {
				if(arr[i][cotKiemTra - 1] <=  arr[i + 1][cotKiemTra - 1] ) {
					return false;
				}
		}
		return true;
	}
}
