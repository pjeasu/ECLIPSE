
package DAY1018.Scores;
/*1018 �ǽ�
File name : scores.txt

�̸�, ����, ����, ����, ����, ����

scanner ���� �Է¹ޱ�
 50, 60, 70
q�Է� ���������� �Է¹ޱ�...

*/
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		writeScores();
	}
	public static void writeScores() {
		Scanner scanner = new Scanner(System.in);
		PrintWriter file = null;
		
		try {
			file = new PrintWriter("score.txt"); //csv���Ϸε� ���� ����
			file.println("�̸�, ����, ����, ����, ����, ����");
			
			while(true) {				
				System.out.print("�̸� : ");
				String name = scanner.next();
				
				System.out.print("���� : ");
				int korean= scanner.nextInt();
				
				System.out.print("���� : ");
				int math = scanner.nextInt();
				
				System.out.print("���� : ");
				int english = scanner.nextInt();
				
				int sum = (korean+math+english);
				double avg = sum/3.0;
		
				file.format("%s, %d, %d, %d, %d, %.2f\n", name, korean, math, english, sum, avg);
								
				System.out.println("�ߴ��� q, ��� �Է��Ϸ��� �ƹ�Ű�� �����ּ���.");
				System.out.print(">>");
				String key = scanner.next();
				
				// TO-DO : �б��ϴ� �ڵ� �ۼ�
				if ("q".equalsIgnoreCase(key)) { 
					//����� ������ ��(equals)�Ҷ��� ������ �������� �ϴ°� �ƴ϶� ����� �������� �ؼ� ���ϴ°��� ����.
					//key.equalsIgnorCase("q") <<key���� null�� ���´ٸ� nullpointexception�� �Ͼ���ֵ�.
					break;
				}//else {
					//continue;
				//}
				
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
			scanner.close();
			try {
				if (file != null) {
					file.flush();// clear the buffer : ���ۿ� ���� �����͸� ���Ͽ� ������ Ŭ����~~  
					file.close();
				}
				file.close();
				System.out.print("���� �Է��� �Ϸ�Ǿ����ϴ�.");
			}finally{
			}
		}
	}
	
	
}
