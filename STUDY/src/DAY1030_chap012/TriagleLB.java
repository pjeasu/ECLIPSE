package DAY1030_chap012;

import java.util.Scanner;

public class TriagleLB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		System.out.println("���� �Ʒ��� ������ �̵ �ﰢ���� ����մϴ�.");
		
		do {
			System.out.println("��� �ﰢ�� �Դϱ�? ");
			System.out.print("> ");
			n = sc.nextInt();
		}while(n<=0); // ������ 0�� �Է������� �ٽ� �Է¹޵���
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		
	}

}
