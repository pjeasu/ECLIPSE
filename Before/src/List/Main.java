package List;import java.util.*;


public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		//GenericLinkedList<Integer> intList = new GenericLinkedList<Intger>();
		
		for (int i = 0; i< 10; i++)
			linkedList.add(0, i);
		
		for(int i = 0; i <10; i++) //index ���� �ʿ��Ҷ� 
			System.out.format("linkedList[%d] = %d\n", i, linkedList.get(i));
		
		for(Integer i : linkedList)//index ���� �ʿ������ 
			System.out.format("i = %d\n", i);

		
		//O(n) ���� 
		
		
		
		List list = new SingleLinkedList();
		for(int i = 0; i<10; i++)
			list.insertAt(0, i);

		
		for(int i = 0; i <10; i++)
			System.out.format("list[%d] = %d\n", i, list.getAt(i));
	}
}
//�� ������ ���� ����� ������ linked list�� foreach ���� 