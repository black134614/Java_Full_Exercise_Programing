import java.util.Scanner;

public class Chuong1BaiTapNop15 {
	public static int[] creatRandomValueInArray(short batDau, short ketThuc, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = batDau + (int) (Math.random() * ((ketThuc - batDau) + 1));
		}
		return arr;
	}

	public static void printArray(int arr[]) {
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static int[] circularArray (int[] arr, int k) {
		while (k > 0) {
			int holdValue = arr[arr.length - 1];
			for (int i = arr.length - 1; i >= 1; i--) {
				arr[i] = arr[i - 1];
			}
			arr[0] = holdValue;
			k--;
		}
		return arr;
	}
	
	public static void main(String args[]) {
		/*
		 * Có hai cách xóa giá trị lớn nhất: 1: đẩy giá trị phần tử phía sau lên và cập
		 * nhật chỉ mục 2: copy ra một mảng mới Bài này đang làm theo cách 2
		 */
		Scanner scan = new Scanner(System.in);
		// cờ hiệu báo lỗi nhập.
		boolean flag = false;
		int n = 0, k = 0;
		do {
			System.out.println("Nhập số phần tử mảng n > 0:");
			n = Integer.parseInt(scan.nextLine());
			System.out.println("Nhập số vòng xoay mảng k > 0:");
			k = Integer.parseInt(scan.nextLine());
			if (n <= 0) {
				flag = true;
				System.out.println("Nhập lại:");
			} else
				flag = false;
		} while (flag);

		short batDau = -100, ketThuc = 100;
		int[] arr = creatRandomValueInArray(batDau, ketThuc, n); // giá trị phần tử từ -1000 -> 1000
		
		System.out.println("Mảng sinh ngẫu nhiên là:");
		printArray(arr);
		
		arr = circularArray(arr, k);
		System.out.println("\nMảng sau khi xoay " + k + " vòng là:");
		printArray(arr);
	}
}
