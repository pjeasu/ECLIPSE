package DAY1213_chap041;
//Prac02

public class Gstack<E> {

	private int max; // 스택 용량
	private int ptr; // 스택 포인터
	private E[] stk; // 스택 본체

	// 실행시 예외 :스택이 비어있음
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {

		}
	}

	// 실행시 예외 :스택이 가득참
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}

	public Gstack(int capacity) {
		ptr = 0; // 배열 생성시 스택은 비어있으므로 스택포인터는 0
		max = capacity; // 용량
		try {
//			stk = (E[]) new Object[max]; // 스택 본체용 배열을 생성
			stk = (E[])new Object[max]; 
			
		} catch (OutOfMemoryError e) { // 생성할수 없음
			// 배열 본체의 생성에 실패할경우, max 값 0으로 ! >> 다른 메소드가 존재하지 않는 배열에 잘못 접근하는것을 막을 수 있음
			max = 0;
		}
	}

	public E push(E x) throws OverflowGstackException {
		// 스택이 가득차서 푸시 할 수 없는 경우 예외를 던짐
//		if(ptr >= max)
		if (ptr == max)
			// 스택작업을 수행하면 스택포인터 ptr값은 반드시 0이상 max이하가 됨
			//
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	public E pop() throws EmptyGstackException {
		if (ptr <= 0)
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	public E peek() throws EmptyGstackException { // 꼭대기에 있는 데이터 확인
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
			System.out.println("스택이 비었습니다.");
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print(stk[i] + " ");
			}
			System.out.println();
		}
	}

}
