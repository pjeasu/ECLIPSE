package DAY1011.fibonacci;
public class FibonacciSwitch {
	

	  public static void main(String[] args) {
        for (int i = 0; i<40; i++)
	        System.out.format("fibonacci(%d) = %d\n", i, fibonacci(i));
	    }


	    //��� ȣ�� : � �Լ��� �ڱ��ڽ��� �ٽ� ȣ���ϴ� �Լ�
	    //��� ȣ�� �Լ� �ۼ��� ������ �� : �ݵ�� ��Ȯ�� ���������� �־����(������� ���ѷ��� ������ �����鼭���α׷�����)
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


