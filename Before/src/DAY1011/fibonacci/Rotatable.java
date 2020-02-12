package DAY1011.fibonacci;
public class Rotatable {

	public static int rotate(int number) {
		int count = 0;
		while (number>0) {
		
		int sum = 0;
		int temp = number % 10; 
		switch (temp) {
			case 0 : 
				return 0;
				
			case 1 :
				return 1;
				
			case 6 :
				return 9;
				
			case 8 :
				return 8;
				
			case 9 :
				return 6;
				
			default :
				return -1;
		
		}
//			count++;
//		number /= 10;
		
	
	}
	return count;
	}
	
	
	public static void main(String[] args) {	

        for (int i = 1; i <= 100; i++) {
        		int count = rotate(i); 
        			System.out.format("%d : ", i);
        	
        			for(int j = 0; j < count; j++ ) {
        				System.out.print("¦");
        			}
        	System.out.println("");
   
        }
				
    }

	
	
	
}