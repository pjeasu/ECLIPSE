package DAY1107_chap021;

import java.util.Scanner;

//배열의 앞쪽에 아랫자리가 아니라 윗자리를 넣어두는 메소드를 작성
public class Prac06 {
	static int cardConv(int x, int r, char[] d) {
		int digit = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digit++] = dchar.charAt(x % r);
			x /= r;

		} while (x != 0);

		for (int i = 0; i < digit / 2; i++) { // digit에 d.length를 넣으면
			swap(d, i, digit - i - 1);
		}
		return digit;
	}

	static void swap(char[] d, int idx1, int idx2) {
		char t = d[idx1];
		d[idx1] = d[idx2];
		d[idx2] = t;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no; // 변환하는 정수
		int cd; // 기수
		int dno; // 변환 후의 자릿수
		char[] cno = new char[32]; // 변환 후 각 자리의 숫자를 넣어두는 문자의 배열

		System.out.println("10진수를 기수 변환합니다.");
		do {
			System.out.print("변환하는 음이 아닌 정수 : ");
			no = sc.nextInt();
		} while (no < 0); // 입력된 값이 0이하의 음수이면 다시 입력하도록

		do {
			System.out.print("어떤 진수로 변환 할까요? (2~36) : ");
			cd = sc.nextInt();
		} while (cd < 2 || cd > 36); // 입력된 값이 2~36에서 벗어난 값이면 다시 입력하도록
		dno = cardConv(no, cd, cno);

		System.out.print(cd + "진수로는 ");
		for (int i = 0; i <= dno; i++) {
			System.out.print(cno[i]);
		}

		System.out.println("입니다.");
	}
}
