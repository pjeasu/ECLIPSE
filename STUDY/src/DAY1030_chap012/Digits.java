package DAY1030_chap012;

import java.util.Scanner;

public class Digits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;
		
		System.out.println("2자리의 정수 입력하기");
		
		do {
			System.out.print("입력 : ");
			no = sc.nextInt();
		}while(no<10 || no>99);
	
	System.out.println("변수 no의 값은 " + no + "가(이) 되었습니다.");
	
	}
}
