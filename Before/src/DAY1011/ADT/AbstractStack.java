package DAY1011.ADT;

public abstract class AbstractStack {
	//ㅎㅏ나라도구현체가 있따면 abstract가 나음 하지만 모두  abstract로 이루어져있다면 인터페이스가 나음 
	
	public abstract void push(Object data);
	public abstract void pop();
	public abstract Object top();
	
	public abstract boolean isEmpty();
	//public abstract boolean isFull();
	
}
