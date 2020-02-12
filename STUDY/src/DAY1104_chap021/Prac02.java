package DAY1104_chap021;

import java.util.Scanner;

public class Prac02 {
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	static void reverse(int[] a) {

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < a.length / 2; i++) {
			System.out.println("a[" + i + "]의 값과 a[" + (a.length - i - 1) + "]의 값을 교환합니다.");
			swap(a, i, a.length - i - 1);
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + " ");
			}
			System.out.println();
		}
		System.out.println("역순 정렬을 마쳤습니다.");

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = sc.nextInt();

		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();

		}
		reverse(x);

//		System.out.println("요소를 역순으로 정렬했습니다.");
//		for (int i = 0; i < num; i++) {
//			System.out.println("x[" + i + "] = " + x[i]);
//		}

	}

}
