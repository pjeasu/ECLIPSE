package DAY1029_chap012;

//n�� �ԷµǴ� ���� 0�̳� �������� �ƴҶ����� n�Է¹ޱ� 
import java.util.Scanner;

public class SumForPos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("1���� n������ ���� ���մϴ�.");

		do {
			System.out.print("n�� �� : ");
			n = sc.nextInt();
		} while (n <= 0); //n�� 0���� Ŭ������ �ݺ� , while, for�� �����ǵ�, dowhile���� �����ǵ�

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		System.out.println("1���� " + n + "������ ���� " + sum + "�Դϴ�.");

	}

}
