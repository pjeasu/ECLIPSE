package DAY1011.ADT;
//���ʸ� Generic
//���ʸ��������̽�
//IStack�� ������ Ÿ�԰� ���α����� �޶�����
public interface GenericStack <T extends Object>{//T��°��� ������ƮŬ������ ��ӹ���
	
	void push(T data);
	void pop();
	Object top();
	
	boolean isEmpty();
	//boolean isFull();

}
