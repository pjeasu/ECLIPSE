package DAY1107_chap021;

import java.util.Scanner;

public class Prac07 {
	static int cardConv(int x, int r, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.printf("%4d | %10d \n",r, x);
		System.out.println("     +--------------");
		do {
			d[digits++] = dchar.charAt(x % r);
			x /= r;
			
			System.out.printf("%4d | %10d    ...%3d\n",r, x,x%r);
			//System.out.println(r + "|" + x + " . . . . "+(x%r));
			System.out.println("     ---------------");
		} while (x != 0);
		System.out.printf("       %10d    ...%3d\n",x,x%r);
		
		return digits;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no; // ��ȯ�ϴ� ����
		int cd; // ���
		int dno; // ��ȯ ���� �ڸ���
		char[] cno = new char[32]; // ��ȯ �� �� �ڸ��� ���ڸ� �־�δ� ������ �迭

		System.out.println("10������ ��� ��ȯ�մϴ�.");
		do {
			System.out.print("��ȯ�ϴ� ���� �ƴ� ���� : ");
			no = sc.nextInt();
		} while (no < 0); // �Էµ� ���� 0������ �����̸� �ٽ� �Է��ϵ���

		do {
			System.out.print("� ������ ��ȯ �ұ��? (2~36) : ");
			cd = sc.nextInt();
		} while (cd < 2 || cd > 36); // �Էµ� ���� 2~36���� ��� ���̸� �ٽ� �Է��ϵ���
		dno = cardConv(no, cd, cno);

		System.out.print(cd + "�����δ� ");
		for (int i = 0; i <= dno; i++) {
			System.out.print(cno[i]);
		}

		System.out.println("�Դϴ�.");
	}
	

}
