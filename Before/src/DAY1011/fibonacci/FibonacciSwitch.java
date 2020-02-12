package DAY1011.fibonacci;
public class FibonacciSwitch {
	

	  public static void main(String[] args) {
        for (int i = 0; i<40; i++)
	        System.out.format("fibonacci(%d) = %d\n", i, fibonacci(i));
	    }


	    //재귀 호출 : 어떤 함수가 자기자신을 다시 호출하는 함수
	    //재귀 호출 함수 작성시 주의할 점 : 반드시 정확한 종료조건이 있어야함(없을경우 무한루프 스택이 깨지면서프로그램종료)
	    public static int fibonacci(int n) throws IndexOutOfBoundsException {

	   

	    
	     switch (n) {

	        case 0 :
	        case 1 :
	            return 1;
	        default:
	            return fibonacci(n-2) + fibonacci(n-1);
	     }
	    



	    }


	}


