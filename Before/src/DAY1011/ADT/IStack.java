package DAY1011.ADT;
//�������̽��� �̿��� ���� ���� >> ���� ������ �ٲ��� ����.

public interface IStack {
	void push(Object data);// ������Ʈ�� �Ļ��� ��� Ÿ���� �� ����������.<< �ڹ� ��ü�� �� �������ִ�.
	void pop();
	Object top();
	
	boolean isEmpty();
	//boolean isFull();

}
