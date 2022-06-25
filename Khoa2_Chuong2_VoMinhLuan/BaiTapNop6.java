import java.util.Scanner;

public class BaiTapNop6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Mời bạn nhập số dòng:");
		byte soDong = Byte.parseByte(scan.nextLine());
		soDong = kiemTraNhap(soDong, scan);
		System.out.println("Mời bạn nhập số cột:");
		byte soCot = Byte.parseByte(scan.nextLine());
		soCot = kiemTraNhap(soCot, scan);
		int arr[][] = nhapMang(soDong, soCot, scan);
		xuatMang(arr, soDong, soCot);
		if (kiemTraMaTran(arr, soDong, soCot)) {
			System.out.println("Ma trận toàn giá trị dương.");
		}
		else
			System.out.println("Ma trận có giá trị âm hoặc 0.");

	}
	
public static byte kiemTraNhap(byte number, Scanner scan) {
	while (number <= 0) {
		System.out.println("Nhập lại số > 0:");
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


	public static void xuatMang(int a[][], int soDong, int soCot) {
		for (int i = 0; i < soDong; i++) {
			for (int j = 0; j < soCot; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("\t");
		}
	}
	
	public static boolean kiemTraMaTran(int arr[][], byte soDong, byte soCot) {
		for(int i = 0; i < soDong; i++) {
			for(int j = 0; j < soCot; j++) {
				if(arr[i][j] <= 0 ) {
					return false;
				}
			}
		}
		return true;
	}
}
