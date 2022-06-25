import java.util.Scanner;

public class BaiTapNop1 {

	public static void oanTuXi(Scanner scan) {

		byte nguoiChoiChon, mayChon;
		boolean flag = false;
		short tongVanChoi = 1, tongVanThang = 0, tongVanThua = 0;

		do {
			System.out.println("Chào mừng bạn đến với trò chơi oẳn tù xì\nMời bạn chọn:\n1. Bao\n2. Kéo\n3. Kim");
			nguoiChoiChon = Byte.parseByte(scan.nextLine());
			flag = kiemTraNhap(nguoiChoiChon);
			// Kiểm tra nhập
			while (flag) {
				System.out.println("Vui lòng chọn lại 1-3");
				nguoiChoiChon = Byte.parseByte(scan.nextLine());
				flag = kiemTraNhap(nguoiChoiChon);
			}
			mayChon = (byte) (Math.random() * 3 + 1);
			//thêm biến xử lý return 0 thua, 1 thắng , 2 hòa tránh gọi hàm nhiều lần
			byte xuLyThangThua = xuLyThangThua(nguoiChoiChon, mayChon);
			if (xuLyThangThua == 1) {
				tongVanThang++;
				System.out.println("\nBạn thắng!");
			}
			else if (xuLyThangThua == 0) {
				tongVanThua++;
				System.out.println("\nBạn thua!");
			}
			else {
				System.out.println("\nHòa");
			}
			System.out.println("bạn có muốn chơi tiếp?\nNhập số khác 0 để tiếp tục, nhập 0 để dừng.");
			short nhap = Short.parseShort(scan.nextLine());
			if (nhap == 0) {
				break; // dừng.
			} else {
				flag = false; // tiếp tục chơi. Dự phòng cờ bị đổi giá trị khi cờ check lỗi nhập, v.v
				tongVanChoi++;
			}
		} while (flag == false);
		inKetQua(tongVanChoi, tongVanThang, tongVanThua);
	}

	public static boolean kiemTraNhap(Byte luaChon) {
		if (luaChon > 0 & luaChon < 4)
			return false; // không chọn sai
		else
			return true; // Chọn sai
	}

	public static Byte xuLyThangThua(Byte nguoiChoiChon, Byte mayChon) {
		// return 0 thua, 1 thắng , 2 hòa
		byte nguoiChoiThang = 0;
		switch (nguoiChoiChon) {
		case 1:
			System.out.print("Người chơi: Bao, ");
			switch (mayChon) {
			case 1:
				System.out.print("Máy: Bao ");
				return nguoiChoiThang = 2;
			case 2:
				System.out.print("Máy: Kéo ");
				return nguoiChoiThang = 1;
			case 3:
				System.out.print("Máy: Kim ");
				return nguoiChoiThang = 0;
			}
			break;
		case 2:
			System.out.print("Người chơi: Kéo, ");
			switch (mayChon) {
			case 1:
				System.out.print("Máy: Bao ");
				return nguoiChoiThang = 0;
			case 2:
				System.out.print("Máy: Kéo ");
				return nguoiChoiThang = 2;
			case 3:
				System.out.print("Máy: Kim ");
				return nguoiChoiThang = 1;
			}
			break;
		default:
			System.out.print("Người chơi: Kim, ");
			switch (mayChon) {
			case 1:
				System.out.print("Máy: Bao ");
				return nguoiChoiThang = 1;
			case 2:
				System.out.print("Máy: Keo ");
				return nguoiChoiThang = 0;
			case 3:
				System.out.print("Máy: Kim ");
				return nguoiChoiThang = 2;
			}
		}
		return nguoiChoiThang;
	}

	public static void inKetQua(short tongVanChoi, short tongVanThang, short tongVanThua) {
		System.out.println("Kết quả game :" + "\nBạn đã chơi " + tongVanChoi + " games\nBạn thắng " + tongVanThang
				+ "\nBạn thua " + tongVanThua + "\nHòa " + (tongVanChoi - (tongVanThang + tongVanThua)));
	}

	public static void main(String[] args) {
		/*
		 * In mở đầu , Nhập 1. Bao, 2. Kéo 3.Kim Máy chọn random 1 đến 3 So sánh ai Bao
		 * thắng Kéo, Kéo thắng kim, kim thắng Bao (1 thắng 2 , 2 thắng 3, 3 thắng 1) &
		 * (3 thua 2, 2 thua 1, 1 thua 3) thắng ai thua Lưu điểm ( Lưu số lần + Số lần
		 * thắng + thua ); do có hòa nên phải lưu thua. chơi tiếp hoặc nghỉ
		 */
		Scanner scan = new Scanner(System.in);
		oanTuXi(scan);
	}

}
