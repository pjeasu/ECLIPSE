package DAY1029_chap012;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1���� n������ ���� ���մϴ�.");
		System.out.print("n�� �� : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;

		while (i <= n) {
			sum += i; // sum = sum + i
			i++;
		}
		System.out.println("1���� " + n + "������ ���� " + sum + "�Դϴ�.");
		System.out.println("i : " + i);
		//���������� while���� ����, i���� n�� ��ŭ �ʰ��� �����̹Ƿ� �Է��� n������ 1�� ū ����.
	}

}
