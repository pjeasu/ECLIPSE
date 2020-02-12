package DAY1205_chap033;

public class GenericClassTester {
	
	//제네릭클래스의 예
	//제네릭클래스의 파라미터를 T라고 작성
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
		//제네릭타입을 사용하면 다음과같이 파라미터에서 String을 넘길수도, Integer를 넘길수도 있음
		GenericClass<String> s = new GenericClass<String>("ABC");
		GenericClass<Integer> n = new GenericClass<Integer>(15);
		
		System.out.println(s.getXyz());
		System.out.println(n.getXyz());
	
	
	}
}
