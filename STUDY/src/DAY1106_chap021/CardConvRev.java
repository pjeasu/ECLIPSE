package DAY1106_chap021;

import java.util.Scanner;

// �Է¹��� 10������ 2���� ~ 36������ ��� ��ȯ�Ͽ� ��Ÿ�� 
public class CardConvRev {
	static int cardConvR(int x, int r, char[] d) {
		// ������ x�� r������ ��ȯ�Ͽ� �迭 d�� �Ʒ��ڸ����� �־�ΰ� �ڸ����� ��ȯ

		int digits = 0; // ��ȯ ���� �ڸ���
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		do {
			d[digits++] = dchar.charAt(x % r);// r�� ���� �������� ����
			// charAt�� ���ڿ����� ������ ���ڸ� �׼�����!!! ���⼭�� ������!
			x /= r; // ��ȯ�� ������ŭ ��� ������
		} while (x != 0);
		return digits;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no; // ��ȯ�ϴ� ����
		int cd; // ���
		int dno; // ��ȯ ���� �ڸ���
		int retry; // �ٽ� �ѹ� ?
		char[] cno = new char[32]; // ��ȯ�� �� �ڸ��� ���ڸ� �־�δ� ������ �迭

		System.out.println("10������ ��� ��ȯ�մϴ�.");
		do {
			do {
				System.out.print("��ȯ�ϴ� ���� �ƴ� ���� : ");
				no = sc.nextInt();
			} while (no < 0);

			do {
				System.out.print("� ������ ��ȯ �ұ��? (2~36) : ");
				cd = sc.nextInt();
			} while (cd < 2 || cd > 36);
			dno = cardConvR(no, cd, cno); // no�� cd������ ��ȯ

			System.out.print(cd + "�����δ� ");
			for (int i = dno - 1; i >= 0; i--) {//���ڸ����� ���ʴ�� ��Ÿ��
				System.out.print(cno[i]);
			}
			System.out.println("�Դϴ�.");

			System.out.print("�ѹ� �� �ұ��? (1.��/0.�ƴϿ�) :  ");
			retry = sc.nextInt();
		} while (retry == 1);
		System.out.println("����");

	}

}
