import java.util.Scanner;

public class Chuong1BaiTapNop18 {
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

	public static int[] sortArray(int[] arr) {
		int holdValue = arr[0];
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					holdValue = arr[j];
					arr[j] = arr[i];
					arr[i] = holdValue;
				}
			}
		}
		return arr;
	}

	public static int countAppearValueInSortedArray(int[] arr) {
		int countLoop = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				countLoop++;
			}
		}
		return countLoop;
	}

	public static void findValueAppearMax(int[] arr) {
		int appearMax = 0;

		if (arr.length == 2) {// Trường hợp mảng có 2 phần tử
			if (arr[0] == arr[1]) {
				appearMax = 2;
				System.out.println("Các giá trị có số lần xuất hiện như nhau, và nhiều nhất là:");
				System.out.println("giá trị: " + arr[0] + " Số lần xuất hiện: " + appearMax);
			} else {
				appearMax = 1;
				System.out.println("Các giá trị có số lần xuất hiện như nhau, và nhiều nhất là:");
				System.out.println("giá trị: " + arr[0] + "," + arr[1] + "\nSố lần xuất hiện: " + appearMax);
			}
		} else {// 3 phần tử trở lên
			arr = sortArray(arr);// Sắp xếp mảng
			int[] repeatAppearArr = new int[countAppearValueInSortedArray(arr)];// Sử dụng mảng lưu so lan xuat hien

			for (int j = 0, i = 0, count = 1; j < arr.length - 1; j++) {
				if (arr[j] != arr[j + 1] & j != arr.length - 2) {
					repeatAppearArr[i] = count;
					++i;
					count = 1;
				} else if (j == arr.length - 2) { // Nếu cuối vòng lặp thì có 2 trường hợp
					if (arr[j] == arr[j + 1]) {// bằng nhau
						repeatAppearArr[i] = count;
					} else { // 2 số cuối khác nhau thì trả giá trị số lần lặp cho thằng hiện tại
								// => tăng chỉ mục và cập nhật phần tử cuối có số lần xuất hiện là 1
						repeatAppearArr[i++] = count;
						repeatAppearArr[i] = 1;
					}
				} else { // Bình thường thì tính tăng thêm 1 số lần lặp
					count++;
				}
			}
			// Lúc này ta có được danh sách số lần lặp của mỗi giá trị.
			// Bây giờ thực hiện tìm số lần lặp nhiều nhất trong mảng số lần lặp.
			repeatAppearArr = sortArray(repeatAppearArr);
			appearMax = countAppearOfNumber(repeatAppearArr, repeatAppearArr[0]);
			for (int i = 1; i < repeatAppearArr.length; i++) {
				if (appearMax <= countAppearOfNumber(repeatAppearArr, repeatAppearArr[i])) {
					appearMax = repeatAppearArr[i];
				}
			}
			// Có số lần lặp chung nhiều nhất
			// bây giờ sẽ tìm các giá trị có số lần lặp chung nhiều nhất.
			System.out.println("Các giá trị có số lần xuất hiện như nhau, và nhiều nhất là: \ngiá trị: ");
			for (int i = 0, lastAppear = 0; i < arr.length ; i++) {
				if (countAppearOfNumber(arr, arr[i]) == appearMax & arr[i] != lastAppear) {
					System.out.print(arr[i] + "\t");
					lastAppear = arr[i];
				}
				
			}
			System.out.print("\nSố lần xuất hiện:" + appearMax);
		}
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
		 * Dựa vào câu 16 để tiếp tục build mở rộng 1.tạo mảng countRepeatArr lưu số lần
		 * xuất hiện của mỗi giá trị 2.tìm số lần lặp cao nhất từ mảng mới
		 * repeatAppearArr 3.truy ngược lại giá trị và sô lần lặp từ arr
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
	}
}
