package DAY1014.test;
import java.util.Scanner;
// 문자열 숫자를 입력받아 숫자로 바꾸는 예제
// 숫자가 아닌 글자는 걸러내기
public class StringToNumber {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String temp;

	        do {
	            System.out.print("Input number : ");
	            temp = scanner.next();
	            if (temp.equalsIgnoreCase("q")) { //대소문자 상관없이 q인지 확인 
	               System.out.println("bye");
	            	break;// bye 출력후 
	            } else if (!isDigit(temp)) // 숫자가 아닐경우
	                continue; // 블럭을 빠져나가서 다시 입력창으로.
	            System.out.format("Input is %d\n", parseInt(temp)); //숫자라면 출력
	        } while (true);
	    }

	    
	    public static boolean isDigit(String str) {
	        if (str == null) 
	            return false;

	        boolean isDigit = true;

	        str.trim();//앞뒤 공백제거
	        for (int i = 0; i < str.length(); i++) { //입력된 문자열 길이만큼 루프 돌기
	            char ch = str.charAt(i); //첫번째 자릿수 글자~문자열의 길이번째 숫자 1,2,3... 를 하나씩 가져옴
	            if (!Character.isDigit(ch)) {//그 문자가 숫자가 아니라면 false처리
	                isDigit = false;
	                break;
	            }
	        }
	        return isDigit; //false가 아닌건 숫자
	    }

	    public static Integer parseInt(String str) {
	        if (str == null)
	            return null;

	        int number = 0;
	        str.trim();

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!Character.isDigit(ch)) {
	                return null;
	            } else {
	                number = number * 10 + (ch - '0'); //문자열인 숫자를 int 숫자로 바꾸는 식
	            }
	        }
	        return number;
	    }
	}

