package DAY1111_chap022;

import java.util.Scanner;

// Prac11
// ���� ��,��,���� �ʵ�� ���� Ŭ������ ����� (�����ڿ� �޼ҵ� ����)
public class YMD {
	int y; // ��
	int m; // �� (1~12)
	int d; // �� (1~31)

	YMD(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	static int[][] mdays = { // �� ���� �ϼ�
			{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // ���
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } // ����
	};

	static int isLeap(int year) { // ���� year���� �����ΰ�? (���� : 1/ ��� : 0)
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	
	
	
	YMD after(int n) { // n�� ���� ��¥�� ��ȯ
		YMD temp = new YMD(y, m, d);
		if (n < 0)
			return (before(-n));

		temp.d += n;
		// temp.d = temp.d + n

		while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
			//mdays[0�� ���, 1�� ����][������]
			temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
			if (++temp.m > 12) {
				temp.y++;
				temp.m = 1;
			}
		}

		return temp;
	}

	YMD before(int n) { // n�� ���� ��¥�� ��ȯ
		YMD temp = new YMD(y, m, d);
		if (n < 0)
			return (after(-n));

		temp.d -= n;

		while (temp.d < 1) {
			if (--temp.m < 1) {
				temp.y--;
				temp.m = 12;
			}
			temp.d += mdays[isLeap(temp.y)][temp.m - 1];
		}
		return temp;

	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("��¥�� �Է��ϼ���.");
		System.out.print("�� : ");
		int y = sc.nextInt();
		System.out.print("�� : ");
		int m = sc.nextInt();
		System.out.print("�� : ");
		int d = sc.nextInt();
		
		YMD date = new YMD(y,m,d);
		
		System.out.print("���� ��/���� ��¥�� ���ұ�� ? : ");
		int n = sc.nextInt();
		
		YMD d1 = date.after(n);
		System.out.printf("%d�� ���� ��¥�� %d�� %d�� %d�� �Դϴ�. \n", n, d1.y, d1.m, d1.d);
		
		YMD d2 = date.before(n);
		System.out.printf("%d�� ���� ��¥�� %d�� %d�� %d�� �Դϴ�. \n", n, d2.y, d2.m, d2.d);
		
		
	}

}
