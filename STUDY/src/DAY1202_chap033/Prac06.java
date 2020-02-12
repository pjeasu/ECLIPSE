package DAY1202_chap033;

import java.util.Arrays;
import java.util.Scanner;

public class Prac06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num];

		System.out.println("오름차순으로 입력하세요.");

		System.out.print("x[0]: ");
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "] :");
				x[i] = sc.nextInt();

			} while (x[i] < x[i - 1]); // 오름차순으로 입력할때까지 반복..
		}
		System.out.print("검색할 값 : ");
		int ky = sc.nextInt();

		int idx = Arrays.binarySearch(x, ky);
		// 배열과 찾을 요소

		int point = -idx - 1;
		if (idx < 0)
			System.out.println("그 값의 요소가 없습니다.\n삽입 포인트 : " + point);
			//삽입포인트는 검색하기위해 지정한 key보다 큰 요소중 첫번째 요소의 인덱스임
		else
			System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");

	}
}
