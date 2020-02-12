package DAY1104_chap021;

import java.util.Random;
import java.util.Scanner;

public class Prac01 {
	static int maxOf(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}
	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);

		System.out.println("키의 최댓값");
		int num = rand.nextInt(10);
		System.out.println("사람 수 :" + num);

		int[] height = new int[num];

		System.out.println("키 값은 아래와 같음");
		for (int i = 0; i < num; i++) {
			height[i] = 100 + rand.nextInt(90); //요소의 값을 난수로 결정!! nextInt(int num):0 부터 num-1까지 범위에 있는 난수를 반환
			System.out.println("height[" + i + "] : " + height[i]);
		}

		System.out.println("최댓값은 " + maxOf(height) + "입니다. ");
	}

}
