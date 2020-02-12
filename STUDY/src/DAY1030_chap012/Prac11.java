package DAY1030_chap012;

import java.util.Scanner;

//양의 정수를 입력받고 자릿수를 출력하는 프로그램
public class Prac11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("양의 정수 입력 : ");
		int num = sc.nextInt();
		int count = 0;

		for (int i = 0; i <= num; i++) {
			i *= 10;
			count++;
		}

		System.out.println("입력한 수의 길이는 " + (count - 1) + "입니다.");
	}

}
