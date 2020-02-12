package board01;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//데이터베이스 통신을 이용한 게시판 예제 01
//가장 원시적인 형태의 게시판 예제

public class Board {
	int id;
	String title;
	String content;
	Date writtenDate;//ctrl+스페이스바 java.sql.Date 추가 
	Date updatedDate;
	
	public boolean equals(Object o) { //equals: 모든 객체에 대해서 실행 가능 >object o를 받아옴.. 
		if(o instanceof Board) {
			Board b = (Board)o; //타입캐스팅..!!!
			if(b.id == this.id) { 
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?serverTimezone=UTC", "root","1111");//example자리에 스키마 입력
			while(true) {
				System.out.println("============ 게시판 ============");
				System.out.println("1. 글 목록보기  2. 글 작성하기  3. 종료");
				System.out.print("> ");
				int choice = scan.nextInt();
				if(choice == 3) {
					System.out.println("사용해주셔서 감사합니다.");
					break;
				}else if(choice == 1) {
					//글 목록 보여주기 : 번호, 제목, 작성 날짜 순으로 출력
					//사용자는 번호를 입력해서 원하는 글로 이동
					ArrayList<Board> list = new ArrayList<>(); // sql에서 SELECT *을 한 결과값을 넣어주기위해
					String query = "SELECT * FROM board";
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {//한줄한줄 체크
						Board b = new Board();
						b.id = rs.getInt("id");//데이터타입에 맞춰서 읽어오는 기능. 이름은 모르고 0,1,2..번째 칸 가져오기, 이름과 칸 기능 명시해주기 두가지
						b.title = rs.getString("title");
						b.content = rs.getString("content");
						b.writtenDate = rs.getDate("writtenDate");
						b.updatedDate = rs.getDate("updatedDate");
						list.add(b);
						
					}
					System.out.println("=============================");
					System.out.println("   글번호\t제목\t작성날짜");
					System.out.println("=============================");
					
					if(list.size() == 0) { 
						System.out.println("아무런 글이 없습니다.");
					}else {
						Collections.reverse(list);//역순으로
						for(Board b : list) {//리스트는 보드의 모임. 리스트에 있는 것들 하나하나를 임시로  b라고 이름을 붙임. 이 방법은 출력할때만 사용가능 값을 수정하거나 삭제불가능
							System.out.println(b.id+"\t"+b.title+"\t"+b.writtenDate);
						}
						System.out.println("글번호 선택(0은 종료)");
						System.out.print("> ");
						int boardNum = scan.nextInt();
						if(boardNum != 0) {
							for(Board b : list) {
								if(b.id == boardNum ) {
									System.out.println("===== 제목 =====");
									System.out.println(b.title);
									System.out.print("작성일 : ");
									System.out.println(b.writtenDate);
									System.out.println("===== 내용 =====");
									System.out.println(b.content);
									System.out.println("1. 수정  2. 삭제  3. 메인으로");
									System.out.print("> ");
									choice = scan.nextInt();
									if(choice == 2 ) {
										query = "DELETE FROM board WHERE id = ?";//?가 직접 값을 세팅해줄수있음
										pstmt = conn.prepareStatement(query);
										pstmt.setInt(1, boardNum); //(위치 index, 넣을값)
										pstmt.execute();
									}else if(choice == 1) {
										System.out.print("제목 : ");
										scan.nextLine();//이 라인이 버퍼메모리를 비우는작업
										//스캐너는 버퍼메모리를 참조함. 엔터또한 문자, nextInt는 숫자만 불러옴 엔터가 들어오면 끝, nextLine는 문자숫자엔터 모두를 다 가져옴 
										String title = scan.nextLine(); //새로 버퍼메모리를 받는 라인! 
										System.out.print("내용 : ");
										String content = scan.nextLine();
										query = "UPDATE board SET title = ?, content = ?, updatedDate = NOW() WHERE id = ?";
										pstmt = conn.prepareStatement(query);
										pstmt.setString(1, title);
										pstmt.setString(2, content);
										pstmt.setInt(3, boardNum);
										pstmt.execute();
									}
									
								}
							}
						}
					}
					
				}else if(choice == 2) {
					//글 작성하기
					//제목 :
					//내용 :
					//이렇게 떠서 사용자가 입력할 수 있도록
					
					scan.nextLine();
					System.out.print("제목 : ");
					String title = scan.nextLine();
					System.out.print("내용 : ");		
					String content = scan.nextLine();
					String query = "INSERT INTO board(title, content, writtenDate, updatedDate) VALUES(?,?,NOW(),NOW())";
					PreparedStatement pstmt = conn.prepareStatement(query);
					pstmt.setString(1, title);
					pstmt.setString(2, content);
					pstmt.execute();
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally {
			if(conn != null && !conn.isClosed() )
			conn.close();
			
		}
		scan.close();
	}
}
