package DAY1104_chap021;
//사람수와 키를 입력받아 최댓값구하기
import java.util.Scanner;

public class MaxOfArray { // 배열 요소의 최댓값을 구하는 함수 
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1; i< a.length; i++)
			if(a[i] > max)
				max = a[i];
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키의 최댓값 구하기");
		System.out.print("사람 수 : "); //배열의 요솟수 입력받음
		int num = sc.nextInt();
		
		int[] height = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "] : " );
			height[i] = sc.nextInt(); // 요솟수마다 키 데이터 입력 
		}
		
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
	}

}
