package DAY1104_chap021;
//������� Ű�� �Է¹޾� �ִ񰪱��ϱ�
import java.util.Scanner;

public class MaxOfArray { // �迭 ����� �ִ��� ���ϴ� �Լ� 
	static int maxOf(int[] a) {
		int max = a[0];
		for(int i = 1; i< a.length; i++)
			if(a[i] > max)
				max = a[i];
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ű�� �ִ� ���ϱ�");
		System.out.print("��� �� : "); //�迭�� ��ڼ� �Է¹���
		int num = sc.nextInt();
		
		int[] height = new int[num];
		
		for (int i = 0; i < num; i++) {
			System.out.print("height[" + i + "] : " );
			height[i] = sc.nextInt(); // ��ڼ����� Ű ������ �Է� 
		}
		
		System.out.println("�ִ��� " + maxOf(height) + "�Դϴ�.");
	}

}
