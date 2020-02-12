package DAY1108_chap021;

public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // 나눗셈의 횟수
		int ptr = 0; // 찾은 소수의 개수
		int[] prime = new int[500]; // 소수를 저장하는 배열

		prime[ptr++] = 2; // 2는 소수이므로 prime[0]에 저장, ptr의 값은 1

		for (int n = 3; n <= 1000; n += 2) { // 짝수는 일단 배제..3에 2를 더해가면서 홀수만 대상으로함
			int i;
			for (i = 1; i < ptr; i++) {
				counter++;
				if (n % prime[i] == 0) // 이미 찾은 소수로 나눠봄, 나누어떨어지면 소수가 아님
					break;	//이 블럭을 빠져나갔다는것은 모든 소수와 나누어 떨어지지않는다는것
							//소수에각각 해당하는 인덱스번호를 전체 돌고 그 i가 그대로 나옴
			}
			if (ptr == i) // 마지막까지 나누어떨어지지않음
				prime[ptr++] = n; //소수배열에 저장
		}
		for (int i = 0; i < ptr; i++) { //소수출력
			System.out.println(prime[i]);
		}
		System.out.println("나눗셈을 수행한 횟수 : " + counter);
	}
}
