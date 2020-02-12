package DAY1029_chap012;

public class Prac07 {
	public static void main(String[] args) {
		int n = 7;
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			sum += i;
			System.out.print(i);
			if (i < n) {
				System.out.print("+");

			}

		}
		System.out.println("=" + sum);
	}

}
