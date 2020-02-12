package DAY1011.ADT;
//제너릭 Generic
//제너릭인터페이스
//IStack과 같지만 타입과 내부구조만 달라진것
public interface GenericStack <T extends Object>{//T라는것이 오브젝트클래스를 상속받음
	
	void push(T data);
	void pop();
	Object top();
	
	boolean isEmpty();
	//boolean isFull();

}
