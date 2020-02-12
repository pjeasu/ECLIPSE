package DAY1011.ADT;
//
////import java.util.Collection;
////import java.util.ArrayList;
//import java.util.*;
//
//public class ListStack implements IStack{
//	
//
//		// class's members 멤버상수
//		private static final int DEFAULT_SIZE = 10;
//		
//		
//		//instance's members , 객체맴버 
//		private List<Object> stack; //object로 파생된 모든것을 다 받겠다
//		private int size;
//		private int topIndex;
//		
//		// Default constructor 기본 생성자 : 인자가 없는 생성자
//		// 클래스의 멤버를 초기화한다. 
//		public ListStack() { //<<인스턴스 멤버, 
//			this.size = DEFAULT_SIZE;
//			this.stack = new ArrayList<Object>(DEFAULT_SIZE); //이 어레이리스트는 사이즈 제한이 없음, 동적으로 늘어날수있따.
//			this.topIndex = 0; //<0이면 비어있는것
//		}
//		
//		//생성자의 오버로드
//		public ListStack(int size) {
//			this.size = size;
//			this.stack = new Object[size];
//			}
//		
//		//synchronized를 붙이면 동기식으로 동작
//		public synchronized void push(Object data) {
//			if (isFull())
//				return;
//			
//			this.stack.add(this.topIndex,data);
//			this.topIndex++;
//			
//		}
//
//		public synchronized void pop() {
//			if(isEmpty())
//				return;
//			
//			this.stack.remove(this.topIndex-1);
//			this.topIndex--;
//		}
//
//		public synchronized Object top() {
//			return isEmpty() ? null : this.stack.get(this.topIndex -1); //get이라는 함수를 사용
//		}
//
//		public boolean isEmpty() {
//			
//			return this.topIndex == 0;
//		}
//		public boolean isFull() {
//			return this.topIndex ==this.size;
//		}//사이즈 제한이 없으므로 이코드가 있으면 사이즈를 제한하게됨.
//		//대부분 어레이리스트를 사용할때는 이 코드는 안씀 
//		
//	}
//


