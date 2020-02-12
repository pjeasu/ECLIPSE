package DAY1030_chap012;

public class Prac12 {
	public static void main(String[] args) {
		
		
		System.out.printf("%4s","|");
		for(int i = 1; i <=9; i++) {
			System.out.printf("%3d", i);
		}
		System.out.println(" ");
		System.out.println("---+---------------------------");
		
		
		for(int i = 1; i<=9; i++) {
			System.out.printf("%d%3s", i,"|");
			for(int j = 1; j<=9; j++)
				System.out.printf("%3d" , i*j);
			System.out.println();
		}
		
	}

}
