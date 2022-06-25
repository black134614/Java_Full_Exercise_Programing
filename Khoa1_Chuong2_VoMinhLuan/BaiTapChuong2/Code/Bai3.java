import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nhập tọa độ tâm đường tròn C:\nxC = ");
		float xC = Float.parseFloat(scan.nextLine());
		System.out.print("yC = ");
		float yC = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập bán kính R = ");
		final float radius = Float.parseFloat(scan.nextLine());
		System.out.print("Nhập tọa độ điểm M cần kiểm tra:\nxM = ");
		float xM = Float.parseFloat(scan.nextLine());
		System.out.print("yM = ");
		float yM = Float.parseFloat(scan.nextLine());
		if(xM >= (xC - radius) & xM <= (xC + radius) & yM >= (yC - radius) & yM <= (yC + radius)) {
			System.out.println("M nằm trong đường tròn tâm C");
		}
		else System.out.println("M không nằm trong đường tròn tâm C");
	}

}
