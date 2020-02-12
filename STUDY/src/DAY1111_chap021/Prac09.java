package DAY1111_chap021;

import java.util.Scanner;

//y�� m�� d���� �� �� ���� �ϼ��� ���ϴ� �޼ҵ� �ۼ�

public class Prac09 {

	static int[][] mdays = { // �� ���� �ϼ�
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } 
		};

	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	static int leftDayOfYear(int y, int m, int d) {
		int days = 0;
		
		for (int i = 1; i < m; i++) {
			d += mdays[isLeap(y)][i-1];
		}
		days = 365 + isLeap(y) - d;
		
		return days;
	}

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int retry;

		System.out.println("�� �� ��� �ϼ��� ���մϴ�.");

		do {
			System.out.print("�� : ");
			int year = sc.nextInt();
			System.out.print("�� : ");
			int month = sc.nextInt();
			System.out.print("�� : ");
			int day = sc.nextInt();

			System.out.printf("%d�⵵�� ���� �� �� �� %d�Դϴ�.\n", year, leftDayOfYear(year, month, day));

			System.out.print("�� �� �� �ұ��? (1. �� / 0. �ƴϿ�) : ");
			retry = sc.nextInt();

		} while (retry == 1);

	}
}
