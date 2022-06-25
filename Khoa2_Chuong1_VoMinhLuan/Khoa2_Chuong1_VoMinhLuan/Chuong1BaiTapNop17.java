import java.util.Scanner;

public class Chuong1BaiTapNop17 {
	public static int[] nhapMang(int n, Scanner scan) {
		int arr[] = new int[n];
		System.out.println("Nhập mảng");
		for (int i = 0; i < n; i++) {
			System.out.print("arr[" + i + "] = ");
			arr[i] = Integer.parseInt(scan.nextLine());
		}
		return arr;

	}

	public static void xuatMang(int arr[]) {
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void reverseArray(int[] arr) {
		int holdNumber = 0;
		for (int i = 0; i <= arr.length / 2; i++) {
			holdNumber = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length -1 - i] = holdNumber;
		}
		System.out.println("\nMảng sau khi đảo ngược là:\n");
		xuatMang(arr);
	}
	
	public static void main(String[] args) {
		/*
		 * Nhập số phần tử mảng lớn hơn 2
		 * nhập mảng
		 * liệt kê các cặp giá trị có giá trị gần nhau nhất
		 * các cặp giá trị gần nhau phải cùng là giá trị tuyệt đối giữ hiệu của chúng.
		 */
		Scanner scan = new Scanner(System.in);
		int n = 0;
		boolean flag = false;
		do {
			System.out.println("Nhập số phần từ mảng n: (n>=2)");
			n = Integer.parseInt(scan.nextLine());
			if (n < 2) {
				System.out.println("Vui lòng nhập số phần tử lớn hơn 2");
				flag = true;
			}
			else
				flag = false;
		}
		while(flag);
		
		int[] arr = nhapMang(n, scan);
		System.out.println("Mảng đã nhập là:\n");
		xuatMang(arr);
		reverseArray(arr);
	}
}
