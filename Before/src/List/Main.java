package List;import java.util.*;


public class Main {
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		//GenericLinkedList<Integer> intList = new GenericLinkedList<Intger>();
		
		for (int i = 0; i< 10; i++)
			linkedList.add(0, i);
		
		for(int i = 0; i <10; i++) //index 색인 필요할때 
			System.out.format("linkedList[%d] = %d\n", i, linkedList.get(i));
		
		for(Integer i : linkedList)//index 색인 필요없을때 
			System.out.format("i = %d\n", i);

		
		//O(n) 성능 
		
		
		
		List list = new SingleLinkedList();
		for(int i = 0; i<10; i++)
			list.insertAt(0, i);

		
		for(int i = 0; i <10; i++)
			System.out.format("list[%d] = %d\n", i, list.getAt(i));
	}
}
//두 버전은 같은 기능을 하지만 linked list는 foreach 가능 