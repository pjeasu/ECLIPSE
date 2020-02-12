package DAY1010;

public class Main {
    public static void main(String[] args) {//main은 주 진입점 entry point 여러개일수없음. 하나여야한다. 
        Shape shape = new Line();
      // do not call Shape.draw();
        shape.draw();
        //shape도, line에도 재정의해서 가지고있음 < 오버라이드 됐을때는 객체의 타입을 따라간다. 타입은  line. 
        //위의  draw는 객체의 다형성을 보여주는 예제.. 

    }
}
