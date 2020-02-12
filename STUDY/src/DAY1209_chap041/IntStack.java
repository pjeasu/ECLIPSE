package DAY1209_chap041;

public class IntStack {
	// int�� ����

	private int max; // ���� �뷮
	private int ptr; // ���� ������
	private int[] stk; // ���� ��ü

	// ����� ���� :������ �������
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {

		}
	}

	// ����� ���� :������ ������
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public IntStack(int capacity) {
		ptr = 0; // �迭 ������ ������ ��������Ƿ� ���������ʹ� 0
		max = capacity; // �뷮
		try {
			stk = new int[max]; // ���� ��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // �����Ҽ� ����
			// �迭 ��ü�� ������ �����Ұ��, max �� 0���� ! >> �ٸ� �޼ҵ尡 �������� �ʴ� �迭�� �߸� �����ϴ°��� ���� �� ����
			max = 0;
		}
	}

	public int push(int x) throws OverflowIntStackException {
		// ������ �������� Ǫ�� �� �� ���� ��� ���ܸ� ����
//		if(ptr >= max)
		if (ptr == max)
			// �����۾��� �����ϸ� ���������� ptr���� �ݵ�� 0�̻� max���ϰ� ��
			//
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	public int pop() throws EmptyIntStackException {
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	public int peek() throws EmptyIntStackException { //����⿡ �ִ� ������ Ȯ�� 
		if (ptr <= 0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--)
			if (stk[i] == x)
				return i;
		return -1;
	}

	public void clear() {
		ptr = 0;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return ptr;
	}

	public boolean isEmpty() {
		return ptr <= 0;
	}

	public boolean isFull() {
		return ptr >= max;
	}

	public void dump() {
		if (ptr <= 0)
			System.out.println("������ ������ϴ�.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}

}
