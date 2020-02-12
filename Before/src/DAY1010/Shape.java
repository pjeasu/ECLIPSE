package DAY1010;

abstract class Shape { //���̽�, �θ�Ŭ������.�߻�ȭŬ�����̹Ƿ� new���� �Ұ���
    //�߻�ȭ �Լ��� �ϳ��� �־ Ŭ������ abstract, ��üȭ ���� �ʴ´�.  new ���� �Ұ��� ..
    //�������� �и� ����� ������, move: �ű�ٴ� ������ ������ �� �� ���� ���� �ű�� ���, �����ϴ� ����� �ٸ�
    //�߻��Լ��� ��� abstract class���������. >> �� Ŭ������ ��ü�� ���� ����°��� ������� ������.. �� ��üŸ���� ������ ����� �޾Ƽ� ����ϰ� ��.

    private int borderColor;
    private int borderWidth;
    private int fillColor;
    //color��� ����� ��ü�� �������ִ�,?
    //�������̽��� �����Լ��θ� �̷��������.

    public static void test() {
    	
    }
    
    public void draw() {
        System.out.println("Draw shape");
        //����ü�� ���� {}
        //draw�� ������ abstract���� ���� �ٸ��� ��� �ȴٴ°� �����ֱ� ����.....?
    }

    public abstract void move(int x, int y);
    //������ ���� �ʰ� ���� ��.  << �̷��� �Լ��� ���� ��Ƴ������� �������̽�
    //�Լ��տ� abstract������ �߻�ȭ �Լ��� �����.
    //abstract�� �� �ٿ�����. ����ȭ ���̺� ....????
    public abstract void rotate(int radian);


    public final int getFillColor() {
       //final������ , �������̵� �ȵ�.����Լ��� ����.������ ����..
       //���� ��ӵ�
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
//final�� ������ �� �� �Լ��� �������Ҽ�����
                                        