package Leetcode;

 
public class ReverseInt {
	
	public int reverse(int x) {
		long sign = 1;
		long temp = x; //���� ���� �������� -1�� ���ϰ� �Ǹ� ����� �� integer������ �Ѿ ���ֵ�.
		
		if (temp < 0) {
			temp *= -1; //����� �������
			sign = -1; //-���� �����ϴ°�
		}
		
		long reverse = 0;
		while (temp > 0) {
			reverse = reverse * 10 + temp % 10; 
			temp /= 10;
			
		}
	
		/*
		>>> �Ʒ��� ���� �ǹ�
		if (reverse>Integer.MAX_VALUE) {
			reverse = 0;
		}
		return new Long(sign * reverse).intValue();
	*/
		
		return (reverse > Integer.MAX_VALUE ? 0 : (int)(sign * reverse));
	}

	
}
