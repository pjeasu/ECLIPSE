package comic;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardViewer {
	public static void main(String[] args) throws Exception {
		ConnectionMaker m = new MySqlConnectionMaker();
		BoardController c = new BoardController(m);
		Scanner scan = new Scanner(System.in);
		showMenu(c, scan);
		scan.close();
	}

	private static void showMenu(BoardController boardController, Scanner scan) {
		while (true) {
			System.out.println("=========================================");
			System.out.println(String.format("%40s", "����"));
			System.out.println("=========================================");
			System.out.println("1.�۰��� ���   2.��ǰ�� ���     3.�۰� �߰�    4.�����ϱ�");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 4) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			} else if (choice == 1) {
				showListW(boardController, scan);
			} else if (choice == 2) {
				showListI(boardController, scan);
			} else if (choice == 3) {
				insertW(boardController, scan);
			}
		}
	}

	private static void showListI(BoardController boardController, Scanner scan) {
		ArrayList<InfoVO> list = boardController.selectAllInfo();
		System.out.println("=========================================");
		System.out.println(String.format("%-14s%-14s", "��ǰ��ȣ", "��ǰ����"));
		System.out.println("=========================================");
		if (list.size() == 0) {
			System.out.println("��ϵ� ��ǰ�� �����ϴ�.");
		} else {

			for (InfoVO infoVO : list) {
				// System.out.println(infoVO.getId() + "\t" + infoVO.getTitle());
				System.out.println(String.format("%3s%8s%-14s", infoVO.getId(), " ", infoVO.getTitle()));
			}
			scan.nextLine();
			System.out.println("=========================================");
			System.out.println("�۰� ��ȣ ���� (0�� ���θ޴���)");
			System.out.print("> ");

			int id = scan.nextInt();
			if (id != 0) {
				showOneI(boardController, scan, id);

			}
		}
	}

	private static void showOneI(BoardController boardController, Scanner scan, int id) {
		InfoVO infoVO = boardController.selectI(id);
		WriterVO writerVO = boardController.selectW(infoVO.getWriterId());
		if (infoVO.getId() == 0) {
			System.out.println("�������� �ʴ� ��ǰ��ȣ�Դϴ�.");
			showListI(boardController, scan);
		} else {
			System.out.println("=========================================");
			System.out.println("��ǰ�̸� : " + infoVO.getTitle());
			System.out.println("-----------------------------------------");
			System.out.println("�۰��̸� : " + writerVO.getWriter());
			System.out.println("�帣 : " + infoVO.getGenre());
			System.out.println("���� : " + infoVO.getWeek());
			System.out.println("=========================================");
			System.out.println("1.�۰�����  2.�������");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 1) {
				showOneW(boardController, scan, infoVO.getWriterId());
			} else if (choice == 2) {
				showListI(boardController, scan);
			}
		}
	}

	private static void insertW(BoardController boardController, Scanner scan) {
		scan.nextLine();
		System.out.print("�۰� : ");
		WriterVO writeVO = new WriterVO();
		writeVO.setWriter(scan.nextLine());
		boardController.insertW(writeVO);
		showListW(boardController, scan);

	}

	private static void showListW(BoardController boardController, Scanner scan) {
		ArrayList<WriterVO> list = boardController.selectAll();
		System.out.println("=========================================");
		System.out.println(String.format("%-14s%-14s", "�۰���ȣ", "�۰��̸�"));
		System.out.println("=========================================");
		if (list.size() == 0) {
			System.out.println("��ϵ� �۰��� �����ϴ�.");
		} else {

//			for(int i = 0; i< list.size(); i++) {
//				System.out.println(list.get(i));
//			}

			for (WriterVO writerVO : list) {
				System.out.println(writerVO);
			}
			System.out.println("=========================================");
			System.out.println("�۰� ��ȣ ���� (0�� ���θ޴���)");
			System.out.print("> ");
			int id = scan.nextInt();
			if (id != 0) {
				showOneW(boardController, scan, id);

			}
		}
	}

	private static void showOneW(BoardController boardController, Scanner scan, int id) {
		WriterVO writerVO = boardController.selectW(id);
		ArrayList<InfoVO> list = boardController.selectOne(id);
		if (writerVO.getId() == 0) {
			System.out.println("�������� �ʴ� �۰� ��ȣ�Դϴ�.");
			showListW(boardController, scan);
		} else {
			System.out.println("=========================================");
			System.out.println("�۰��̸� : " + writerVO.getWriter());
			System.out.println("-----------------------------------------");
			System.out.println(String.format("%-8s%-15s%10s%10s", "��ǰ��ȣ", "��ǰ�̸�", "�帣", "�������"));
			System.out.println("-----------------------------------------");

			if (list.size() == 0) {
				System.out.println("�� �۰��� ��ϵ� ��ǰ�� �����ϴ�.");
			}

			for (InfoVO infoVO : list) {
				System.out.println(infoVO);
			}
			System.out.println("=========================================");
			System.out.println("1.��ǰ�߰�    2.��ǰ����    3.�۰�����    4.�������");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 1) {
				insertI(boardController, scan, id);
				showListW(boardController, scan);
			} else if (choice == 2) {
				deleteI(boardController, scan, id);

			} else if (choice == 3) {
				System.out.println("���� �� �۰��� �����Ͻðڽ��ϱ�?");
				System.out.println("1.����  2.����ϰ� �������");
				int confirm = scan.nextInt();

				if (confirm == 1) {
					deleteW(boardController, id);
					System.out.println(id + "�� �۰��� �����Ǿ����ϴ�.");
					showListW(boardController, scan);
				} else if (confirm == 2) {
					System.out.println("������ ��ҵǾ����ϴ�.");
					showListW(boardController, scan);
				}
			} else if (choice == 4) {
				showListW(boardController, scan);
			}
		}
	}

	private static void deleteW(BoardController boardController, int id) {
		boardController.deleteW(id);
	}

	private static void deleteI(BoardController boardController, Scanner scan, int id) {

		// InfoVO infoVO2 = boardController.selectI(id);
		WriterVO writerVO = boardController.selectW(id);
		int num = writerVO.getId();
		scan.nextLine();
		System.out.print("������ ��ǰ��ȣ : ");
		int del = scan.nextInt();
		InfoVO infoVO = boardController.selectI(del);
		int delnum = infoVO.getWriterId();
		if (num != delnum) {
			System.out.println("�� �۰��� ��ǰ�� �ƴմϴ�.");
		} else {
			boardController.deleteI(del);
			System.out.println(del + "�� ��ǰ�� �����Ǿ����ϴ�.");
		}

	}

	private static void insertI(BoardController boardController, Scanner scan, int id) {
		scan.nextLine();
		InfoVO infoVO = new InfoVO();
		System.out.print("��ǰ�̸� : ");
		infoVO.setTitle(scan.nextLine());
		System.out.print("�帣 : ");
		infoVO.setGenre(scan.nextLine());
		System.out.println("��������� ��~�Ͽ� �ش�Ǹ� 1~7�� ���� �Է�, �ϰ���ǰ�� ��� 8 �Է�!");
		System.out.print("> ");
		int day = scan.nextInt();

		if (day > 0 && day < 9) {
			switch (day) {
			case 1:
				infoVO.setWeek("��");
				break;
			case 2:
				infoVO.setWeek("ȭ");
				break;
			case 3:
				infoVO.setWeek("��");
				break;
			case 4:
				infoVO.setWeek("��");
				break;
			case 5:
				infoVO.setWeek("��");
				break;
			case 6:
				infoVO.setWeek("��");
				break;
			case 7:
				infoVO.setWeek("��");
				break;
			case 8:
				infoVO.setWeek("�ϰ�");
				break;
			}

			boardController.insertI(infoVO, id);

		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}

		showListW(boardController, scan);
	}
}
