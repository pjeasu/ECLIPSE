package DAY1106_chap021;

import java.util.Random;
import java.util.Scanner;

public class ArrayEqual {

	static boolean equals(int[] a, int[] b) { // 두 배열의 모든 요소가 같은 값을 가지고 있는가 !!! 
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("배열 a의 요솟수 : "	);
		int na = sc.nextInt();
		
		int[] a = new int[na];
		
		for (int i = 0; i < na; i++) {
			System.out.print("a[" + i + "] : ");
			a[i] = sc.nextInt();
//			a[i] = rand.nextInt(50);
		}
		
		System.out.print("배열 b의 요솟 수 : ");
		int nb = sc.nextInt();
		
		int[] b = new int[nb];
		
		for (int i = 0; i < nb; i++) {
			System.out.print("b[" + i + "] : ");
			b[i] = sc.nextInt();
//			b[i] = rand.nextInt(50);
		}
		
		System.out.println("배열 a와 배열 b의 모든 요소 값은 " + (equals(a,b) ? "같습니다" : "다릅니다."));
		
		
	}

}
