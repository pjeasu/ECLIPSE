//import java.util.
package DAY1011.ADT;
//
//public class GenericArrayStack <T extends Object> implements GenericStack<T>{
//	// class's members 멤버상수
//	private static final int DEFAULT_SIZE = 10;
//	
//	
//	//instance's members , 객체맴버 
//	private Object[] stack; //final Object를 해주는것은 생성자에서만 가능 . . ? 
//	private int size;
//	private int topIndex;
//	
//	// Default constructor 기본 생성자 : 인자가 없는 생성자
//	// 클래스의 멤버를 초기화한다. 
//	public GenericArrayStack() { //<<인스턴스 멤버, 
//		this.size = DEFAULT_SIZE;
//		this.stack = new Object[this.size];
//		this.topIndex = 0; //<0이면 비어있는것
//	}
//	
//	//생성자의 오버로드
//	public GenericArrayStack(int size) {
//		this.size = size;
//		this.stack = new Object[size];
//		}
//	
//	//synchronized를 붙이면 동기식으로 동작
//	public synchronized void push(Object data) {
//		
//	}
//
//	public synchronized void pop() {
//		if(isEmpty())
//			return;
//		
//		this.stack[this.topIndex-1] = null;
//		this.topIndex--;
//	}
//
//	public synchronized Object T top() {
//		return isEmpty() ? null : (T)this.stack[this.topIndex -1];
//	}
//
//	public boolean isEmpty() {
//		
//		return this.topIndex == 0;
//	}
//	public boolean isFull() {
//		return this.topIndex ==this.size;
//	}
//	
//}
