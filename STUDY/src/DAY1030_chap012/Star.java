package DAY1030_chap012;
import java.util.Scanner;

public class Star {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		String pattern = "*"; // ����� ���ڿ�

//        String input = scanner.next(); //��ĳ�ʿ��� ����ó�� �ϴ¹� : input > 'aaaa' length�� 4, �� ���� ��ŭ �˻�(for�� ������)
//        input.charAt(0);

		System.out.print("���� �Է� : ");
		int n = scanner.nextInt();

        for(int i = 1; i<=n; i++) {
            System.out.format(String.format("%%%ds\n", n), pattern);
            pattern += "*"; 
        }
		
	
		 
		
	

	}
}
