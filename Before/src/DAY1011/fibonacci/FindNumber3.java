package DAY1011.fibonacci;//import java.util.Scanner;
public class FindNumber3 {
	
	    public static void main(String[] args) {
	       /*
	        String str = "13";
	        System.out.format("indexOf = %d", str.indexOf('3'));
	    //13�� �ƴ� 12�� ������ 3�� �����Ƿ� indexOf = -1�� ���� ���ٴ� ��..
	        */


	        for (Integer i = 1; i <= 100; i++) {
	            if(i.toString().indexOf('3') < 0 )
	                continue;

	                System.out.format("%d\n",i);

	            // 3�̶�� ���ڿ��� ���ٸ� �ڵ带 ��ŵ�϶�� ��
	            // int�� �ϸ� �ȵǰ�, Integer�� �ϸ� �� int�� ��üȭ
	            // toString()�̶�� �Լ��� ���� ������Ʈ�� ���ִ�. > ���ڸ� �ٲ��ִ� ����� ��.

	            /* ���� ���� �ǹ��� �ڵ�..
	             * if(i.toString().indexOf('3')>= 0) {
	             * System.out.format("%d\n",i);
	             * }
	             */

	        }
	    }




}
