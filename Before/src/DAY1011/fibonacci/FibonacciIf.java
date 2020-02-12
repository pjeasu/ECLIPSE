package DAY1011.fibonacci;

	
public class FibonacciIf{

	    public static void main(String[] args) {
	        for (int i = 0; i<40; i++)
	        System.out.format("fibonacci(%d) = %d\n", i, fibonacci(i));
	    }


	    //��� ȣ�� : � �Լ��� �ڱ��ڽ��� �ٽ� ȣ���ϴ� �Լ�
	    //��� ȣ�� �Լ� �ۼ��� ������ �� : �ݵ�� ��Ȯ�� ���������� �־����(������� ���ѷ��� ������ �����鼭���α׷�����)
	    public static int fibonacci(int n) throws IndexOutOfBoundsException {

	        if(n < 0) //������ ��Ƽ� ����ó���� �� �������
	            throw new IndexOutOfBoundsException(String.format("Out of bounds : %d", n));
	            //���⼭ throw�� �Ǹ� ���� ������ �ȵǹǷ� ���� ���� �ʿ� ����

	        if( n==0 || n==1)
	            return 1;

	        //else <�ٿ��� �Ⱥٿ�����
	            return fibonacci(n-2) + fibonacci(n-1);



	    }

//Memorization ���

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

