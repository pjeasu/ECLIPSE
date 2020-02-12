package DAY1029_chap012;

import java.util.Scanner;

public class SumWhile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;

		while (i <= n) {
			sum += i; // sum = sum + i
			i++;
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		System.out.println("i : " + i);
		//마지막으로 while문을 돌때, i값은 n을 만큼 초과한 상태이므로 입력한 n값보다 1이 큰 값임.
	}

}
