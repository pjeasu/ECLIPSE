package DAY1030_chap012;

import java.util.Scanner;

public class Prac17 {

	static void npira(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
				System.out.print(i % 10); // 두자리수부터는 끝자리수로 출력하기위해
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.println("몇단 삼각형 입니까? ");
			System.out.print("> ");
			n = sc.nextInt();
		} while (n <= 0); //

		npira(n);
	}
}
