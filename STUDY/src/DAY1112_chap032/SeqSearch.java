package DAY1112_chap032;

import java.util.Scanner;

public class SeqSearch {

	static int seqSearch(int[] a, int n, int key) {
		int i = 0;

		while (true) {
			if (i == n)
				return -1; // �˻��� ������ ���, ã�� ���� ���� ��� = -1 ��ȯ
			if (a[i] == key)
				return i; // �˻��� ������ ��� = �ε��� ��ȯ
			i++;
		}
	}
	
	static int seqSearchFor(int[] a, int n, int key) {
		for (int i = 0; i < n; i++) {
			if(a[i] == key)
				return i; // �˻��� ������ ��� = �ε��� ��ȯ
		}
		return -1; // �˻��� ������ ���, ã�� ���� ���� ��� = -1 ��ȯ
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num]; // �Է¹��� ���� ��ڼ��� ����

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		System.out.print(("�˻��� �� : "));
		int key = sc.nextInt(); // Ű �� �Է�

		int idx = seqSearch(x, num, key); // �迭 x���� Ű���� key�� ��Ҹ� �˻�

		if (idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(key + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");

	}

}
