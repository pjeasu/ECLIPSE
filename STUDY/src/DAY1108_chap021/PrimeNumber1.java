package DAY1108_chap021;

public class PrimeNumber1 {
	public static void main(String[] args) {
		int counter = 0; // 나ㄴ

		for (int n = 2; n < 1000; n++) {
			int i;
			for (i = 2; i < n; i++) {
				counter++;
				if (n % i == 0) // 나누어 떨어지면 소수가 아님
					break; // 반복하지않고 블럭 나가기
			}
			if (n == i) // 마지막까지 나누어 떨어지지 않은경우
				System.out.println(n); // 소수 출력
		}

		System.out.println("나눗셈을 수행한 횟수: " + counter);
	}
}
