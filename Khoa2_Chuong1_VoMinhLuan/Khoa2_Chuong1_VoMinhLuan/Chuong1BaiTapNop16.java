import java.util.Scanner;

public class Chuong1BaiTapNop16 {
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
		System.out.println("\nXuất mảng");
		for (int pt : arr) {
			System.out.print(pt + "\t");
		}
	}

	public static void findValueAppearMax(int[] arr) {
		int countMax = countAppearOfNumber(arr, arr[0]);
		int maxAppearValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (countMax < countAppearOfNumber(arr, arr[i])) {
				countMax = countAppearOfNumber(arr, arr[i]);
				maxAppearValue = arr[i];
			}
		}
		System.out.println("Giá trị xuất hiện nhiều nhất: " + maxAppearValue + "[" + countMax +" lần]");
	}
	
	

	public static void findValueAppearMin(int[] arr) {
		int countMin = countAppearOfNumber(arr, arr[0]);
		int minAppearValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (countMin > countAppearOfNumber(arr, arr[i])) {
				countMin = countAppearOfNumber(arr, arr[i]);
				minAppearValue = arr[i];
			}
		}
		System.out.println("Giá trị xuất hiện ít nhất: " + minAppearValue + "[" + countMin +" lần]");
	}
	
	public static int countAppearOfNumber(int arr[], int number) {
		int countLoop = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == number) {
				countLoop++;
			}
		}
		return countLoop;
	}

	public static void main(String[] args) {
		/*
		 *cách 1: sắp xếp mảng theo thứ tự rồi so sánh số lần chúng xuất hiện
		 *để giảm bớt số vòng lặp .
		 *cách 2. lặp toàn mảng để đếm số lần chúng xuất hiện và so sanh với nhau
		 *=> nếu mảng lớn thì chạy lâu.
		 *bài đang theo cách 2 vì yêu cầu cho ra kết quả phần tử xuất hiện đầu tiên.
		 *không phải phần tử nhỏ nhất hoặc lớn nhất.
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
			} else
				flag = false;
		} while (flag);

		int[] arr = nhapMang(n, scan);

		findValueAppearMax(arr);
		findValueAppearMin(arr);
	}
}
