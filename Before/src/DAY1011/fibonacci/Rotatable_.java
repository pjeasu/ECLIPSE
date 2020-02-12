package DAY1011.fibonacci;
public class Rotatable_ {
	
	public static void main(String [] args) {
		System.out.format("%d is rotatable : %b\n", 123, isRotatable(123));
		System.out.format("%d is rotatable : %b\n", 609, isRotatable(609));
		System.out.format("%d is rotatable : %b\n", 808, isRotatable(808));
	}
	
	
	public static int rotateDigit(int digit) { //180도 뒤집어주는 함수
		switch(digit) {
		case 0 : 
		case 1 :
		case 8 :
			return digit;
			
		case 6 :
			return 9;
			
		case 9 :
			return 6;
			
		default :
			return -1;
		}	
	}




	public static boolean isRotatable(int number) {
		int num = number;
		int sum = 0;
		while(number>0) {
			//위의 rotateDigit는 이위치에 들어와도 되지만 추출해서 바깥으로 빼냄. >>가독성을 높여줌
			int temp = rotateDigit(number%10);
			if(temp == -1)
				return false;
			
			sum = sum * 10 + temp; //ex 123 > 321 자릿수 뒤집어주기 
			number /= 10;
			
		}
		return num == sum;
	}
}
