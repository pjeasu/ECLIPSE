package DAY1014.test;
import java.util.Scanner;
// ���ڿ� ���ڸ� �Է¹޾� ���ڷ� �ٲٴ� ����
// ���ڰ� �ƴ� ���ڴ� �ɷ�����
public class StringToNumber {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String temp;

	        do {
	            System.out.print("Input number : ");
	            temp = scanner.next();
	            if (temp.equalsIgnoreCase("q")) { //��ҹ��� ������� q���� Ȯ�� 
	               System.out.println("bye");
	            	break;// bye ����� 
	            } else if (!isDigit(temp)) // ���ڰ� �ƴҰ��
	                continue; // ���� ���������� �ٽ� �Է�â����.
	            System.out.format("Input is %d\n", parseInt(temp)); //���ڶ�� ���
	        } while (true);
	    }

	    
	    public static boolean isDigit(String str) {
	        if (str == null) 
	            return false;

	        boolean isDigit = true;

	        str.trim();//�յ� ��������
	        for (int i = 0; i < str.length(); i++) { //�Էµ� ���ڿ� ���̸�ŭ ���� ����
	            char ch = str.charAt(i); //ù��° �ڸ��� ����~���ڿ��� ���̹�° ���� 1,2,3... �� �ϳ��� ������
	            if (!Character.isDigit(ch)) {//�� ���ڰ� ���ڰ� �ƴ϶�� falseó��
	                isDigit = false;
	                break;
	            }
	        }
	        return isDigit; //false�� �ƴѰ� ����
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
	                number = number * 10 + (ch - '0'); //���ڿ��� ���ڸ� int ���ڷ� �ٲٴ� ��
	            }
	        }
	        return number;
	    }
	}

