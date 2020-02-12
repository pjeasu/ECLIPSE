package DAY1011.ADT;
import java.util.*;
public class Main {
//ArrayStack을 통한구현보다 인터페이스를 이용한게 편하다 
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
				//int를 갖는 Integer 생성자를 부른다.
		
		for (int i = 0; i<10; i++)
			list.add(i);   
		//Integer가 인트를 받는 생성자가 있어서 가능함.
		//list.add(new Integer(i));
				
		for(int i = 1; i <=10; i++)
			System.out.format("%d : %d\n", 10-i, list.remove(10-i));
		
		/*
		ArrayStack stack = new ArrayStack(10); //ArrayStack stack = new ArrayStack(); <<기본 생성자
		for(Integer i = 0; i< 10; i++)
			stack.push(i); //i에는문자숫자 아무거나 다 넣을수있다.
		
		for(Integer j = 0; j< 10; j++) {
			System.out.format("%s \n", stack.top().toString());
			stack.pop();
		}
		*/
	}
}
