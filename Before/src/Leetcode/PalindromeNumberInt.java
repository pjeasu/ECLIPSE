package Leetcode;


public class PalindromeNumberInt {
	 public boolean isPalindrome(int x) {
		 
		 //���ڿ��� �������� Integer�� ������ �Ѿ���� �����Ƿ� Long������ ��ȯ
		 
		 Long reverse = 0L;
		 int temp = x;
		 while (temp > 0) { 
			 reverse = reverse * 10 + temp % 10;
			 temp /= 10;
		 }
		 return reverse == (long) x;
		 
	 }
	 
}
