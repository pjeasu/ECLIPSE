package DAY1108_chap021;

public class PrimeNumber3 {
	public static void main(String[] args) {
		int counter = 0;// 곱셈과 나눗셈의 횟수
		int ptr = 0; // 찾은 소수의 개수
		int[] prime = new int[500]; // 소수를 저장하는 배열

		prime[ptr++] = 2; // 2와 3은 소수
		prime[ptr++] = 3;

		for (int n = 5; n <= 1000; n += 2) { // 홀수만을 대상으로
			boolean flag = false;
			for (int i = 1; prime[i] * prime[i] <= n; i++) {
				counter += 2; //for문의 곱셈과 if문의 나눗셈을 합쳐 두번 연산하므로 2개씩 증가 
				if (n % prime[i] == 0) {
					flag = true;		// 나누어 떨어지면 소수가 아님 for문 나가기
					break;
				}
			}
			if (!flag) {			// 마지막까지 나누어 떨어지지 않은경우 
				prime[ptr++] = n;	// 소수라고 배열에 저장 
				counter++;
			}

		}
		for (int i = 0; i < ptr; i++) {	//찾은 소수 출력
			System.out.println(prime[i]);
		}

		System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
	}
}
