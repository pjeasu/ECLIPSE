package DAY1106_chap021;

import java.util.Random;
import java.util.Scanner;

public class Prac03 {
	
	static int sumOf(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] a = new int[num];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(10);
			System.out.println("a[" + i + "] : " + a[i]);
		}
		
		int result = sumOf(a);
		System.out.println("배열의 요소의 합 : " + result);
		
	}

}
