
package DAY1014.review;
abstract class Stack {
	public abstract void push(int value); 
	// public abstract int pop(); <<이경우 top은 필요없음
	public abstract void pop();
	public abstract int top();
	public abstract boolean isEmpty();
	//탑과 엠프티는 보완관계
}

interface IStack {
	void push (int value);
	void pop();
	int top();
	boolean isEmpty();
}