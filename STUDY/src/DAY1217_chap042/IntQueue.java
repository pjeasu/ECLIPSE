package DAY1217_chap042;

public class IntQueue {
	private int max; // 큐의 용량
	private int front;// 첫번째 요소 커서
	private int rear; // 마지막 요소 커서
	private int num; // 현재 데이터 수
	private int[] que; // 큐 본체

	// 실행시 예외 : 큐가 비어있음
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	// 실행시 예외 : 큐가 가득참
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
		}
	}

	// 생성자
	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max]; // 큐 본체용 배열 생성
		} catch (OutOfMemoryError e) { // 생성할수없을때
			max = 0;
		}
	}

	// 큐에 데이터를 인큐
	public int enque(int x) throws OverflowIntQueueException {
		if (num >= max) // 큐가 가득 찬 상태
			throw new OverflowIntQueueException();

		que[rear++] = x;
		num++;
		if (rear == max)
			rear = 0;

		return x;
	}

	// 큐에서 데이터를 디큐
	public int deque() throws EmptyIntQueueException {
		if (num <= 0) // 큐가 빈 상태
			throw new EmptyIntQueueException();
		int x = que[front++];
		num--;
		if (front == max)
			front = 0;
		return x;
	}

	// 큐에서 데이터를 피크(프론트 데이터를 들여다봄)
	public int peek() throws EmptyIntQueueException {
		if (num <= 0)
			throw new EmptyIntQueueException();
		return que[front];
	}

	// 큐에서 x를 검색하여 인덱스를 반환, 찾지못하면 -1
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if (que[idx] == x)
				return idx; // 검색 성공
		}
		return -1; // 검색 실패
	}

	//큐를 비움
	public void clear() {
		num = front = rear = 0;
	}

	//큐의 용량
	public int capacity() {
		return max;
	}

	//큐에 쌓여있는 데이터 수 
	public int size() {
		return num;
	}

	//큐가 비어있는가
	public boolean isEmpty() {
		return num <= 0;
	}

	//큐가 가득 찼는가 
	public boolean isFull() {
		return num >= max;
	}

	//큐 안의 모든 데이터를 프론트 >> 리어 순으로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다.");
		else {
			for (int i = 0; i < num; i++) 
				System.out.println(que[(i + front) % max] + " ");
			System.out.println();
		}
	}

}
