package DAY1030_chap012;

import java.util.Scanner;

//���� ������ �Է¹ް� �ڸ����� ����ϴ� ���α׷�
public class Prac11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("���� ���� �Է� : ");
		int num = sc.nextInt();
		int count = 0;

		for (int i = 0; i <= num; i++) {
			i *= 10;
			count++;
		}

		System.out.println("�Է��� ���� ���̴� " + (count - 1) + "�Դϴ�.");
	}

}
