package DAY1014.test;

import java.util.Scanner;

public class Soulution51 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		String temp;
		
		System.out.print("숫자입력 : ");
		temp = scanner.next();
		
		System.out.println(parseInt(temp));
		
	}


	
	public static Integer parseInt(String str) throws Exception{
		  if (str == null)
			  throw new NullPointerException();
		  
		  str.trim();
		  if(str.isEmpty()) 
			  throw new NumberFormatException("유효하지 않은 값");

	        int number = 0; 
	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!Character.isDigit(ch)) {
	            	throw new NumberFormatException("유효하지 않은 값");
	            } else {
	                number = number * 10 + (ch - '0');  
	            }
	        }
	        return number;
	}
	
	
}
