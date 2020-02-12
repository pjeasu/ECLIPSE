package DAY1029_chap012;

//n에 입력되는 값이 0이나 음수값이 아닐때까지 n입력받기 
import java.util.Scanner;

public class SumForPos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("1부터 n까지의 합을 구합니다.");

		do {
			System.out.print("n의 값 : ");
			n = sc.nextInt();
		} while (n <= 0); //n이 0보다 클때까지 반복 , while, for은 사전판독, dowhile문은 사후판독

		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");

	}

}
