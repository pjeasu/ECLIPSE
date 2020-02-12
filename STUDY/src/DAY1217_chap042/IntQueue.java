package DAY1217_chap042;

public class IntQueue {
	private int max; // ť�� �뷮
	private int front;// ù��° ��� Ŀ��
	private int rear; // ������ ��� Ŀ��
	private int num; // ���� ������ ��
	private int[] que; // ť ��ü

	// ����� ���� : ť�� �������
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// ����� ���� : ť�� ������
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// ������
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max]; // ť ��ü�� �迭 ����
		} catch (OutOfMemoryError e) { // �����Ҽ�������
			max = 0;
		}
	}

	// ť�� �����͸� ��ť
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max) // ť�� ���� �� ����
			throw new OverflowIntQueueException();

		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;

		return x;
	}

	// ť���� �����͸� ��ť
	public int deque() throws EmptyIntQueueException {
		if (num <= 0) // ť�� �� ����
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// ť���� �����͸� ��ũ(����Ʈ �����͸� �鿩�ٺ�)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	// ť���� x�� �˻��Ͽ� �ε����� ��ȯ, ã�����ϸ� -1
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return idx; // �˻� ����
		}
		return -1; // �˻� ����
	}

	//ť�� ���
	public void clear() {
		num = front = rear = 0;
	}

	//ť�� �뷮
	public int capacity() {
		return max;
	}

	//ť�� �׿��ִ� ������ �� 
	public int size() {
		return num;
	}

	//ť�� ����ִ°�
	public boolean isEmpty() {
		return num <= 0;
	}

	//ť�� ���� á�°� 
	public boolean isFull() {
		return num >= max;
	}

	//ť ���� ��� �����͸� ����Ʈ >> ���� ������ ���
	public void dump() {
		if (num <= 0)
			System.out.println("ť�� ����ֽ��ϴ�.");
		else {
			for (int i = 0; i < num; i++) 
				System.out.println(que[(i + front) % max] + " ");
			System.out.println();
		}
	}

}
