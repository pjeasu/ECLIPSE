package DAY1011.ADT;
import java.util.*;
public class Main {
//ArrayStack�� ���ѱ������� �������̽��� �̿��Ѱ� ���ϴ� 
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
				//int�� ���� Integer �����ڸ� �θ���.
		
		for (int i = 0; i<10; i++)
			list.add(i);   
		//Integer�� ��Ʈ�� �޴� �����ڰ� �־ ������.
		//list.add(new Integer(i));
				
		for(int i = 1; i <=10; i++)
			System.out.format("%d : %d\n", 10-i, list.remove(10-i));
		
		/*
		ArrayStack stack = new ArrayStack(10); //ArrayStack stack = new ArrayStack(); <<�⺻ ������
		for(Integer i = 0; i< 10; i++)
			stack.push(i); //i���¹��ڼ��� �ƹ��ų� �� �������ִ�.
		
		for(Integer j = 0; j< 10; j++) {
			System.out.format("%s \n", stack.top().toString());
			stack.pop();
		}
		*/
	}
}
