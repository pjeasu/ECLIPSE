package DAY1210_chap041;

import java.util.Scanner;

import DAY1209_chap041.IntStack;

public class Prac01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);

		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)클리어 (6)검색 (7)full (8)empty (0)종료 : ");

			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int x;
			switch (menu) {
			case 1:
				System.out.print("데이터 : ");
				x = sc.nextInt();

				try {
					s.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 가득 찼습니다.");
				}
				break;

			case 2:
				try {
					x = s.pop();
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 3:
				try {
					x = s.peek();
					System.out.println("피크한 데이터는 " + x + "입니다.");

				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("스택이 비어있습니다.");
				}
				break;

			case 4:
				s.dump();
				break;

			case 5:
				s.clear();
				break;

			case 6:
				System.out.print("검색 할 데이터 : ");
				x = sc.nextInt();
				if (s.indexOf(x) >=0) {
					System.out.println(x+ "는 [" + s.indexOf(x) + "]에 있습니다.");
				}else {
					System.out.println("값이 없습니다.");
				}
				
			case 7 :
			System.out.println(s.isEmpty());
			
			case 8 :
				System.out.println(s.isFull());

			}
		}
	}

}
