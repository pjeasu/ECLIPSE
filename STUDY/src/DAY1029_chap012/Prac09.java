package DAY1029_chap012;

import java.util.Scanner;

public class Prac09 {
	
	static int sumof(int a, int b) {

		int sum = 0;
		if (a < b) {
			for (int i = a; i <= b; i++) {
				sum += i;
			}
			return sum;
		} else {
			for (int i = b; i <= a; i++) {
				sum += i;
			}
			return sum;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("a : ");
		int a = sc.nextInt();
		System.out.print("b : ");
		int b = sc.nextInt();
		int result = sumof(a, b);

		System.out.println("a와 b를 포함한 그 사이의 정수의 합 : " + result);

	}

}
