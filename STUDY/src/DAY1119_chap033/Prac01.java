package DAY1119_chap033;

import java.util.Scanner;

//seqSearchSen �޽��带 while���� �ƴ� for���� ����Ͽ� ����
public class Prac01 {
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;

		a[n] = key; //���ʸ� �߰� 


		
		for (i = 0; i < a.length; i++) {
			if(a[i] == key) {
				break;
			}
		}
		
		
		return i == n ? -1 : i; // i�� n�̸� ã������ ���������� �˻� �������� ��Ÿ���� -1 ��ȯ
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("��ڼ� : ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		System.out.print("�˻��� �� : ");
		int ky = sc.nextInt();
		int idx = seqSearchSen(x, num, ky);

		if (idx == -1)
			System.out.println("�� ���� ��Ұ� �����ϴ�.");
		else
			System.out.println(ky + "��(��) x[" + idx + "]�� �ֽ��ϴ�.");

	}
	
}
