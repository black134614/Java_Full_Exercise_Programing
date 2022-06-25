import java.util.Scanner;

public class BaiTapNop3 {
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

	public static float xacDinhGiaTriLonNhat(float arr[]) {
		float maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		return maxValue;
	}

	public static float timGiaTriPhuHop(float arr[]) {
		float maxValue = xacDinhGiaTriLonNhat(arr);
		if (maxValue <= 0) {
			return -1;
		} else {
			float trueValue = maxValue;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0 && arr[i] < trueValue) {
					trueValue = arr[i];
				}
			}
			return trueValue;
		}
	}

	public static void ketQuaTimKiem(float arr[]) {
		float trueValue = timGiaTriPhuHop(arr);
		System.out.println("\nGiá trị dương nhỏ nhất trong mảng là:");
		if (trueValue == -1) {
			System.out.print("-1");
		} 
		else {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == trueValue) {
					System.out.print(i + 1 + "\t");
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Mời bạn nhập số phần tử của mảng:");
		byte soPhanTu = Byte.parseByte(scan.nextLine());
		soPhanTu = kiemTraSo(soPhanTu, scan);

		float[] arr = taoMaTranNgauNhien(min, max, soPhanTu);
		xuatMang(arr);

		ketQuaTimKiem(arr);
	}
}
