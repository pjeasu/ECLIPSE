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
			System.out.println(String.format("%40s", "웹툰"));
			System.out.println("=========================================");
			System.out.println("1.작가별 목록   2.작품별 목록     3.작가 추가    4.종료하기");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 4) {
				System.out.println("사용해주셔서 감사합니다.");
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
		System.out.println(String.format("%-14s%-14s", "작품번호", "작품제목"));
		System.out.println("=========================================");
		if (list.size() == 0) {
			System.out.println("등록된 작품이 없습니다.");
		} else {

			for (InfoVO infoVO : list) {
				// System.out.println(infoVO.getId() + "\t" + infoVO.getTitle());
				System.out.println(String.format("%3s%8s%-14s", infoVO.getId(), " ", infoVO.getTitle()));
			}
			scan.nextLine();
			System.out.println("=========================================");
			System.out.println("작가 번호 선택 (0은 메인메뉴로)");
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
			System.out.println("존재하지 않는 작품번호입니다.");
			showListI(boardController, scan);
		} else {
			System.out.println("=========================================");
			System.out.println("작품이름 : " + infoVO.getTitle());
			System.out.println("-----------------------------------------");
			System.out.println("작가이름 : " + writerVO.getWriter());
			System.out.println("장르 : " + infoVO.getGenre());
			System.out.println("연재 : " + infoVO.getWeek());
			System.out.println("=========================================");
			System.out.println("1.작가정보  2.목록으로");
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
		System.out.print("작가 : ");
		WriterVO writeVO = new WriterVO();
		writeVO.setWriter(scan.nextLine());
		boardController.insertW(writeVO);
		showListW(boardController, scan);

	}

	private static void showListW(BoardController boardController, Scanner scan) {
		ArrayList<WriterVO> list = boardController.selectAll();
		System.out.println("=========================================");
		System.out.println(String.format("%-14s%-14s", "작가번호", "작가이름"));
		System.out.println("=========================================");
		if (list.size() == 0) {
			System.out.println("등록된 작가가 없습니다.");
		} else {

//			for(int i = 0; i< list.size(); i++) {
//				System.out.println(list.get(i));
//			}

			for (WriterVO writerVO : list) {
				System.out.println(writerVO);
			}
			System.out.println("=========================================");
			System.out.println("작가 번호 선택 (0은 메인메뉴로)");
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
			System.out.println("존재하지 않는 작가 번호입니다.");
			showListW(boardController, scan);
		} else {
			System.out.println("=========================================");
			System.out.println("작가이름 : " + writerVO.getWriter());
			System.out.println("-----------------------------------------");
			System.out.println(String.format("%-8s%-15s%10s%10s", "작품번호", "작품이름", "장르", "연재요일"));
			System.out.println("-----------------------------------------");

			if (list.size() == 0) {
				System.out.println("이 작가의 등록된 작품이 없습니다.");
			}

			for (InfoVO infoVO : list) {
				System.out.println(infoVO);
			}
			System.out.println("=========================================");
			System.out.println("1.작품추가    2.작품삭제    3.작가삭제    4.목록으로");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 1) {
				insertI(boardController, scan, id);
				showListW(boardController, scan);
			} else if (choice == 2) {
				deleteI(boardController, scan, id);

			} else if (choice == 3) {
				System.out.println("정말 이 작가를 삭제하시겠습니까?");
				System.out.println("1.삭제  2.취소하고 목록으로");
				int confirm = scan.nextInt();

				if (confirm == 1) {
					deleteW(boardController, id);
					System.out.println(id + "번 작가가 삭제되었습니다.");
					showListW(boardController, scan);
				} else if (confirm == 2) {
					System.out.println("삭제가 취소되었습니다.");
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
		System.out.print("삭제할 작품번호 : ");
		int del = scan.nextInt();
		InfoVO infoVO = boardController.selectI(del);
		int delnum = infoVO.getWriterId();
		if (num != delnum) {
			System.out.println("이 작가의 작품이 아닙니다.");
		} else {
			boardController.deleteI(del);
			System.out.println(del + "번 작품이 삭제되었습니다.");
		}

	}

	private static void insertI(BoardController boardController, Scanner scan, int id) {
		scan.nextLine();
		InfoVO infoVO = new InfoVO();
		System.out.print("작품이름 : ");
		infoVO.setTitle(scan.nextLine());
		System.out.print("장르 : ");
		infoVO.setGenre(scan.nextLine());
		System.out.println("연재요일이 월~일에 해당되면 1~7의 숫자 입력, 완결작품일 경우 8 입력!");
		System.out.print("> ");
		int day = scan.nextInt();

		if (day > 0 && day < 9) {
			switch (day) {
			case 1:
				infoVO.setWeek("월");
				break;
			case 2:
				infoVO.setWeek("화");
				break;
			case 3:
				infoVO.setWeek("수");
				break;
			case 4:
				infoVO.setWeek("목");
				break;
			case 5:
				infoVO.setWeek("금");
				break;
			case 6:
				infoVO.setWeek("토");
				break;
			case 7:
				infoVO.setWeek("일");
				break;
			case 8:
				infoVO.setWeek("완결");
				break;
			}

			boardController.insertI(infoVO, id);

		} else {
			System.out.println("잘못입력하셨습니다.");
		}

		showListW(boardController, scan);
	}
}
