package DAY1104_chap021;

import java.util.Scanner;

public class Prac02 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void reverse(int[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]�� ���� a[" + (a.length - i - 1) + "]�� ���� ��ȯ�մϴ�.");
			swap(a, i, a.length - i - 1);
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		System.out.println("���� ������ ���ƽ��ϴ�.");

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int num = sc.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();

		}
		reverse(x);

//		System.out.println("��Ҹ� �������� �����߽��ϴ�.");
//		for (int i = 0; i < num; i++) {
//			System.out.println("x[" + i + "] = " + x[i]);
//		}

	}

}
