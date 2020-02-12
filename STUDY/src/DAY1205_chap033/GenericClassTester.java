package DAY1205_chap033;

public class GenericClassTester {
	
	//���׸�Ŭ������ ��
	//���׸�Ŭ������ �Ķ���͸� T��� �ۼ�
	static class GenericClass<T>{
		private T xyz;
		
		GenericClass(T t) {
			this.xyz = t;
		}
		T getXyz() {
			return xyz;
		}
	}

	public static void main(String[] args) {
		//���׸�Ÿ���� ����ϸ� ���������� �Ķ���Ϳ��� String�� �ѱ����, Integer�� �ѱ���� ����
		GenericClass<String> s = new GenericClass<String>("ABC");
		GenericClass<Integer> n = new GenericClass<Integer>(15);
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
	
	
	}
}
