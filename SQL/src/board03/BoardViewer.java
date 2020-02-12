package board03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoardViewer {
	public static void main(String[] args) throws Exception {
		ConnectionMaker m = new MySqlConnectionMaker(); // oracle�� ���ԵǸ� OracleConnectionMakerŬ������ ����� ��ü�� ������ָ��
		BoardController c = new BoardController(m);
		//�����ͺ��̽��� ����� �ϴ� ������ ����ִ� �޼ҵ���� �������ִ� BoardController c�� ���� �̰� mysql�� �����̵Ǿ�� ���ư�
		// BoardController�� �ʵ��� Ŀ�ؼ��� �Ķ���ͷ� �Ѿ�� Ŀ�ؼ� ����Ŀ�� m.connctionmaker �� .. �Ǳ�ȭ

		// c.setConn(m);//������ ���α׷� ���� �ȵ�.

		Scanner scan = new Scanner(System.in);
		showMenu(c, scan);
		scan.close();
	}

	private static void showMenu(BoardController boardController, Scanner scan) {
		while (true) {
			System.out.println("===========================");
			System.out.println("\t     �Խ���\t");
			System.out.println("===========================");
			System.out.println("1.��Ϻ��� 2.�Է��ϱ� 3.�����ϱ�");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			} else if (choice == 1) {
				showList(boardController, scan);
			} else if (choice == 2) {
				insert(boardController, scan);

			}
		}
	}

	private static void insert(BoardController boardController, Scanner scan) {
		scan.nextLine();
		System.out.print("���� : ");
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(scan.nextLine());
		System.out.print("���� : ");
		boardVO.setContent(scan.nextLine());
		boardController.insert(boardVO);
		showList(boardController, scan);
	}

	private static void showList(BoardController boardController, Scanner scan) {
		ArrayList<BoardVO> list = boardController.selectAll();
		Collections.reverse(list);
		System.out.println("===========================");
		System.out.println("�۹�ȣ\t����\t�Է³�¥");
		System.out.println("===========================");
		if (list.size() == 0) {
			System.out.println("�ۼ��� ���� �����ϴ�.");
		} else {
			for (BoardVO b : list) {
				// System.out.println(b.getId() + "\t" + b.getTitle()+ "\t" +..)
				// b.getWrittenDate());//toString�� ������� ��������... BoardVO���� toString�� ���� �������
				System.out.println(b);
			}
			System.out.println("�� ��ȣ ���� (0�� ���θ޴���)");
			System.out.print("> ");
			int id = scan.nextInt();
			if (id != 0) {
				showOne(boardController, scan, id); 
			}
		}
	}

	private static void showOne(BoardController boardController, Scanner scan, int id) { 
		BoardVO boardVO = boardController.select(id);
		if (boardVO.getId() == 0) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			showList(boardController, scan);
		} else {
			System.out.println("===========================");
			System.out.println("���� : " + boardVO.getTitle());
			System.out.println("===========================");
			System.out.println("�ۼ��� : " + boardVO.getWrittenDate());
			System.out.println("������ : " + boardVO.getUpdatedDate());
			System.out.println("===========================");
			System.out.println(boardVO.getContent());
			System.out.println("===========================");
			System.out.println("1.���� 2.���� 3.����Ʈ��");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 3) {
				showList(boardController, scan);
			} else if (choice == 1) {
				update(boardController, scan, id);
			} else if (choice == 2) {
				delete(boardController, id);
				System.out.println(id + "�� ���� �����Ǿ����ϴ�.");
				showList(boardController, scan);
			}
		}

	}

	private static void delete(BoardController boardController, int id) {
		boardController.delete(id);

	}

	private static void update(BoardController boardController, Scanner scan, int id) {
		scan.nextLine(); // ���۸޸������
		BoardVO boardVO = new BoardVO(); //���� �־� boardcontroller.update�� ���� set���ֱ����ؼ� boardVOŸ���� ��ä�� ������ذ�
		System.out.print("���� : ");
		boardVO.setTitle(scan.nextLine());
		System.out.print("���� : ");
		boardVO.setContent(scan.nextLine());
		boardVO.setId(id);//id���� ������ where���� ���Ե� �׷��� ��ü�� �� �� �����ͷ� ������
		boardController.update(boardVO);
		System.out.println(id + "�� ���� �����Ǿ����ϴ�.");
		showOne(boardController, scan, id);
	}

}
