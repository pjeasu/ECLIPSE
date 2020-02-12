package DAY1104_chap021;

public class IntArray {
	public static void main(String[] args) {
		int[] a = new int[5];
//		int[] a ;  >> 선언하기
//		a = new int [5];  >> 참조하기 
		
		a[1] = 37;
		a[2] = 51;
		a[4] = a[1] * 2;
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i + "] = " + a[i]);
		}
	}
}
