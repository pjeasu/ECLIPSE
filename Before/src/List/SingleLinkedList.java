package List;
public class SingleLinkedList implements List {
	//Node ����, ������ Ŭ���� �ٱ�, �� �������
	
	class Node{ //�ڷᱸ�� �� ��ü
		
		private int data; //�ڷ�
		private Node next; //��ũ , ���� ��ũ�� ����Ʈ�� ��ũ�� �ΰ� ������ �� < ������带 ����Ű��. ������带 ����Ű�� ��ũ �ΰ� 
		
		public Node(int data, Node next) {//�ڷᱸ���� �����ϱ� ���ؼ� ���� ������ Ÿ��! �������� �����͸� ��� �ٷ����..������ �ڷ��� �𵨸��� node
			this.data = data;
			this.next = next;
		}	
	}
	
	private Node head;
	private Node tail;	
	
	public SingleLinkedList() {
		this.head = null; 
		this.tail = null;
	}
	
	//�����͸� �ϳ��ϳ� �湮�ϴ� �ѹ��� �鸰��, ��ȸ
	
	@Override //������̼�(Annotation) 
	public void addHead(int data) {
		Node newNode = new Node(data, this.head); //node�� �ڵ����� head�� ����Ŵ
		if(this.head == null) //���ο� node�� �׻� ���� node�� �����Ѿ���
			this.tail = newNode;
		
		this.head = newNode;
		
	}
	
	
	
	@Override
	public void addTail(int data) {
		Node newNode = new Node(data, null); //tail�� ��, ������ ����ų �����Ͱ� �����Ƿ� null
		if (this.head == null) //head�� null, ��������Ƿ� ���ο� ��带 �����Ѿ���
				this.head = newNode;
		else {//��� ��尡 �Ѱ� �̻��� ��Ȳ
			this.tail.next = newNode;  // private�������� next�� �����Ҽ��ִ� ���� : inner class�̱� ������ 
		} // next�� ��ũ�� �װ� ����Ű���ִ� ���� null....�� �ڸ��� newNode�� ����..
		this.tail = newNode; //�̸�ǥ�� ���δ�.
	}

	@Override
	public void removeHead() {
		if(this.head == null)
			return; //������ ó�����ϰ� ���������°�
		
		this.head = this.head.next; //next�� null�� ���ɼ�..node�� �Ѱ��϶�
		//this.head == null�� case :  this.tail != null �� �ɼ��� ����
		if(this.head == null)
			this.tail = null;
		
		//this.head != null 
		
		
	}

	@Override
	public void removeTail() { //tail �ڸ���....
		if(this.head == null)//node��ü�� ������ �ڸ��͵� ���� 
			return;
		
		Node prev = this.head;			
		while(prev.next != this.tail) //���� ��尡 tail�� ����Ű�°��� ã�ƾ��� >> �ش� ����� ������ tail�� �ɶ����� ���� 
				prev = prev.next;
		
		prev.next = null; //prev.next�� �ڸ����� �ϴ� ����, null�� ����� �ڸ���.
		this.tail = prev; //prev�� ���ο� tail�� ��. 
		
		}

	

	
	
	
	@Override
	public void insertAt(int index, int data) { //index �̵��� �Ÿ�
		//index�� � ������ �ִ��� �˾ƾ���
		int count = size();
		if (index < 0 || index >count) { //index�� ������ �������� ����ó��
			throw new IndexOutOfBoundsException();
		}
		
		//���Ե���ġ�� ã�°�  �� �ڸ� �˾ƾ���! 
		Node next = this.head; 	//next�� �� �ڸ��� ������带 �˾ƾ��� : prev�ʿ�
		Node prev = null; 		//prev�� null�϶� ��忡 �ְڴ�
		while (index > 0) { 	//ī��Ʈ�� 0�̶�°��� ������ ��忡 �ִ´ٴ¸�
			prev = next;
			next = prev.next;
			index--;
		}
		
		//������ 4���� prev null  		next null 		 >> list�� ������� 
		// 		   prev null  		next not null    >> new node�� head�� �־��
		//		   prev not null  	next null    	 >> new node�� tail�� �־��
		//  	   prev null  		next null
		
		
		Node newNode = new Node(data, next);
		if(prev == null) { //count�� 0�� ���, 
			if(next == null) {//head, tail ��� ����
				this.tail = newNode;
			} //������ ���� next�� node�� ����Ű���ֵ��°���� 
			this.head = newNode; // 
		}else {//prev != null >> �Ӹ��� ������ ������ �κп� ������ ���
			prev.next = newNode; 
			if(next == null) { //������ ���� ���. newnode�� ������ �Ǿ���Ѵ�.  index>= count�� �ƴ� index > count�̹Ƿ�. index>= count�̸� ������ insert����..
			//(prev == this.tail)���� ���� �ǹ� 
				this.tail = newNode;
			}
		}
	}
	
	
	
	
	@Override
	public void removeAt(int index) {
		int count = size();
		if (count == 0 || index < 0 || index >= count) { //index�� ������ �������� ����ó��
			throw new IndexOutOfBoundsException();
		}
		
		Node next = this.head; 	
		Node prev = null; 		
		while (index > 0) { 	//������ nodeã�°�
			prev = next;
			next = prev.next;
			index--;
		}
		
		if(prev == null) { //head���� ���� 
				if (next.next == null) { // �յ� ���̰� �ڵ� ���̶�°��� ��尡 �ϳ���°�
					this.tail = null; //��¥�� ����node�� ���� . ������ node��� ��.  ������node�� ���� node�� null..!
				}
				this.head = next.next;
			} else {
				if(next.next == null) { // ������ node�� ���
					this.tail = prev; //prev�� tail�� �Ǿ���
				}
				prev.next = next.next;
			}
		}
		


	public int getAt(int index) {
		int count = size();
		if (count == 0 || index < 0 || index >= count) { //index�� ������ �������� ����ó��
			throw new IndexOutOfBoundsException();
		}
		
		Node next = this.head; //next�� �� �ڸ��� ������带 �˾ƾ��� : prev�ʿ�
		while (index > 0) { //ī��Ʈ�� 0�̶�°��� ������ ��忡 �ִ´ٴ¸�
		
			next = next.next;
			index--;
	}
		return next.data;
	}
	

	
	
	//������ ���ϴ� �Լ�
	public int size() {
		int count = 0;
		Node next = this.head; //head���� ī��Ʈ ����..
		
		while(next != null) { //head�� null�̸�  count�� 0��. �ƴ϶��!
			next = next.next;
			count++; //�������� �̵��ϸ鼭 ī��Ʈ
		}
		return count;
	}
	
	
	

	
}
