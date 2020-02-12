package DAY1106_chap021;

import java.util.Random;
import java.util.Scanner;

public class Prac05 {
	static void rcopy(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}

		for (int i = 0; i < b.length / 2; i++) {
			swap(b, i, b.length - i - 1);
		}
	}

	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int[] a = new int[5];
		for (int i = 0; i < a.length; i++) {
			a[i] = rand.nextInt(50);
		}
		System.out.print("배열 a : ");
		for (int num : a) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("배열 b : ");
		
		int [] b = new int[5];
		rcopy(a,b);
		
		for (int num : b) {
			System.out.print(num + " ");
		}
	}

}
