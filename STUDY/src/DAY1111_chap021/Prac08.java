package DAY1111_chap021;
//�޼ҵ� dayOfYear�� ���� i�� days���� ���� > while�� ���

import java.util.Scanner;

public class Prac08 {

	static int[][] mdays = {
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, 
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } 
	};
	
	static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year% 400 == 0) ? 1:0;
	}
	
	static int dayOfYear(int y, int m, int d) {
		while(--m != 0) {
			d += mdays[isLeap(y)][m-1];
		}
		return d;
	}
	
	public static void main(String[]args) {

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
