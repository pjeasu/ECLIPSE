package DAY1104_chap021;

import java.util.Random;
import java.util.Scanner;

public class Prac01 {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("Ű�� �ִ�");
		int num = rand.nextInt(10);
		System.out.println("��� �� :" + num);

		int[] height = new int[num];

		System.out.println("Ű ���� �Ʒ��� ����");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90); //����� ���� ������ ����!! nextInt(int num):0 ���� num-1���� ������ �ִ� ������ ��ȯ
			System.out.println("height[" + i + "] : " + height[i]);
		}

		System.out.println("�ִ��� " + maxOf(height) + "�Դϴ�. ");
	}

}
