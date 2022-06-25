import java.util.Scanner;

public class Chuong1BaiTapNop11 {

	public static float[] creatRandomValueInArray(short batDau, short ketThuc, int n) {
		float[] arr = new float[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = batDau + (float) (Math.random() * ((ketThuc - batDau) + 1));
		}
		return arr;
	}

	public static void printArray(float arr[]) {
		System.out.println("\nMảng bạn đã tạo ngẫu nhiên là");
		for (float pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void deleteMaxValueInArray(float[] arr) {
		float max = getMaxOfArray(arr);
		int countLoop = 0;
		for (int i = 0; i < arr.length - countLoop; i++) {
			if (arr[i] == max) {
				countLoop++;
				for (int j = i; j < arr.length - countLoop; j++) {
					arr[j] = arr[j + 1];
				}
			} 
		}
		System.out.println("Mảng sau khi loại bỏ giá trị lớn nhất " + max + " là:\n");
		for (int i = 0; i < arr.length - countLoop; i++) { //Số phần tử sau khi dời giá trị là n - số lần tìm thấy max
			System.out.print(arr[i] + "\t");
		}
	}

	public static float getMaxOfArray(float[] arr) {
		float max = arr[1];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void main(String args[]) {
		/*
		 * Có hai cách xóa giá trị lớn nhất: 
		 * 1: đẩy giá trị phần tử phía sau lên và cập nhật chỉ mục 
		 * 2: copy ra một mảng mới 
		 * 3...
		 * Bài này đang làm theo cách 1
		 */
		Scanner scan = new Scanner(System.in);
		// cờ hiệu báo lỗi nhập.
		boolean flag = false;
		System.out.println("Nhập số phần tử mảng n > 0:");
		int n = 0;
		do {
			n = Integer.parseInt(scan.nextLine());
			if (n <= 0) {
				flag = true;
				System.out.println("Nhập lại n > 0");
			} else
				flag = false;
		} while (flag);

		short batDau = -1000, ketThuc = 1000;
		float[] arr = creatRandomValueInArray(batDau, ketThuc, n); // Số từ -1000 -> 1000
		printArray(arr);
		deleteMaxValueInArray(arr);
		
//		Kiểm tra
//		float[] testArr = {1.11f, 1231.123f, 1.11f, 123, 125};
//		deleteMaxValueInArray(testArr);
	}
}
