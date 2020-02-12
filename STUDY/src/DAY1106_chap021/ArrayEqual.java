package DAY1106_chap021;

import java.util.Random;
import java.util.Scanner;

public class ArrayEqual {

	static boolean equals(int[] a, int[] b) { // �� �迭�� ��� ��Ұ� ���� ���� ������ �ִ°� !!! 
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("�迭 a�� ��ڼ� : "	);
		int na = sc.nextInt();
		
		int[] a = new int[na];
		
		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
//			a[i] = rand.nextInt(50);
		}
		
		System.out.print("�迭 b�� ��� �� : ");
		int nb = sc.nextInt();
		
		int[] b = new int[nb];
		
		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = sc.nextInt();
//			b[i] = rand.nextInt(50);
		}
		
		System.out.println("�迭 a�� �迭 b�� ��� ��� ���� " + (equals(a,b) ? "�����ϴ�" : "�ٸ��ϴ�."));
		
		
	}

}