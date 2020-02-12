package DAY1202_chap033;

class Id {
	private static int counter = 0; // ���̵� � �ο��ߴ��� �����ϴ� ����ƽ����
	private int id;

	public Id() { // ������
		id = ++counter;
	}

	public int getId() { // id�� ��ȯ�ϴ� �ν��Ͻ� �޼ҵ�
		return id;
	}

	public static int getCounter() { // counter�� ��ȯ�ϴ� Ŭ�����޼ҵ�
		return counter;
	}

}

public class IdTester {
	public static void main(String[] args) {
		Id a = new Id();
		Id b = new Id();
		
		System.out.println("a�� ���̵� : " + a.getId());
		System.out.println("b�� ���̵� : " + b.getId());
		//�ν��Ͻ� �޼ҵ� ȣ��! > Ŭ�����������̸�.�޼ҵ��̸�
		
		
		System.out.println("�ο��� ���̵��� ���� : " + Id.getCounter());
		//Ŭ���� �޼ҵ� ȣ�� ! > Ŭ�����̸�.�޼ҵ��̸�
		
	}
}