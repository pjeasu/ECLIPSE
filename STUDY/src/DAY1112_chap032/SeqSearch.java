package DAY1112_chap032;

import java.util.Scanner;

public class SeqSearch {

	static int seqSearch(int[] a, int n, int key) {
		int i = 0;

		while (true) {
			if (i == n)
				return -1; // 검색에 실패한 경우, 찾는 값이 없을 경우 = -1 반환
			if (a[i] == key)
				return i; // 검색에 성공한 경우 = 인덱스 반환
			i++;
		}
	}
	
	static int seqSearchFor(int[] a, int n, int key) {
		for (int i = 0; i < n; i++) {
			if(a[i] == key)
				return i; // 검색에 성공한 경우 = 인덱스 반환
		}
		return -1; // 검색에 실패한 경우, 찾는 값이 없을 경우 = -1 반환
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("요솟수 : ");
		int num = sc.nextInt();
		int[] x = new int[num]; // 입력받은 수를 요솟수로 지정

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}

		System.out.print(("검색할 값 : "));
		int key = sc.nextInt(); // 키 값 입력

		int idx = seqSearch(x, num, key); // 배열 x에서 키값이 key인 요소를 검색

		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");

	}

}
