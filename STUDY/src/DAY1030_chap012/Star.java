package DAY1030_chap012;
import java.util.Scanner;

public class Star {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String pattern = "*"; // 상수형 문자열

//        String input = scanner.next(); //스캐너에서 예외처리 하는법 : input > 'aaaa' length는 4, 이 길이 만큼 검색(for문 돌리기)
//        input.charAt(0);

		System.out.print("숫자 입력 : ");
		int n = scanner.nextInt();

        for(int i = 1; i<=n; i++) {
            System.out.format(String.format("%%%ds\n", n), pattern);
            pattern += "*"; 
        }
		
	
		 
		
	

	}
}
