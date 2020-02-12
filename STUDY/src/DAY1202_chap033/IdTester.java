package DAY1202_chap033;

class Id {
	private static int counter = 0; // 아이디를 몇개 부여했는지 저장하는 스태틱변수
	private int id;

	public Id() { // 생성자
		id = ++counter;
	}

	public int getId() { // id를 반환하는 인스턴스 메소드
		return id;
	}

	public static int getCounter() { // counter를 반환하는 클래스메소드
		return counter;
	}

}

public class IdTester {
	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("a의 아이디 : " + a.getId());
		System.out.println("b의 아이디 : " + b.getId());
		//인스턴스 메소드 호출! > 클래스형변수이름.메소드이름
		
		
		System.out.println("부여한 아이디의 개수 : " + Id.getCounter());
		//클래스 메소드 호출 ! > 클래스이름.메소드이름
		
	}
}