import java.util.Scanner;

public class Chuong1BaiTapNop13 {
	public static int[] creatRandomValueInArray(short batDau, short ketThuc, int n) {
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = batDau + (int) (Math.random() * ((ketThuc - batDau) + 1));
		}
		return arr;
	}

	public static void printArray(int arr[]) {
		System.out.println("\nMảng đã tạo ngẫu nhiên là");
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void deleteEvenNumberInArray(int[] arr) {
		int totalEven = countEvenNumberInArray(arr);
		int[] removeEvenArr = new int[arr.length - totalEven];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (isEvenNumber(arr[i])) {
				continue;
			} else {
				removeEvenArr[j] = arr[i];
				j++;
			}
		}
		System.out.println("\nMảng sau khi loại bỏ giá trị chẵn là:\n");
		for (int elem : removeEvenArr) {
			System.out.print(elem + "\t");
		}
	}

	public static boolean isEvenNumber(int number) {
		if (number % 2 == 0) {
			return true;
		} else
			return false;
	}

	public static int countEvenNumberInArray(int[] arr) {
		int countLoop = 0;
		for (int i = 0; i < arr.length; i++) {
			if (isEvenNumber(arr[i])) {
				countLoop++;
			}
		}
		return countLoop;
	}

	public static void main(String args[]) {
		/*
		 * Có hai cách xóa giá trị lớn nhất: 1: đẩy giá trị phần tử phía sau lên và cập
		 * nhật chỉ mục 2: copy ra một mảng mới Bài này đang làm theo cách 2
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
		int[] arr = creatRandomValueInArray(batDau, ketThuc, n); // Số từ -1000 -> 1000
		printArray(arr);
		deleteEvenNumberInArray(arr);
	}
}
