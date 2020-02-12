package DAY1011.fibonacci;
public class FindNumber369 {
	
	//�ڸ����� �˼����� ������ ���ڿ��� ���� �ϳ��ϳ��� �ٷ궧 �˾ƾ� �ϴ� �ڵ�. ���ڸ����ڸ��� ���ڸ� �̾Ƴ��� ó��
	// >> ���� ���ڸ����� �˼�����. �׷��� ���� ���������� ó�� 
	
	
	public static int find369(int number) {
		int count = 0;
		while (number>0) { // ���̻� �˻��ؾ��� ���ڰ� ���ٴ¶�
			int temp = number % 10; // ���� 1�� �ڸ�, �� �������ڸ����� ���ڸ� Ȯ���ϴ°�. 
			if (temp == 3 || temp == 6 || temp == 9)
				count++;
			number /= 10;
			// ���ڸ��� ���̴°�
			// ���ڸ� ���ڸ��� �и��� ���� ���� �ڵ� 
			//number�� 0�� �ɶ����� 10�� ������ 1�� �ڸ� ���ڸ� �����ϴ°�.
		}
		return count;
	}
	
	public static void main(String[] args) {	

        for (int i = 1; i <= 100; i++) {
        		int count = find369(i); //i�� value, ���� ����, i�� ������Ƽ�� Ÿ���̱� ����. 
        			System.out.format("%d : ", i);
        	
        			for(int j = 0; j < count; j++ ) {
        				System.out.print("¦");
        			}
        	System.out.println("");
   
        }
				
    }

		
}


