package DAY1011.ADT;

public class ArrayStack extends AbstractStack{
	// class's members ������
	private static final int DEFAULT_SIZE = 10;
	
	
	//instance's members , ��ü�ɹ� 
	private Object[] stack; //final Object�� ���ִ°��� �����ڿ����� ���� . . ? 
	private int size;
	private int topIndex;
	
	// Default constructor �⺻ ������ : ���ڰ� ���� ������
	// Ŭ������ ����� �ʱ�ȭ�Ѵ�. 
	public ArrayStack() { //<<�ν��Ͻ� ���, 
		this.size = DEFAULT_SIZE;
		this.stack = new Object[this.size];
		this.topIndex = 0; //<0�̸� ����ִ°�
	}
	
	//�������� �����ε�
	public ArrayStack(int size) {
		this.size = size;
		this.stack = new Object[size];
		}
	
	//synchronized�� ���̸� ��������� ����
	public synchronized void push(Object data) {
		
	}

	public synchronized void pop() {
		if(isEmpty())
			return;
		
		this.stack[this.topIndex-1] = null;
		this.topIndex--;
	}

	public synchronized Object top() {
		return isEmpty() ? null : this.stack[this.topIndex -1];
	}

	public boolean isEmpty() {
		
		return this.topIndex == 0;
	}
	public boolean isFull() {
		return this.topIndex ==this.size;
	}
	
}
