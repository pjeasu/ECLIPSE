package DAY1202_chap033;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num];

		System.out.println("������������ �Է��ϼ���.");

		System.out.print("x[0]: ");
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] :");
				x[i] = sc.nextInt();

			} while (x[i] < x[i - 1]); //������������ �Է��Ҷ����� �ݺ�..
		}
		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();

		int idx = Arrays.binarySearch(x, ky);
									//�迭�� ã�� ���

		if (idx < 0)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");

	}

}
