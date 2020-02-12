
package DAY1014.review;
abstract class Stack {
	public abstract void push(int value); 
	// public abstract int pop(); <<�̰�� top�� �ʿ����
	public abstract void pop();
	public abstract int top();
	public abstract boolean isEmpty();
	//ž�� ����Ƽ�� ���ϰ���
}

interface IStack {
	void push (int value);
	void pop();
	int top();
	boolean isEmpty();
}