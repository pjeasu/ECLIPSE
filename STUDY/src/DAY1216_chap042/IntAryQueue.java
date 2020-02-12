package DAY1216_chap042;


//Prac04
public class IntAryQueue {
	private int max; 	// 큐 용량
	private int num; 	// 현재 데이터 수 
	private int[] que; 	// 큐 본체
	
	public class EmptyIntAryQueueException extends RuntimeException{
		public EmptyIntAryQueueException() {
			
		}
	}
	
	public class OverflowIntAryQueueException extends RuntimeException{
		public OverflowIntAryQueueException() {
			
		}
	}
	
	
	public IntAryQueue(int capacity) {
		num = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max=0;
		}
	}
	
	public int enqueue(int x) throws EmptyIntAryQueueException {
		if (num == max)
			throw new EmptyIntAryQueueException();
		return que[num++] = x;
	}
	
	public int dequeue(int x) throws OverflowIntAryQueueException {
		if (num <= 0)
			throw new OverflowIntAryQueueException();
		return que[--num] = x;
	}
	
	public int peek() throws EmptyIntAryQueueException { //꼭대기에 있는 데이터 확인 
		if (num <= 0)
			throw new EmptyIntAryQueueException();
		return que[num - 1];
	}
	
	public int indexOf(int x) {
		for (int i = num - 1; i >= 0; i--)
			if (que[i] == x)
				return i;
		return -1;
	}
	public void clear() {
		num = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return num;
	}

	public boolean isEmpty() {
		return num <= 0;
	}

	public boolean isFull() {
		return num >= max;
	}

	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비었습니다.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[i] + " ");
			}
			System.out.println();
		}
	}
}
