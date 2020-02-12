package DAY1216_chap041;


//Prac03

public class IntStackX {
	private int max; // ���� �뷮
	private int ptrA; // ���� ������
	private int ptrB;
	private int[] stk; // ���� ��ü

	public enum AorB {
		StackA, StackB
	};

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

	public IntStackX(int capacity) {
		ptrA = 0; // �迭 ������ ������ ��������Ƿ� ���������ʹ� 0
		ptrB = capacity - 1;
		max = capacity; // �뷮
		try {
			stk = new int[max]; // ���� ��ü�� �迭�� ����
		} catch (OutOfMemoryError e) { // �����Ҽ� ����
			// �迭 ��ü�� ������ �����Ұ��, max �� 0���� ! >> �ٸ� �޼ҵ尡 �������� �ʴ� �迭�� �߸� �����ϴ°��� ���� �� ����
			max = 0;
		}
	}

	public int push(AorB sw, int x) throws OverflowIntStackException {
		// ������ �������� Ǫ�� �� �� ���� ��� ���ܸ� ����
		if (ptrA >= ptrB + 1) // ������ ���� �� ���
			throw new OverflowIntStackException();

		switch (sw) {
		case StackA:
			stk[ptrA++] = x;
			break;

		case StackB:
			stk[ptrB--] = x;
			break;
		}

		return x;
	}

	public int pop(AorB sw) throws EmptyIntStackException {
		int x = 0;
		switch(sw) {
		case StackA:
			if(ptrA <= 0)//Stack A�� ���������
				throw new EmptyIntStackException();
			x = stk[--ptrA];
			break;
		case StackB:
			if(ptrA <= 0)//Stack B�� ���������
				throw new EmptyIntStackException();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	public int peek(AorB sw) throws EmptyIntStackException { // ����⿡ �ִ� ������ Ȯ��
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ���� A�� ��� ����
				throw new EmptyIntStackException();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) // ���� B�� ��� ����
				throw new EmptyIntStackException();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}
	
	// ���ÿ��� x�� �˻��Ͽ� index(ã�� ���ϸ� -1)�� ��ȯ
	public int indexOf(AorB sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) // ������ʺ��� ���� �˻�
				if (stk[i] == x)
					return i; // �˻�����
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) // ������ʺ��� ���� �˻�
				if (stk[i] == x)
					return i; // �˻�����
			break;
		}
		return -1; // �˻�����
	}


	public void clear(AorB sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;
		case StackB:
			ptrB = max - 1;
			break;
		}
	}

	//������ �뷮�� ��ȯ
	public int capacity() {
		return max;
	}

	//���ÿ� �׿��ִ� �����ͼ� ��ȯ
	public int size(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	public boolean isEmpty(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max - 1;
		}
		return true;
	}

	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}
	
	// ���� ���� �����͸� �ٴ� �� ������� ���ʷ� ��Ÿ��
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("������ ������ϴ�.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("������ ������ϴ�.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}
