package DAY1202_chap033;

import java.util.Scanner;

public class Prac03 {

	// �迭 a�� ���� n�� ��ҿ��� key�� ���� ��� ����� index�� �迭 idx�� �Ӹ����� ���ʷ� �����Ͽ� ���� ��ڼ��� ��ȯ
	static int searchIdx(int[] a, int n, int key, int[] idx) {
		int count = 0; // key�� ���� ��ڼ�
		for (int i = 0; i < n; i++)
			if (a[i] == key)
				idx[count++] = i;
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ���");
		int num = sc.nextInt();
		int[] x = new int[num]; // ��ڼ� num�� �迭
		int[] y = new int[num]; // ��ڼ� num�� �迭

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]��");
			x[i] = sc.nextInt();
		}
		System.out.print("ã�� ����"); // Ű ���� �Է� ����
		int ky = sc.nextInt();

		int count = searchIdx(x, num, ky, y);

		if (count == 0)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			for (int i = 0; i < count; i++)
				System.out.println("�� ���� " + "x[" + y[i] + "]�� �ֽ��ϴ�.");
	}

}
