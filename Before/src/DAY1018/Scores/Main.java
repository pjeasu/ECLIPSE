
package DAY1018.Scores;
/*1018 실습
File name : scores.txt

이름, 국어, 수학, 영어, 총점, 평점

scanner 정수 입력받기
 50, 60, 70
q입력 받을때까지 입력받기...

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
			file = new PrintWriter("score.txt"); //csv파일로도 저장 가능
			file.println("이름, 국어, 수학, 영어, 총점, 평점");
			
			while(true) {				
				System.out.print("이름 : ");
				String name = scanner.next();
				
				System.out.print("국어 : ");
				int korean= scanner.nextInt();
				
				System.out.print("수학 : ");
				int math = scanner.nextInt();
				
				System.out.print("영어 : ");
				int english = scanner.nextInt();
				
				int sum = (korean+math+english);
				double avg = sum/3.0;
		
				file.format("%s, %d, %d, %d, %d, %.2f\n", name, korean, math, english, sum, avg);
								
				System.out.println("중단은 q, 계속 입력하려면 아무키나 눌러주세요.");
				System.out.print(">>");
				String key = scanner.next();
				
				// TO-DO : 분기하는 코드 작성
				if ("q".equalsIgnoreCase(key)) { 
					//상수와 변수를 비교(equals)할때는 변수를 기준으로 하는게 아니라 상수를 기준으로 해서 비교하는것이 좋다.
					//key.equalsIgnorCase("q") <<key값에 null이 들어온다면 nullpointexception이 일어날수있따.
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
					file.flush();// clear the buffer : 버퍼에 남은 데이터를 파일에 쓰고나서 클리어~~  
					file.close();
				}
				file.close();
				System.out.print("성적 입력이 완료되었습니다.");
			}finally{
			}
		}
	}
	
	
}
