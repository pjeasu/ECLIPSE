package DAY1011.fibonacci;

	
public class FibonacciIf{

	    public static void main(String[] args) {
	        for (int i = 0; i<40; i++)
	        System.out.format("fibonacci(%d) = %d\n", i, fibonacci(i));
	    }


	    //재귀 호출 : 어떤 함수가 자기자신을 다시 호출하는 함수
	    //재귀 호출 함수 작성시 주의할 점 : 반드시 정확한 종료조건이 있어야함(없을경우 무한루프 스택이 깨지면서프로그램종료)
	    public static int fibonacci(int n) throws IndexOutOfBoundsException {

	        if(n < 0) //범위를 잡아서 예외처리를 꼭 해줘야함
	            throw new IndexOutOfBoundsException(String.format("Out of bounds : %d", n));
	            //여기서 throw가 되면 밑은 진행이 안되므로 리턴 붙일 필요 없음

	        if( n==0 || n==1)
	            return 1;

	        //else <붙여도 안붙여도됨
	            return fibonacci(n-2) + fibonacci(n-1);



	    }

//Memorization 기법

	    public static long fibonacci2(int n) {
	    	if(n <0 || n >80 )
	    		throw new IndexOutOfBoundsException(String.format("Out of bounds : %d",n));
	    	
	    	if(n == 0 || n==1)
	    		return 1L;
	    	
	    	long[] array = new long[n];
	    	array[0] = 1;
	    	array[1] = 1;
	    	for (int i = 2; i<n; i++) {
	    		array[i] = array[i -2] + array[i-1] ;
	    	}
	    	return array[n-2] + array[n-1];
	    }
	    
	    
	    
	    
	}

