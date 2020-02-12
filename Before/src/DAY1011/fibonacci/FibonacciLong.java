package DAY1011.fibonacci;
public class FibonacciLong {
	
	  public static void main(String[] args) {
	        for (int i = 0; i<80; i++)
		        System.out.format("fibonacci2(%d) = %d\n", i, fibonacci2(i));
		    }

	
	
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
	    
	    /*함수를 만드는 이유중 하나  재사용하거나 반복적인 값이 있을때..
	   public static boolean isAllowed(int height, int age) {
		   return height >= 170 || age >= 20;
	   }
	   */
	   
	   
}
