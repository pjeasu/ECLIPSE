package DAY1216_chap042;


//Prac04
public class IntAryQueue {
	private int max; 	// ť �뷮
	private int num; 	// ���� ������ �� 
	private int[] que; 	// ť ��ü
	
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
	
	public int peek() throws EmptyIntAryQueueException { //����⿡ �ִ� ������ Ȯ�� 
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
			System.out.println("ť�� ������ϴ�.");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que[i] + " ");
			}
			System.out.println();
		}
	}
}
