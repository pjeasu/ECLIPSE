package DAY1029_chap012;

import java.util.Scanner;

public class Prac08 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�����Է� : ");
		int num = sc.nextInt();
		int sum = 0;
		
		sum = (1+num)*(num/2);
		
		System.out.println("1���� " + num + "������ ���� " + sum + "�Դϴ�.");
	}
	
}
