package DAY1010;

abstract class Shape { //베이스, 부모클래스임.추상화클래스이므로 new선언 불가능
    //추상화 함수가 하나만 있어도 클래스는 abstract, 객체화 되지 않는다.  new 선언 불가능 ..
    //공통적인 분모를 만들고 싶을때, move: 옮긴다는 원리는 같지만 점 선 면을 각각 옮기는 방법, 구현하는 방법은 다름
    //추상함수가 없어도 abstract class만들수있음. >> 저 클래스의 객체를 직접 만드는것을 허용하지 않을때.. 이 객체타입을 쓰려면 상속을 받아서 사용하게 함.

    private int borderColor;
    private int borderWidth;
    private int fillColor;
    //color라는 공통된 객체를 가지고있다,?
    //인터페이스는 가상함수로만 이루어져있음.

    public static void test() {
    	
    }
    
    public void draw() {
        System.out.println("Draw shape");
        //구현체가 있음 {}
        //draw도 원래는 abstract지만 각각 다르게 출력 된다는걸 보여주기 위해.....?
    }

    public abstract void move(int x, int y);
    //구현은 하지 않고 선언만 함.  << 이렇게 함수의 선언만 모아놓은것이 인터페이스
    //함수앞에 abstract붙으면 추상화 함수를 만든다.
    //abstract를 꼭 붙여야함. 가상화 테이블 ....????
    public abstract void rotate(int radian);


    public final int getFillColor() {
       //final붙으면 , 오버라이딩 안됨.상수함수와 같음.재정의 못함..
       //구현 상속됨
        return fillColor;
    }
    public final void setFillColor(int color) {
        this.fillColor = color;
    }


    public final int getBorderColor() {
        return borderColor;
    }
    public final void setBorderColor(int color) {
        this.borderColor = color;
    }


    //getter of borderwidth
    public final int getBorderWidth() {
        return borderWidth;
    }
    //setter of borderwidth
    public final void setBorderWidth(int width) {
        this.borderWidth = width;
    }
}
//final이 붙으면 이 두 함수는 재정의할수없다
                                        