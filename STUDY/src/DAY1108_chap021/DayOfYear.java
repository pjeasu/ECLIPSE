package DAY1108_chap021;

import java.util.Scanner;

//�� �� ��� �� ���� ���� 
public class DayOfYear {

	static int[][] mdays = { // �� ���� �ϼ�
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ���
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // ����
	};

	static int isLeap(int year) { // ���� year���� �����ΰ�? (���� : 1/ ��� : 0)
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	static int dayOfYear(int y, int m, int d) {//���� y�� m�� d���� �� �� ��� �� ���� ����
		int days = d;	//�ϼ�

		for (int i = 1; i < m; i++) {	// 1��!(m-1)���� �� ���� ����
			days += mdays[isLeap(y)][i - 1];
			// isLeap(y)���� y: 0�� ���, 1�� ����
		}
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

			System.out.printf("�� �� %d��°�Դϴ�.\n", dayOfYear(year, month, day));

			System.out.print("�� �� �� �ұ��? (1. �� / 0. �ƴϿ�) : ");
			retry = sc.nextInt();

		} while (retry == 1);

	}

}
