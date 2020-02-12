package DAY1011.fibonacci;//import java.util.Scanner;
public class FindNumber3 {
	
	    public static void main(String[] args) {
	       /*
	        String str = "13";
	        System.out.format("indexOf = %d", str.indexOf('3'));
	    //13이 아닌 12를 넣으면 3이 없으므로 indexOf = -1이 나옴 없다는 뜻..
	        */


	        for (Integer i = 1; i <= 100; i++) {
	            if(i.toString().indexOf('3') < 0 )
	                continue;

	                System.out.format("%d\n",i);

	            // 3이라는 문자열이 없다면 코드를 스킵하라는 뜻
	            // int로 하면 안되고, Integer로 하면 됨 int를 객체화
	            // toString()이라는 함수는 원래 오브젝트에 들어가있다. > 문자를 바꿔주는 기능을 함.

	            /* 위와 같은 의미의 코드..
	             * if(i.toString().indexOf('3')>= 0) {
	             * System.out.format("%d\n",i);
	             * }
	             */

	        }
	    }




}
