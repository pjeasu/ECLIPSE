package board02;
//�Խ��� ���� 02
//�ּ��� CRUD ��ɾ �޼ҵ�� �и���Ű�� !

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
	
	//�޼ҵ帶�� �ݺ��ؼ� �Է��ؾ��ϱ⶧���� ��������� ����
	final static String URL = "jdbc:mysql://localhost:3306/example?serverTimezone=UTC";
	final static String USERNAME = "root";
	final static String PASSWORD = "1111";
	
	
	
	//SELECT * FROM board;
	public static ArrayList<Board> selectAll() { //����Ÿ���� ArrayList  <>�ȿ� Board�� �־� Board�� �������ְ� ����!!!! ��ü�� ���ҷ����°��̹Ƿ� �Ű������� ���� 
		ArrayList<Board> list = new ArrayList<>(); //Arraylist ��ü�� �ϳ� ������� �ʱ�ȭ�����Ƿ� ������� 0

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//��ǻ�Ͷ������ϴ°�
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD); //�����ͺ��̽��� �����Ҷ� �ʿ��� ������ �Է�
			String query = "SELECT * FROM board";
			PreparedStatement pstmt = conn.prepareStatement(query); 
			//query�ڸ��� �ٷ� SELECT * FROM board�� �־������ �׷��ԵǸ� magic number�� �ǹǷ� query��� ��ü�� ��Ƽ� �ֱ�
			//�غ��(prepare)������Ʈ��Ʈ��ü : Ŀ�ؼ� ��ü�� �������� �غ�����ټ�����    
			ResultSet rs = pstmt.executeQuery(); // pstmt�� ����ִ� �غ�� �������� rs�� ����..
			while(rs.next()) {
				//next()�� �� ���� �������� �������� �����ϴ��� ���ϴ��� true false�� �˷���, �׸��� ���� row�� Ŀ���� �̵�������
				Board b = new Board(); //��̸���Ʈ���� boardŸ�Ը� �����������Ƿ� �ӽ÷� boardŸ���� ��ü�� ���� �ϳ��� �־��� ! 
				b.id = rs.getInt("id"); //ResultSet�� �ִ� id���� ���������� �� Ÿ���� int �� �����ؼ� �����;��� �ε��� ��ȣ���ƴ϶� �÷��� �̸����� ȣ���ϴ°�.."id"��� �̸��� �÷�! 
				b.title = rs.getString("title");
				b.content = rs.getString("content");//�÷� ������Ÿ���� TEXT������ ���� ���ڿ��̹Ƿ� �������µ� ������ ���� ���� 
				b.writtenDate = rs.getDate("writtenDate");
				b.updatedDate = rs.getDate("updatedDate");
				list.add(b);// rs���� ��� ��ü b�� list�� �߰�
			}
		} catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static Board select(int id) {//�� �ϳ��� �������°��̹Ƿ� int�� �����ؼ� �ҷ���
		Board b = new Board();// �⺻�����ڴ� ���� 0���� �ʱ�ȭ �� 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			String sql = "SELECT * FROM board WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);// ����ǥ������ id�� �ƴ� ���� �̸� �������ټ����� int�⸸�ϸ�! 
			ResultSet rs = pstmt.executeQuery(); //executeQuery�� �׻� ������� �����Ѵ� 
			while(rs.next()) {//while�� ������ Ŀ����ġ��.. �ٲ۴ٰ��Ѵ�......false���� �����ؼ�..?
				b.id = rs.getInt("id");
				b.title = rs.getString("title");
				b.content = rs.getString("content");
				b.writtenDate = rs.getDate("writtenDate");
				b.updatedDate = rs.getDate("updatedDate");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return b;//�� �ϳ��� ��ȯ 
	}
	
	public static void insert(Board b) {//��Ʈ����ü�� �����ص������� �����������忡�� ���� ���ŷο��� 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO board(title, content, writtenDate, updatedDate) VALUES(?, ?, NOW(),NOW())";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.title);
			pstmt.setString(2, b.content);//����ǥ ������ŭ �ε����� ���߱� ��� �����������
			pstmt.execute();//������� �����Ƿ� executeQuery�� �ƴ� , ������� ��ȯ�ϴ°Ծƴ϶� ���ุ �Ѵ� 
			
		}catch(Exception e){
			e.printStackTrace();
		}//
	}
	
	public static void delete(int id) {//int id�� �ϴ���, board b�� �ϴ���.. ���� ��Ȳ������ ũ�� �������...
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
			System.out.println("=========== �Խ���  ===========");
			System.out.println("1. ���  2. �Է�  3. ���� ");
			System.out.print("> ");
			int choice = scan.nextInt();
			if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else if(choice == 1) {
				ArrayList<Board> list = selectAll(); //selectAll()�޼ҵ带 ��ü ���������ʰ� ������������ ��ü�� static
				Collections.reverse(list);
				System.out.println("========== ��� ==========");
				if(list.size()==0) {
					System.out.println("���� �����ϴ�.");
				}else {
					System.out.println("��ȣ\t����\t�ۼ���\t");
					for(Board b : list) { //boardŸ�� ��ü b�� ��� �����͸� �����ؿͼ� ���...�����̳� �Է��� �����ʰ� ��¸��Ҷ� for each ���
						System.out.println(b.id+"\t"+b.title+"\t"+b.writtenDate);
					}
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("�۹�ȣ ���� (0�� ����)");
					System.out.print("> ");
					int boardId = scan.nextInt();
					if(boardId != 0) {
						Board b = select(boardId); //select �޼ҵ� ȣ��... ����.. 
						if(b.id == 0) { //select���� ��ȯ�� ���� 0�϶� ! ���������ʴ� boardId���� �����޼ҵ忡 �־ while���� �������� id���� 0�̵� > �ڵ����� ����ó������
							System.out.println("�߸� �����ϼ̽��ϴ�.");
						}else {
							System.out.println("==========================");
							System.out.println("���� : " + b.title);
							System.out.println("==========================");
							System.out.println("�ۼ��� : "+ b.writtenDate);
							System.out.println("������ : "+ b.updatedDate);
							System.out.println("===========================");
							System.out.println("\t---����---\t");
							System.out.println(b.content);
							System.out.println("===========================");
							System.out.println("1. ����  2. ����   3. ��������");
							System.out.print("> ");
							choice = scan.nextInt();
							if (choice == 1) {
								scan.nextLine();
								Board update = new Board();// boardŸ���� ��ü�� ���� �����
								update.id = boardId;
								System.out.print("���� : ");
								update.title = scan.nextLine();
								System.out.print("���� : ");
								update.content = scan.nextLine();
								update(update);
								System.out.println(boardId + "�� ���� �����Ǿ����ϴ�.");
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
				System.out.print("���� : ");
				String title = scan.nextLine();
				System.out.println("=============================");
				System.out.print("���� : ");
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
