package DAY1216_chap041;


//Prac03

public class IntStackX {
	private int max; // 스택 용량
	private int ptrA; // 스택 포인터
	private int ptrB;
	private int[] stk; // 스택 본체

	public enum AorB {
		StackA, StackB
	};

	// 실행시 예외 :스택이 비어있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {

		}
	}

	// 실행시 예외 :스택이 가득참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	public IntStackX(int capacity) {
		ptrA = 0; // 배열 생성시 스택은 비어있으므로 스택포인터는 0
		ptrB = capacity - 1;
		max = capacity; // 용량
		try {
			stk = new int[max]; // 스택 본체용 배열을 생성
		} catch (OutOfMemoryError e) { // 생성할수 없음
			// 배열 본체의 생성에 실패할경우, max 값 0으로 ! >> 다른 메소드가 존재하지 않는 배열에 잘못 접근하는것을 막을 수 있음
			max = 0;
		}
	}

	public int push(AorB sw, int x) throws OverflowIntStackException {
		// 스택이 가득차서 푸시 할 수 없는 경우 예외를 던짐
		if (ptrA >= ptrB + 1) // 스택이 가득 찬 경우
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
			if(ptrA <= 0)//Stack A가 비어있을때
				throw new EmptyIntStackException();
			x = stk[--ptrA];
			break;
		case StackB:
			if(ptrA <= 0)//Stack B가 비어있을때
				throw new EmptyIntStackException();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	public int peek(AorB sw) throws EmptyIntStackException { // 꼭대기에 있는 데이터 확인
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // 스택 A가 비어 있음
				throw new EmptyIntStackException();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) // 스택 B가 비어 있음
				throw new EmptyIntStackException();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}
	
	// 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
	public int indexOf(AorB sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
				if (stk[i] == x)
					return i; // 검색성공
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) // 꼭대기쪽부터 선형 검색
				if (stk[i] == x)
					return i; // 검색성공
			break;
		}
		return -1; // 검색실패
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

	//스택의 용량을 반환
	public int capacity() {
		return max;
	}

	//스택에 쌓여있는 데이터수 반환
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
	
	// 스택 안의 터이터를 바닥 → 꼭대기의 차례로 나타냄
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("스택이 비었습니다.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}
