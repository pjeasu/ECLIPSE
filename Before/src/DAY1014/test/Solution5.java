package DAY1014.test;

//'0'~'9' 문자로 구성된 숫자열(정수)를 정수형으로 바꾸는 함수 작성 (for문), 예외처리하기.
public class Solution5 {
	
	//case 1, str = null
	//case 2, str = "    "
	//case 3, str = "  12 3 "
	//case 4, str = "12x34 "
	public static Integer parseInt(String str) throws Exception{
		//static:정적함수,클래스메소드 를 만들어줌, Integer는 반환타입, 받는 인자는 String(객체타입, null이될수있음)
		  if (str == null)
			  throw new NullPointerException();
		  
		  str.trim();
		  if(str.isEmpty()) //문자열이 없다면.
			  throw new NumberFormatException("Invalid number format");//예외처리..

	        int number = 0; //null이 아니라면 기본적으로 0으로 세팅해서 내보낸다는 말. 초기화.
	        //str.trim(); //앞뒤 공백이 사라짐 > 이 처리가 되고나서  empty str이 될수있음, 위단락이 개선책.
	        			

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!Character.isDigit(ch)) {//case 4가 걸러지는 함수, 숫자인지 아닌지 확인함. 숫자문자가 아니면 exception.
	            	throw new NumberFormatException("Invalid number format");
	            } else {
	                number = number * 10 + (ch - '0');  
	            }
	        }
	        return number;
	}
	
	
	
}