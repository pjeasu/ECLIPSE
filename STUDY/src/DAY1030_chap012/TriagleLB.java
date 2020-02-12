package DAY1030_chap012;

import java.util.Scanner;

public class TriagleLB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		
		do {
			System.out.println("몇단 삼각형 입니까? ");
			System.out.print("> ");
			n = sc.nextInt();
		}while(n<=0); // 음수나 0을 입력했을시 다시 입력받도록
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		
	}

}
