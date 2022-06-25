import java.util.Scanner;

public class Chuong1BaiTapNop2 {

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

	public static int tiemHieuNhoNhatTrongMang(int[] arr) {
		int hieuNhoNhat = Math.abs(arr[0] - arr[1]);//Khởi tạo giá trị nhỏ nhất là giá trị tuyệt đối của 2 phần tử đầu.
		for (int i = 0; i < arr.length - 1; i++) {
			if ((Math.abs(arr[i] - arr[i + 1])) < hieuNhoNhat) {//Phải chạy luôn 2 phần tử đầu vì trường hợp mảng có 2 phần tử
				hieuNhoNhat = Math.abs(arr[i] + arr[i + 1]);
			}
		}
		return hieuNhoNhat;
	}
	
	public static void lietKeCacCapGiaTriNhoNhat( int[] arr) {
		int hieuNhoNhat  = tiemHieuNhoNhatTrongMang(arr);
				
		System.out.println("Các cặp giá trị gần nhau nhất là:");
		for (int i = 0; i < arr.length - 1; i++) { 
			if (Math.abs(arr[i] - arr[i + 1]) ==  hieuNhoNhat) {
				System.out.println(arr[i] + " & " + arr[i + 1]);
			}
		}
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
		
		lietKeCacCapGiaTriNhoNhat(arr);
	}

}
