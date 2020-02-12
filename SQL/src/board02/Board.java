package board02;
//게시판 예제 02
//최소한 CRUD 명령어를 메소드로 분리시키자 !

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class Board {
	int id;
	String title;
	String content;
	Date writtenDate;
	Date updatedDate;
	
	//메소드마다 반복해서 입력해야하기때문에 전역상수로 지정
	final static String URL = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC";
	final static String USERNAME = "root";
	final static String PASSWORD = "1111";
	
	
	
	//SELECT * FROM board;
	public static ArrayList<Board> selectAll() { //리턴타입은 ArrayList  <>안에 Board를 넣어 Board만 넣을수있게 제한!!!! 전체르 ㄹ불러오는것이므로 매개변수가 없음 
		ArrayList<Board> list = new ArrayList<>(); //Arraylist 객체를 하나 만들어줌 초기화됐으므로 사이즈는 0

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//컴퓨터랑연결하는것
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD); //데이터베이스랑 연결할때 필요한 세가지 입력
			String query = "SELECT * FROM board";
			PreparedStatement pstmt = conn.prepareStatement(query); 
			//query자리에 바로 SELECT * FROM board를 넣어도되지만 그렇게되면 magic number가 되므로 query라는 객체에 담아서 넣기
			//준비된(prepare)스테이트먼트객체 : 커넥션 객체는 쿼리문을 준비시켜줄수있음    
			ResultSet rs = pstmt.executeQuery(); // pstmt에 담겨있는 준비된 쿼리문을 rs에 대입..
			while(rs.next()) {
				//next()는 이 줄이 끝나고나서 다음줄이 존재하는지 안하는지 true false로 알려줌, 그리고 다음 row로 커서를 이동시켜줌
				Board b = new Board(); //어레이리스트에는 board타입만 넣을수있으므로 임시로 board타입의 객체를 만들어서 하나씩 넣어줌 ! 
				b.id = rs.getInt("id"); //ResultSet에 있는 id값을 가져오려면 그 타입인 int 을 지정해서 가져와야함 인덱스 번호가아니라 컬럼의 이름으로 호출하는것.."id"라는 이름의 컬럼! 
				b.title = rs.getString("title");
				b.content = rs.getString("content");//컬럼 데이터타입은 TEXT였지만 같은 문자열이므로 가져오는데 문제는 전혀 없다 
				b.writtenDate = rs.getDate("writtenDate");
				b.updatedDate = rs.getDate("updatedDate");
				list.add(b);// rs값이 담긴 객체 b를 list에 추가
			}
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static Board select(int id) {//글 하나를 가져오는것이므로 int를 지정해서 불러옴
		Board b = new Board();// 기본생성자는 값이 0으로 초기화 됨 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT * FROM board WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);// 물음표에대해 id가 아닌 값을 미리 지정해줄수있음 int기만하면! 
			ResultSet rs = pstmt.executeQuery(); //executeQuery는 항상 결과값을 리턴한다 
			while(rs.next()) {//while이 없으면 커서위치를.. 바꾼다고한다......false여도 진행해서..?
				b.id = rs.getInt("id");
				b.title = rs.getString("title");
				b.content = rs.getString("content");
				b.writtenDate = rs.getDate("writtenDate");
				b.updatedDate = rs.getDate("updatedDate");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;//글 하나만 반환 
	}
	
	public static void insert(Board b) {//스트링객체를 지정해도되지만 유지보수입장에서 많이 번거로워짐 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO board(title, content, writtenDate, updatedDate) VALUES(?, ?, NOW(),NOW())";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.title);
			pstmt.setString(2, b.content);//물음표 갯수만큼 인덱스도 맞추기 모두 지정해줘야함
			pstmt.execute();//결과값이 없으므로 executeQuery가 아님 , 결과값을 반환하는게아니라 실행만 한다 
			
		}catch(Exception e){
			e.printStackTrace();
		}//
	}
	
	public static void delete(int id) {//int id로 하느냐, board b로 하느냐.. 지금 상황에서는 크게 상관없다...
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,USERNAME, PASSWORD);
			String query = "DELETE FROM board WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Board b) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String query = "UPDATE board SET title = ?, content = ?, updatedDate = NOW() WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.title);
			pstmt.setString(2, b.content);
			pstmt.setInt(3, b.id);
			pstmt.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("=========== 게시판  ===========");
			System.out.println("1. 목록  2. 입력  3. 종료 ");
			System.out.print("> ");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else if(choice == 1) {
				ArrayList<Board> list = selectAll(); //selectAll()메소드를 객체 생성하지않고 가져오기위해 전체에 static
				Collections.reverse(list);
				System.out.println("========== 목록 ==========");
				if(list.size()==0) {
					System.out.println("글이 없습니다.");
				}else {
					System.out.println("번호\t제목\t작성일\t");
					for(Board b : list) { //board타입 객체 b에 담긴 데이터를 복사해와서 출력...수정이나 입력은 하지않고 출력말할때 for each 사용
						System.out.println(b.id+"\t"+b.title+"\t"+b.writtenDate);
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("글번호 선택 (0은 종료)");
					System.out.print("> ");
					int boardId = scan.nextInt();
					if(boardId != 0) {
						Board b = select(boardId); //select 메소드 호출... 실행.. 
						if(b.id == 0) { //select에서 반환된 값이 0일때 ! 존재하지않는 boardId값을 셀렉메소드에 넣어서 while문에 들어가지못해 id값이 0이됨 > 자동으로 예외처리해줌
							System.out.println("잘못 선택하셨습니다.");
						}else {
							System.out.println("==========================");
							System.out.println("제목 : " + b.title);
							System.out.println("==========================");
							System.out.println("작성일 : "+ b.writtenDate);
							System.out.println("수정일 : "+ b.updatedDate);
							System.out.println("===========================");
							System.out.println("\t---내용---\t");
							System.out.println(b.content);
							System.out.println("===========================");
							System.out.println("1. 수정  2. 삭제   3. 메인으로");
							System.out.print("> ");
							choice = scan.nextInt();
							if (choice == 1) {
								scan.nextLine();
								Board update = new Board();// board타입의 객체를 새로 만든다
								update.id = boardId;
								System.out.print("제목 : ");
								update.title = scan.nextLine();
								System.out.print("내용 : ");
								update.content = scan.nextLine();
								update(update);
								System.out.println(boardId + "번 글이 수정되었습니다.");
								System.out.println("");
							}else if (choice == 2){
								 delete(boardId);
							}
							
						}	
						
					}
				}
			}else if(choice == 2) {
				scan.nextLine();
				System.out.println("=============================");
				System.out.print("제목 : ");
				String title = scan.nextLine();
				System.out.println("=============================");
				System.out.print("내용 : ");
				String content = scan.nextLine();
				Board b = new Board();
				b.title = title;
				b.content = content;
				insert(b);
			
				
			}
		}
		
		scan.close();
	}
	
}
