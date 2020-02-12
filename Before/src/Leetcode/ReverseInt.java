package Leetcode;

 
public class ReverseInt {
	
	public int reverse(int x) {
		long sign = 1;
		long temp = x; //제일 작은 음수값에 -1을 곱하게 되면 양수가 됨 integer범위를 넘어갈 수있따.
		
		if (temp < 0) {
			temp *= -1; //양수를 만들어줌
			sign = -1; //-값을 저장하는것
		}
		
		long reverse = 0;
		while (temp > 0) {
			reverse = reverse * 10 + temp % 10; 
			temp /= 10;
			
		}
	
		/*
		>>> 아래와 같은 의미
		if (reverse>Integer.MAX_VALUE) {
			reverse = 0;
		}
		return new Long(sign * reverse).intValue();
	*/
		
		return (reverse > Integer.MAX_VALUE ? 0 : (int)(sign * reverse));
	}

	
}
