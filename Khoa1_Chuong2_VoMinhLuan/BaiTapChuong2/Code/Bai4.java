import java.util.Scanner;

public class Bai4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float yardLength, treeRadius, treeSpace;
		System.out.println("Mời bạn nhập chiều dài sân");
		yardLength = Float.parseFloat(scan.nextLine());
		System.out.println("Mời bạn nhập bán kính của cây");
		treeRadius = Float.parseFloat(scan.nextLine());
		System.out.println("Mời bạn nhập không gian giữ các cây");
		treeSpace = Float.parseFloat(scan.nextLine());
		int numberTree = (int) (yardLength / ((treeRadius * 2) + treeSpace));
		float totalTreeSpace = numberTree * treeRadius * 2;
		System.out.println("Số cây có thể trồng trong sân là: " + numberTree);
		System.out.println("Độ dài không gian cây sẽ chiếm khi lớn là: " + totalTreeSpace);
	}

}
