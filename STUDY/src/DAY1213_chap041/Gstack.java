package DAY1213_chap041;
//Prac02

public class Gstack<E> {

	private int max; // ���� �뷮
	private int ptr; // ���� ������
	private E[] stk; // ���� ��ü

	// ����� ���� :������ �������
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {

		}
	}

	// ����� ���� :������ ������
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}

	public Gstack(int capacity) {
		ptr = 0; // �迭 ������ ������ ��������Ƿ� ���������ʹ� 0
		max = capacity; // �뷮
		try {
//			stk = (E[]) new Object[max]; // ���� ��ü�� �迭�� ����
			stk = (E[])new Object[max]; 
			
		} catch (OutOfMemoryError e) { // �����Ҽ� ����
			// �迭 ��ü�� ������ �����Ұ��, max �� 0���� ! >> �ٸ� �޼ҵ尡 �������� �ʴ� �迭�� �߸� �����ϴ°��� ���� �� ����
			max = 0;
		}
	}

	public E push(E x) throws OverflowGstackException {
		// ������ �������� Ǫ�� �� �� ���� ��� ���ܸ� ����
//		if(ptr >= max)
		if (ptr == max)
			// �����۾��� �����ϸ� ���������� ptr���� �ݵ�� 0�̻� max���ϰ� ��
			//
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	public E pop() throws EmptyGstackException {
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	public E peek() throws EmptyGstackException { // ����⿡ �ִ� ������ Ȯ��
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}

	public int indexOf(E x) {
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
