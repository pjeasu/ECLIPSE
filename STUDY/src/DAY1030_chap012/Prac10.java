package DAY1030_chap012;

//a, b 값을 입력받고, b - a의 값을 구한다. b의 값이 a보다 작다면  그렇지않을때까지 입력을 다시 받는다. 
import java.util.Scanner;

public class Prac10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a,b;
		do {
			System.out.println("b - a 의 값을 구함");
		System.out.print("a : ");
		a = sc.nextInt();
		System.out.print("b : ");
		b = sc.nextInt();
		} while(b < a);
		
		int min = b - a;
		System.out.println("b - a = " + min);
			
		
		
	}

}
