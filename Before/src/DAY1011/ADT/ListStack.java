package DAY1011.ADT;
//
////import java.util.Collection;
////import java.util.ArrayList;
//import java.util.*;
//
//public class ListStack implements IStack{
//	
//
//		// class's members ������
//		private static final int DEFAULT_SIZE = 10;
//		
//		
//		//instance's members , ��ü�ɹ� 
//		private List<Object> stack; //object�� �Ļ��� ������ �� �ްڴ�
//		private int size;
//		private int topIndex;
//		
//		// Default constructor �⺻ ������ : ���ڰ� ���� ������
//		// Ŭ������ ����� �ʱ�ȭ�Ѵ�. 
//		public ListStack() { //<<�ν��Ͻ� ���, 
//			this.size = DEFAULT_SIZE;
//			this.stack = new ArrayList<Object>(DEFAULT_SIZE); //�� ��̸���Ʈ�� ������ ������ ����, �������� �þ���ֵ�.
//			this.topIndex = 0; //<0�̸� ����ִ°�
//		}
//		
//		//�������� �����ε�
//		public ListStack(int size) {
//			this.size = size;
//			this.stack = new Object[size];
//			}
//		
//		//synchronized�� ���̸� ��������� ����
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
//			return isEmpty() ? null : this.stack.get(this.topIndex -1); //get�̶�� �Լ��� ���
//		}
//
//		public boolean isEmpty() {
//			
//			return this.topIndex == 0;
//		}
//		public boolean isFull() {
//			return this.topIndex ==this.size;
//		}//������ ������ �����Ƿ� ���ڵ尡 ������ ����� �����ϰԵ�.
//		//��κ� ��̸���Ʈ�� ����Ҷ��� �� �ڵ�� �Ⱦ� 
//		
//	}
//


