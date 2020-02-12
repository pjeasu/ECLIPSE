package List;
public interface List {

	
	void addHead(int data);
	void addTail(int data);
	
	void removeHead();
	void removeTail();
	
	void insertAt(int index, int data); //중간에 데이터추가, 지우기
	void removeAt(int index);
	
	int getAt(int index);
	int size();
	


}
/*
public interface List <T extends Object>{

제너릭 인터페이스,  아래의 date 앞 int에 T를 넣음
아래의 인터페이스와 동작은 같음. 입출력되는, 다루어지는 데이터의 타입만 다른경우 제너릭을 사용한다***** 
객체가 생성되는 시점에 타입은 결정됨 <이 경우에 객체는 
타입이 바뀌었다고 구현하는 방법이 달라딘다면 제너릭을 사용할수없음
제너릭 클래스는 구현은 같은데 데이터 타입만 바뀌는것


	
	void addHead(T data);
	void addTail(T data);
	
	void removeHead();
	void removeTail();
	
	void insertAt(int index, T data); //중간에 데이터추가, 지우기
	void removeAt(int index);
	
	T get(int index);
	

*/