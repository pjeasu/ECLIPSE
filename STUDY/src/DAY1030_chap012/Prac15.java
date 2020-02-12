package DAY1030_chap012;

import java.util.Scanner;

public class Prac15 {

	static void triangleLB(int n) {// 왼쪽 아래가 직각
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	static void triangleLU(int n) {// 왼쪽 위가 직각
		for (int i = 1; i <= n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	static void triangleRU(int n) {// 오른쪽 위가 직각
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= i - 1; j++) {
//				System.out.print(" ");
//			}
//			for (int j = n; j >= i; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= n; i++) {
			System.out.printf(String.format("%%%ds", i), "*");
			for (int j = 1; j <= n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	}

	static void triangleRB(int n) {// 오른쪽 아래가 직각
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
//		for (int i = 1; i <= n; i++) {
//			System.out.printf(String.format("%%%ds", (n - i + 1)), "*");
//			for (int j = 1; j <= i - 1; j++)
//				System.out.print("*");
//			System.out.println();
//		}
		
		
//		String pattern = "*"; // 상수형 문자열
//		for (int i = 1; i <= n; i++) {
//			System.out.format(String.format("%%%ds\n", n), pattern);// n이 10이라면 출력은 %10s\n
//			pattern += "*";
//		}
		
		
//		for (int i = 1; i <= n; i++) {
//			for(int j = 5; j>0; j--) {
//				if(j>i) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;

		do {
			System.out.println("몇단 삼각형 입니까? ");
			System.out.print("> ");
			n = sc.nextInt();
		} while (n <= 0); // 음수나 0을 입력했을시 다시 입력받도록

		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
	}

}
