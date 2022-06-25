import java.util.Iterator;
import java.util.Scanner;

public class BaiTapNop5 {
	final static byte min = -100;
	final static byte max = 100;

	public static float[] taoMaTranNgauNhien(byte min, byte max, byte soPhanTu) {
		float[] arr = new float[soPhanTu];
		for (int i = 0; i < soPhanTu; i++) {
			arr[i] = (float) (min + (Math.random() * (max - min + 1)));
		}
		return arr;
	}

	public static void xuatMang(float arr[]) {
		System.out.println("Mảng số thực đã tạo là: ");
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

	public static void ketQua(float arr[], int x) {
		float[] arrTemp =  new float[arr.length];
		for (int i = 0; i < arrTemp.length; i++) {
			arrTemp[i] = Math.abs(arr[i] - x);
		}
		float minValue = xacDinhGiaTriNhoNhat(arrTemp);
		for (int i = 0; i < arrTemp.length; i++) {
			if (arrTemp[i] == minValue) {
				System.out.println("Giá trị gần X nhất là: " + arr[i]);
				break;
			}
		}
	}

	public static float xacDinhGiaTriNhoNhat(float arr[]) {
		float minValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < minValue) {
				minValue = arr[i];
			}
		}
		return minValue;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nMời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);

		float[] arr = taoMaTranNgauNhien(min, max, soPhanTu);
		xuatMang(arr);

		System.out.println("\nNhập giá trị X:");
		int x = Integer.parseInt(scan.nextLine());
		ketQua(arr, x);
	}
}
