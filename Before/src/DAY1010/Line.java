package DAY1010;

public class Line extends Shape implements Printing { //implements ������ > �������̽� ����Ҷ� Ŭ������ ����..>, ������ �ٸ� �������̽��� ������ ��� ���� ��
  //�ڹٴ� ���� ��ӿ��� ���� ��Ӹ� ����, ���� ��� �ȵ�.. �������̽� ����� ���߻�� ������
  //= Ŭ������ ���� ����� ���ϸ�..
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

// implements a Printing interface  �������̽� ����
   public void print() {
        System.out.println("Print something");
   }


}