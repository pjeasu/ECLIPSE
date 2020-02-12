package DAY1107_chap021;

import java.util.Scanner;

//�迭�� ���ʿ� �Ʒ��ڸ��� �ƴ϶� ���ڸ��� �־�δ� �޼ҵ带 �ۼ�
public class Prac06 {
	static int cardConv(int x, int r, char[] d) {
		int digit = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digit++] = dchar.charAt(x % r);
			x /= r;

		} while (x != 0);

		for (int i = 0; i < digit / 2; i++) { // digit�� d.length�� ������
			swap(d, i, digit - i - 1);
		}
		return digit;
	}

	static void swap(char[] d, int idx1, int idx2) {
		char t = d[idx1];
		d[idx1] = d[idx2];
		d[idx2] = t;
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
