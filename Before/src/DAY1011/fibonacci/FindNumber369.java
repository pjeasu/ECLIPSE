package DAY1011.fibonacci;
public class FindNumber369 {
	
	//자릿수를 알수없는 임의의 숫자에서 숫자 하나하나를 다룰때 알아야 하는 코드. 한자리한자리의 숫자를 뽑아내서 처리
	// >> 제일 앞자리수를 알수없다. 그래서 제일 작은수부터 처리 
	
	
	public static int find369(int number) {
		int count = 0;
		while (number>0) { // 더이상 검사해야할 숫자가 없다는뜻
			int temp = number % 10; // 현재 1의 자리, 맨 마지막자리수의 숫자를 확인하는것. 
			if (temp == 3 || temp == 6 || temp == 9)
				count++;
			number /= 10;
			// 한자리씩 줄이는것
			// 숫자를 한자리씩 분리해 내기 위한 코드 
			//number가 0이 될때까지 10씩 나눠서 1의 자리 숫자를 추출하는것.
		}
		return count;
	}
	
	public static void main(String[] args) {	

        for (int i = 1; i <= 100; i++) {
        		int count = find369(i); //i의 value, 값만 전달, i는 프리미티브 타입이기 때문. 
        			System.out.format("%d : ", i);
        	
        			for(int j = 0; j < count; j++ ) {
        				System.out.print("짝");
        			}
        	System.out.println("");
   
        }
				
    }

		
}


