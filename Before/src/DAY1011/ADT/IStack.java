package DAY1011.ADT;
//인터페이스를 이용한 스택 구현 >> 안의 내용이 바뀌지 않음.

public interface IStack {
	void push(Object data);// 오브젝트로 파생된 모든 타입을 다 넣을수있음.<< 자바 객체를 다 넣을수있다.
	void pop();
	Object top();
	
	boolean isEmpty();
	//boolean isFull();

}
