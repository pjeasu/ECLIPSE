package Leetcode;


public class PalindromeNumberString {
	 public boolean isPalindrome(int x) {
		 if(x < 0)
			 return false;
	     
		 
		 String number = String.valueOf(x); // 숫자를 문자열로 바꿈 밑의 세가지 경우도 가능
		 // String number = String.format("%d",x);
		 // String number = "" + x;
		 // String number = new Integer(x).toString();
		 
		 int length = number.length(); //문자열의 길이
		 int lastIndex = length - 1; //맨 마지막 문자의 위치는 length-1이기 때문 
		 
		 for(int i = 0; i < length / 2; i++) { //가장 왼쪽과 가장 오른쪽 문자를 하나하나 비교
			 if (number.charAt(i) != number.charAt(lastIndex - i))
				 return false;
		 }
		 return true;
		 	    
	}

	 /*
	 public static void main(String[] args) {
		 PalindromeNumberString result = new PalindromeNumberString();
		 result.isPalindrome(232);
		 
		 System.out.println(result);
	 }
	 */
	 
	 
}




/* 

int length = s.length();
// 길이가 1, 3, 5, 7.. 2로 나눔! 3일때 1번 5일때 2번 7일때 3번 확인

*/