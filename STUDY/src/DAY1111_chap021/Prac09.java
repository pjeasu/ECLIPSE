package DAY1111_chap021;

import java.util.Scanner;

//y년 m월 d일의 그 해 남은 일수를 구하는 메소드 작성

public class Prac09 {

	static int[][] mdays = { // 각 달의 일수
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

		System.out.println("그 해 경과 일수를 구합니다.");

		do {
			System.out.print("년 : ");
			int year = sc.nextInt();
			System.out.print("월 : ");
			int month = sc.nextInt();
			System.out.print("일 : ");
			int day = sc.nextInt();

			System.out.printf("%d년도의 남은 일 수 는 %d입니다.\n", year, leftDayOfYear(year, month, day));

			System.out.print("한 번 더 할까요? (1. 예 / 0. 아니오) : ");
			retry = sc.nextInt();

		} while (retry == 1);

	}
}
