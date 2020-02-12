package board03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BoardViewer {
	public static void main(String[] args) throws Exception {
		ConnectionMaker m = new MySqlConnectionMaker(); // oracle을 쓰게되면 OracleConnectionMaker클래스를 만들고 객체를 만들어주면됨
		BoardController c = new BoardController(m);
		//데이터베이스와 통신을 하는 쿼리가 들어있는 메소드들을 가지고있는 BoardController c를 만듬 이건 mysql과 연결이되어야 돌아감
		// BoardController의 필드인 커넥션을 파라미터로 넘어온 커넥션 메이커의 m.connctionmaker 로 .. ㅗ기화

		// c.setConn(m);//생략시 프로그램 실행 안됨.

		Scanner scan = new Scanner(System.in);
		showMenu(c, scan);
		scan.close();
	}

	private static void showMenu(BoardController boardController, Scanner scan) {
		while (true) {
			System.out.println("===========================");
			System.out.println("\t     게시판\t");
			System.out.println("===========================");
			System.out.println("1.목록보기 2.입력하기 3.종료하기");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
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
		System.out.print("제목 : ");
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(scan.nextLine());
		System.out.print("내용 : ");
		boardVO.setContent(scan.nextLine());
		boardController.insert(boardVO);
		showList(boardController, scan);
	}

	private static void showList(BoardController boardController, Scanner scan) {
		ArrayList<BoardVO> list = boardController.selectAll();
		Collections.reverse(list);
		System.out.println("===========================");
		System.out.println("글번호\t제목\t입력날짜");
		System.out.println("===========================");
		if (list.size() == 0) {
			System.out.println("작성된 글이 없습니다.");
		} else {
			for (BoardVO b : list) {
				// System.out.println(b.getId() + "\t" + b.getTitle()+ "\t" +..)
				// b.getWrittenDate());//toString한 결과값을 내보낸다... BoardVO에서 toString을 만들어서 집어넣음
				System.out.println(b);
			}
			System.out.println("글 번호 선택 (0은 메인메뉴로)");
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
			System.out.println("잘못 입력하셨습니다.");
			showList(boardController, scan);
		} else {
			System.out.println("===========================");
			System.out.println("제목 : " + boardVO.getTitle());
			System.out.println("===========================");
			System.out.println("작성일 : " + boardVO.getWrittenDate());
			System.out.println("수정일 : " + boardVO.getUpdatedDate());
			System.out.println("===========================");
			System.out.println(boardVO.getContent());
			System.out.println("===========================");
			System.out.println("1.수정 2.삭제 3.리스트로");
			System.out.print("> ");
			int choice = scan.nextInt();
			if (choice == 3) {
				showList(boardController, scan);
			} else if (choice == 1) {
				update(boardController, scan, id);
			} else if (choice == 2) {
				delete(boardController, id);
				System.out.println(id + "번 글이 삭제되었습니다.");
				showList(boardController, scan);
			}
		}

	}

	private static void delete(BoardController boardController, int id) {
		boardController.delete(id);

	}

	private static void update(BoardController boardController, Scanner scan, int id) {
		scan.nextLine(); // 버퍼메모리지우기
		BoardVO boardVO = new BoardVO(); //값을 넣어 boardcontroller.update에 값을 set해주기위해서 boardVO타입의 객채로 만들어준것
		System.out.print("제목 : ");
		boardVO.setTitle(scan.nextLine());
		System.out.print("내용 : ");
		boardVO.setContent(scan.nextLine());
		boardVO.setId(id);//id값이 없으면 where값이 없게됨 그러면 전체가 다 위 데이터로 수정됨
		boardController.update(boardVO);
		System.out.println(id + "번 글이 수정되었습니다.");
		showOne(boardController, scan, id);
	}

}
