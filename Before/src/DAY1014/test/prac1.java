package DAY1014.test;

import java.util.Scanner;

public class prac1 { 
	public static void main(String[] args) {
    //문자열을 입력받아 공백을 제외하고 숫자로만 이루어졌는지 확인하기 
    Scanner scanner = new Scanner(System.in);
    String temp;
    boolean isDigit = true;

   System.out.print("입력 : ");
    temp = scanner.next();
    temp.trim();
    
    for(int i = 0; i<temp.length(); i++) {
     char ch = temp.charAt(i);
    // System.out.format("%c %b\n", ch, Character.isDigit(ch));
     if (!Character.isDigit(ch));{ //글자중에 하나라도 digit가 아니면 뒤까지 확인할필요 없음 
        isDigit = false;
        break;
     }

    } 
  
}

}
