package DAY1014.test;

import java.util.Scanner;

public class prac1 { 
	public static void main(String[] args) {
    //���ڿ��� �Է¹޾� ������ �����ϰ� ���ڷθ� �̷�������� Ȯ���ϱ� 
    Scanner scanner = new Scanner(System.in);
    String temp;
    boolean isDigit = true;

   System.out.print("�Է� : ");
    temp = scanner.next();
    temp.trim();
    
    for(int i = 0; i<temp.length(); i++) {
     char ch = temp.charAt(i);
    // System.out.format("%c %b\n", ch, Character.isDigit(ch));
     if (!Character.isDigit(ch));{ //�����߿� �ϳ��� digit�� �ƴϸ� �ڱ��� Ȯ�����ʿ� ���� 
        isDigit = false;
        break;
     }

    } 
  
}

}
