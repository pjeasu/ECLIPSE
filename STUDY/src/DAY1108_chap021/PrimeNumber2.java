package DAY1108_chap021;

public class PrimeNumber2 {
	public static void main(String[] args) {
		int counter = 0; // �������� Ƚ��
		int ptr = 0; // ã�� �Ҽ��� ����
		int[] prime = new int[500]; // �Ҽ��� �����ϴ� �迭

		prime[ptr++] = 2; // 2�� �Ҽ��̹Ƿ� prime[0]�� ����, ptr�� ���� 1

		for (int n = 3; n <= 1000; n += 2) { // ¦���� �ϴ� ����..3�� 2�� ���ذ��鼭 Ȧ���� ���������
			int i;
			for (i = 1; i < ptr; i++) {
				counter++;
				if (n % prime[i] == 0) // �̹� ã�� �Ҽ��� ������, ����������� �Ҽ��� �ƴ�
					break;	//�� ���� ���������ٴ°��� ��� �Ҽ��� ������ ���������ʴ´ٴ°�
							//�Ҽ������� �ش��ϴ� �ε�����ȣ�� ��ü ���� �� i�� �״�� ����
			}
			if (ptr == i) // ���������� ���������������
				prime[ptr++] = n; //�Ҽ��迭�� ����
		}
		for (int i = 0; i < ptr; i++) { //�Ҽ����
			System.out.println(prime[i]);
		}
		System.out.println("�������� ������ Ƚ�� : " + counter);
	}
}
