package DAY1030_chap012;

//a, b ���� �Է¹ް�, b - a�� ���� ���Ѵ�. b�� ���� a���� �۴ٸ�  �׷������������� �Է��� �ٽ� �޴´�. 
import java.util.Scanner;

public class Prac10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		do {
			System.out.println("b - a �� ���� ����");
		System.out.print("a : ");
		a = sc.nextInt();
		System.out.print("b : ");
		b = sc.nextInt();
		} while(b < a);
		
		int min = b - a;
		System.out.println("b - a = " + min);
			
		
		
	}

}
