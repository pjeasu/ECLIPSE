package DAY1030_chap012;

import java.util.Scanner;

public class Digits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no;
		
		System.out.println("2�ڸ��� ���� �Է��ϱ�");
		
		do {
			System.out.print("�Է� : ");
			no = sc.nextInt();
		}while(no<10 || no>99);
	
	System.out.println("���� no�� ���� " + no + "��(��) �Ǿ����ϴ�.");
	
	}
}
