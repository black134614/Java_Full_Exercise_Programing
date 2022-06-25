import java.util.Iterator;
import java.util.Scanner;

public class BaiTapNop4 {
	final static byte min = -100;
	final static byte max = 100;

	public static int[] taoMaTranNgauNhien(byte min, byte max, byte soPhanTu) {
		int[] arr = new int[soPhanTu];
			for (int i = 0; i < soPhanTu; i++) {
				arr[i] = min + (int) (Math.random() * (max - min + 1));
			}
		return arr;
	}

	public static void xuatMang(int arr[]) {
		System.out.println("Mảng đã tạo là: ");
		for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
		}
	}

	public static byte kiemTraSo(byte number, Scanner scan) {
		while (number <= 0) {
			System.out.println("Nhập lại: ");
			number = Byte.parseByte(scan.nextLine());
		}
		return number;
	}

	public static boolean kiemTraSoNguyenTo(int number) {
		if (number < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(number);
        for (int i = 2; i <= squareRoot; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
	}
	
	public static int soNguyenToCuoiCung(int arr[]) {
		for (int i = arr.length - 1; i > 0 ; i--) {
			if (kiemTraSoNguyenTo(arr[i])) {
				return arr[i];
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);
		
		int[] arr = taoMaTranNgauNhien(min, max, soPhanTu);
		xuatMang(arr);
		
		System.out.println("\nSố nguyên tố cuối cùng: " + soNguyenToCuoiCung(arr));
	}
}
