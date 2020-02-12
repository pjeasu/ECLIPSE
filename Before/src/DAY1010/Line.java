package DAY1010;

public class Line extends Shape implements Printing { //implements ㅇㅇㅇ > 인터페이스 상속할때 클래스는 못옴..>, 종류가 다른 인터페이스는 여러개 상속 가능 함
  //자바는 구현 상속에서 단일 상속만 지원, 다중 상속 안됨.. 인터페이스 상속은 다중상속 지원함
  //= 클래스에 대한 상속은 단일만..
    public void draw() {
        super.draw();
        System.out.println("Draw line");
    }

    public void move(int x, int y) {
        System.out.println("move line");
    }


    public void rotate(int radian) {
        System.out.println("rotate line");
    }

// implements a Printing interface  인터페이스 구현
   public void print() {
        System.out.println("Print something");
   }


}