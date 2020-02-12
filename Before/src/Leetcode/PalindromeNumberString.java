package Leetcode;


public class PalindromeNumberString {
	 public boolean isPalindrome(int x) {
		 if(x < 0)
			 return false;
	     
		 
		 String number = String.valueOf(x); // ���ڸ� ���ڿ��� �ٲ� ���� ������ ��쵵 ����
		 // String number = String.format("%d",x);
		 // String number = "" + x;
		 // String number = new Integer(x).toString();
		 
		 int length = number.length(); //���ڿ��� ����
		 int lastIndex = length - 1; //�� ������ ������ ��ġ�� length-1�̱� ���� 
		 
		 for(int i = 0; i < length / 2; i++) { //���� ���ʰ� ���� ������ ���ڸ� �ϳ��ϳ� ��
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
// ���̰� 1, 3, 5, 7.. 2�� ����! 3�϶� 1�� 5�϶� 2�� 7�϶� 3�� Ȯ��

*/