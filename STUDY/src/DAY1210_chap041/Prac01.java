package DAY1210_chap041;

import java.util.Scanner;

import DAY1209_chap041.IntStack;

public class Prac01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("���� ������ �� : " + s.size() + " / " + s.capacity());
			System.out.print("(1)Ǫ�� (2)�� (3)��ũ (4)���� (5)Ŭ���� (6)�˻� (7)full (8)empty (0)���� : ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1:
				System.out.print("������ : ");
				x = sc.nextInt();

				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ���� á���ϴ�.");
				}
				break;

			case 2:
				try {
					x = s.pop();
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;

			case 3:
				try {
					x = s.peek();
					System.out.println("��ũ�� �����ʹ� " + x + "�Դϴ�.");

				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;

			case 4:
				s.dump();
				break;

			case 5:
				s.clear();
				break;

			case 6:
				System.out.print("�˻� �� ������ : ");
				x = sc.nextInt();
				if (s.indexOf(x) >=0) {
					System.out.println(x+ "�� [" + s.indexOf(x) + "]�� �ֽ��ϴ�.");
				}else {
					System.out.println("���� �����ϴ�.");
				}
				
			case 7 :
			System.out.println(s.isEmpty());
			
			case 8 :
				System.out.println(s.isFull());

			}
		}
	}

}
