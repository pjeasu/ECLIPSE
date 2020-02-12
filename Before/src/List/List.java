package List;
public interface List {

	
	void addHead(int data);
	void addTail(int data);
	
	void removeHead();
	void removeTail();
	
	void insertAt(int index, int data); //�߰��� �������߰�, �����
	void removeAt(int index);
	
	int getAt(int index);
	int size();
	


}
/*
public interface List <T extends Object>{

���ʸ� �������̽�,  �Ʒ��� date �� int�� T�� ����
�Ʒ��� �������̽��� ������ ����. ����µǴ�, �ٷ������ �������� Ÿ�Ը� �ٸ���� ���ʸ��� ����Ѵ�***** 
��ü�� �����Ǵ� ������ Ÿ���� ������ <�� ��쿡 ��ü�� 
Ÿ���� �ٲ���ٰ� �����ϴ� ����� �޶��ٸ� ���ʸ��� ����Ҽ�����
���ʸ� Ŭ������ ������ ������ ������ Ÿ�Ը� �ٲ�°�


	
	void addHead(T data);
	void addTail(T data);
	
	void removeHead();
	void removeTail();
	
	void insertAt(int index, T data); //�߰��� �������߰�, �����
	void removeAt(int index);
	
	T get(int index);
	

*/