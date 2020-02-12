package Leetcode;


public class PalindromeNumberInt {
	 public boolean isPalindrome(int x) {
		 
		 //숫자열을 뒤집으면 Integer의 범위를 넘어갈때가 있으므로 Long형으로 변환
		 
		 Long reverse = 0L;
		 int temp = x;
		 while (temp > 0) { 
			 reverse = reverse * 10 + temp % 10;
			 temp /= 10;
		 }
		 return reverse == (long) x;
		 
	 }
	 
}
