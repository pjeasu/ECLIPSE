package DAY1106_chap021;

import java.util.Random;
import java.util.Scanner;

public class Prac04 {
	static void copy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("¿ä¼Ú¼ö : ");
		int num = sc.nextInt();
		int[] a = new int[num];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(50);
			System.out.println("a[" + i + "] : " + a[i]);
		}
		
		System.out.println();
		
		
		int[] b = new int[num];
		copy(a,b);
		for (int i = 0; i < b.length; i++) {
			System.out.println("b[" + i + "] : " + b[i]);
		}
//		for(int e : b) {
//			System.out.println("b[" + i + "] : " + e);
//		}

	}
}