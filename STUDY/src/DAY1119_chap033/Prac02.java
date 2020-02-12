package DAY1119_chap033;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Prac02 {
	static int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
//		String str = "*";

		a[n] = key; // 보초를 추가
		for (i = 0; i < a.length; i++) {
			System.out.printf("%4s", "|");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d%s", i, "|");
			for (int j = 0; j < a.length - 1; j++) {
				System.out.printf("%4d", a[j]);
			}
			System.out.println();
			if (a[i] == key) {
				break;
			}
		}

		return i == n ? -1 : i; // i가 n이면 찾은값이 보초임으로 검색 실패임을 나타내는 -1 반환
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();

		System.out.print("   |");
		for (int i = 0; i < x.length - 1; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		System.out.print("---+");
		for (int i = 0; i < x.length; i++) {
			System.out.print("----");
		}
		System.out.println();
		int idx = seqSearchSen(x, num, ky);

		System.out.println();
		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");

	}

}
