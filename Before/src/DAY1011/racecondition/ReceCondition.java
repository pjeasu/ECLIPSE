package DAY1011.racecondition;

public class ReceCondition {
	private static Long count=0L;
	
	public static void main(String[] args) {
		for(int i=0; i<10; i++) { // 눈에 보이는 총 스레드는 11개.메인 1개 그 안의 10개 
			new Thread(new Runnable() {
				public void run() {
					synchronized(count) { //synchronized(동기화할 객체)
											//원하는 최종값은 999 , 안한다면 숫자가 999가 안될 가능성이있음.
						for(int i=0; i<100; i++) {
								System.out.format("Thread: %d, count = %d\n", Thread.currentThread().getId(), count++);
						}//Thread.currentThread().getId() < 스레드의 아이디를 리턴함
					}
				}
			}).start();
		}
	}
	
}
//콘솔아웃, count 두군데에서 