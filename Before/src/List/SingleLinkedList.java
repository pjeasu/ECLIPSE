package List;
public class SingleLinkedList implements List {
	//Node 정의, 선언은 클래스 바깥, 안 상관없음
	
	class Node{ //자료구조 그 자체
		
		private int data; //자료
		private Node next; //링크 , 더블 링크드 리스트는 링크가 두개 있으면 됨 < 이전노드를 가리키는. 다음노드를 가리키는 링크 두개 
		
		public Node(int data, Node next) {//자료구조를 구현하기 위해서 사용된 데이터 타입! 내부적인 데이터를 어떻게 다루는지..내부적 자료의 모델링이 node
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
	
	//데이터를 하나하나 방문하다 한번씩 들린다, 순회
	
	@Override //어노테이션(Annotation) 
	public void addHead(int data) {
		Node newNode = new Node(data, this.head); //node는 자동으로 head를 가리킴
		if(this.head == null) //새로운 node는 항상 현재 node를 가리켜야함
			this.tail = newNode;
		
		this.head = newNode;
		
	}
	
	
	
	@Override
	public void addTail(int data) {
		Node newNode = new Node(data, null); //tail은 끝, 다음에 가리킬 데이터가 없으므로 null
		if (this.head == null) //head가 null, 비어있으므로 새로운 노드를 가리켜야함
				this.head = newNode;
		else {//적어도 노드가 한개 이상인 상황
			this.tail.next = newNode;  // private데이터인 next에 접근할수있는 이유 : inner class이기 때문에 
		} // next는 링크고 그게 가리키고있는 값이 null....그 자리에 newNode를 대입..
		this.tail = newNode; //이름표를 붙인다.
	}

	@Override
	public void removeHead() {
		if(this.head == null)
			return; //다음걸 처리안하고 빠져나가는것
		
		this.head = this.head.next; //next가 null일 가능성..node가 한개일때
		//this.head == null인 case :  this.tail != null 이 될수가 있음
		if(this.head == null)
			this.tail = null;
		
		//this.head != null 
		
		
	}

	@Override
	public void removeTail() { //tail 자르기....
		if(this.head == null)//node자체가 없으면 자를것도 없음 
			return;
		
		Node prev = this.head;			
		while(prev.next != this.tail) //다음 노드가 tail을 가리키는것을 찾아야함 >> 해당 노드의 다음이 tail이 될때까지 진행 
				prev = prev.next;
		
		prev.next = null; //prev.next는 자르고자 하는 꼬리, null로 만들어 자른다.
		this.tail = prev; //prev가 새로운 tail이 됨. 
		
		}

	

	
	
	
	@Override
	public void insertAt(int index, int data) { //index 이동할 거리
		//index가 어떤 범위에 있는지 알아야함
		int count = size();
		if (index < 0 || index >count) { //index가 범위를 벗어났을경우 예외처리
			throw new IndexOutOfBoundsException();
		}
		
		//삽입될위치를 찾는것  앞 뒤를 알아야함! 
		Node next = this.head; 	//next가 들어갈 자리의 앞전노드를 알아야함 : prev필요
		Node prev = null; 		//prev가 null일때 헤드에 넣겠다
		while (index > 0) { 	//카운트가 0이라는것은 무조건 헤드에 넣는다는말
			prev = next;
			next = prev.next;
			index--;
		}
		
		//조건은 4가지 prev null  		next null 		 >> list가 비어있음 
		// 		   prev null  		next not null    >> new node를 head에 넣어라
		//		   prev not null  	next null    	 >> new node를 tail에 넣어라
		//  	   prev null  		next null
		
		
		Node newNode = new Node(data, next);
		if(prev == null) { //count가 0인 경우, 
			if(next == null) {//head, tail 모두 없음
				this.tail = newNode;
			} //나머지 경우는 next가 node를 가리키고있따는경우임 
			this.head = newNode; // 
		}else {//prev != null >> 머리를 제외한 나머지 부분에 삽입할 경우
			prev.next = newNode; 
			if(next == null) { //꼬리에 넣을 경우. newnode가 꼬리가 되어야한다.  index>= count가 아닌 index > count이므로. index>= count이면 꼬리에 insert못함..
			//(prev == this.tail)위와 같은 의미 
				this.tail = newNode;
			}
		}
	}
	
	
	
	
	@Override
	public void removeAt(int index) {
		int count = size();
		if (count == 0 || index < 0 || index >= count) { //index가 범위를 벗어났을경우 예외처리
			throw new IndexOutOfBoundsException();
		}
		
		Node next = this.head; 	
		Node prev = null; 		
		while (index > 0) { 	//제거할 node찾는것
			prev = next;
			next = prev.next;
			index--;
		}
		
		if(prev == null) { //head에서 제거 
				if (next.next == null) { // 앞도 널이고 뒤도 널이라는것은 노드가 하나라는것
					this.tail = null; //어짜피 다음node가 없음 . 마지막 node라는 뜻.  마지막node의 다음 node는 null..!
				}
				this.head = next.next;
			} else {
				if(next.next == null) { // 마지막 node일 경우
					this.tail = prev; //prev가 tail이 되야함
				}
				prev.next = next.next;
			}
		}
		


	public int getAt(int index) {
		int count = size();
		if (count == 0 || index < 0 || index >= count) { //index가 범위를 벗어났을경우 예외처리
			throw new IndexOutOfBoundsException();
		}
		
		Node next = this.head; //next가 들어갈 자리의 앞전노드를 알아야함 : prev필요
		while (index > 0) { //카운트가 0이라는것은 무조건 헤드에 넣는다는말
		
			next = next.next;
			index--;
	}
		return next.data;
	}
	

	
	
	//갯수를 구하는 함수
	public int size() {
		int count = 0;
		Node next = this.head; //head부터 카운트 시작..
		
		while(next != null) { //head가 null이면  count는 0임. 아니라면!
			next = next.next;
			count++; //꼬리까지 이동하면서 카운트
		}
		return count;
	}
	
	
	

	
}
