package DAY1011.racecondition;

public class ReceCondition {
	private static Long count=0L;
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++) { // ���� ���̴� �� ������� 11��.���� 1�� �� ���� 10�� 
			new Thread(new Runnable() {
				public void run() {
					synchronized(count) { //synchronized(����ȭ�� ��ü)
											//���ϴ� �������� 999 , ���Ѵٸ� ���ڰ� 999�� �ȵ� ���ɼ�������.
						for(int i=0; i<100; i++) {
								System.out.format("Thread: %d, count = %d\n", Thread.currentThread().getId(), count++);
						}//Thread.currentThread().getId() < �������� ���̵� ������
					}
				}
			}).start();
		}
	}
	
}
//�ܼ־ƿ�, count �α������� 