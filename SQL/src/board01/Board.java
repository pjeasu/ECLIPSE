package board01;


import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//�����ͺ��̽� ����� �̿��� �Խ��� ���� 01
//���� �������� ������ �Խ��� ����

public class Board {
	int id;
	String title;
	String content;
	Date writtenDate;//ctrl+�����̽��� java.sql.Date �߰� 
	Date updatedDate;
	
	public boolean equals(Object o) { //equals: ��� ��ü�� ���ؼ� ���� ���� >object o�� �޾ƿ�.. 
		if(o instanceof Board) {
			Board b = (Board)o; //Ÿ��ĳ����..!!!
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
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/example?serverTimezone=UTC", "root","1111");//example�ڸ��� ��Ű�� �Է�
			while(true) {
				System.out.println("============ �Խ��� ============");
				System.out.println("1. �� ��Ϻ���  2. �� �ۼ��ϱ�  3. ����");
				System.out.print("> ");
				int choice = scan.nextInt();
				if(choice == 3) {
					System.out.println("������ּż� �����մϴ�.");
					break;
				}else if(choice == 1) {
					//�� ��� �����ֱ� : ��ȣ, ����, �ۼ� ��¥ ������ ���
					//����ڴ� ��ȣ�� �Է��ؼ� ���ϴ� �۷� �̵�
					ArrayList<Board> list = new ArrayList<>(); // sql���� SELECT *�� �� ������� �־��ֱ�����
					String query = "SELECT * FROM board";
					PreparedStatement pstmt = conn.prepareStatement(query);
					ResultSet rs = pstmt.executeQuery();
					while(rs.next()) {//�������� üũ
						Board b = new Board();
						b.id = rs.getInt("id");//������Ÿ�Կ� ���缭 �о���� ���. �̸��� �𸣰� 0,1,2..��° ĭ ��������, �̸��� ĭ ��� ������ֱ� �ΰ���
						b.title = rs.getString("title");
						b.content = rs.getString("content");
						b.writtenDate = rs.getDate("writtenDate");
						b.updatedDate = rs.getDate("updatedDate");
						list.add(b);
						
					}
					System.out.println("=============================");
					System.out.println("   �۹�ȣ\t����\t�ۼ���¥");
					System.out.println("=============================");
					
					if(list.size() == 0) { 
						System.out.println("�ƹ��� ���� �����ϴ�.");
					}else {
						Collections.reverse(list);//��������
						for(Board b : list) {//����Ʈ�� ������ ����. ����Ʈ�� �ִ� �͵� �ϳ��ϳ��� �ӽ÷�  b��� �̸��� ����. �� ����� ����Ҷ��� ��밡�� ���� �����ϰų� �����Ұ���
							System.out.println(b.id+"\t"+b.title+"\t"+b.writtenDate);
						}
						System.out.println("�۹�ȣ ����(0�� ����)");
						System.out.print("> ");
						int boardNum = scan.nextInt();
						if(boardNum != 0) {
							for(Board b : list) {
								if(b.id == boardNum ) {
									System.out.println("===== ���� =====");
									System.out.println(b.title);
									System.out.print("�ۼ��� : ");
									System.out.println(b.writtenDate);
									System.out.println("===== ���� =====");
									System.out.println(b.content);
									System.out.println("1. ����  2. ����  3. ��������");
									System.out.print("> ");
									choice = scan.nextInt();
									if(choice == 2 ) {
										query = "DELETE FROM board WHERE id = ?";//?�� ���� ���� �������ټ�����
										pstmt = conn.prepareStatement(query);
										pstmt.setInt(1, boardNum); //(��ġ index, ������)
										pstmt.execute();
									}else if(choice == 1) {
										System.out.print("���� : ");
										scan.nextLine();//�� ������ ���۸޸𸮸� �����۾�
										//��ĳ�ʴ� ���۸޸𸮸� ������. ���Ͷ��� ����, nextInt�� ���ڸ� �ҷ��� ���Ͱ� ������ ��, nextLine�� ���ڼ��ڿ��� ��θ� �� ������ 
										String title = scan.nextLine(); //���� ���۸޸𸮸� �޴� ����! 
										System.out.print("���� : ");
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
					//�� �ۼ��ϱ�
					//���� :
					//���� :
					//�̷��� ���� ����ڰ� �Է��� �� �ֵ���
					
					scan.nextLine();
					System.out.print("���� : ");
					String title = scan.nextLine();
					System.out.print("���� : ");		
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
