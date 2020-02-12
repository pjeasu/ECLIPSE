package DAY1014.test;

//'0'~'9' ���ڷ� ������ ���ڿ�(����)�� ���������� �ٲٴ� �Լ� �ۼ� (for��), ����ó���ϱ�.
public class Solution5 {
	
	//case 1, str = null
	//case 2, str = "    "
	//case 3, str = "  12 3 "
	//case 4, str = "12x34 "
	public static Integer parseInt(String str) throws Exception{
		//static:�����Լ�,Ŭ�����޼ҵ� �� �������, Integer�� ��ȯŸ��, �޴� ���ڴ� String(��üŸ��, null�̵ɼ�����)
		  if (str == null)
			  throw new NullPointerException();
		  
		  str.trim();
		  if(str.isEmpty()) //���ڿ��� ���ٸ�.
			  throw new NumberFormatException("Invalid number format");//����ó��..

	        int number = 0; //null�� �ƴ϶�� �⺻������ 0���� �����ؼ� �������ٴ� ��. �ʱ�ȭ.
	        //str.trim(); //�յ� ������ ����� > �� ó���� �ǰ���  empty str�� �ɼ�����, ���ܶ��� ����å.
	        			

	        for (int i = 0; i < str.length(); i++) {
	            char ch = str.charAt(i);
	            if (!Character.isDigit(ch)) {//case 4�� �ɷ����� �Լ�, �������� �ƴ��� Ȯ����. ���ڹ��ڰ� �ƴϸ� exception.
	            	throw new NumberFormatException("Invalid number format");
	            } else {
	                number = number * 10 + (ch - '0');  
	            }
	        }
	        return number;
	}
	
	
	
}