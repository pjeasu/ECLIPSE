package DAY1014.review;

//
////������
//
//	//�������� �������� �ƴ� Ÿ���� �������ٶ�, ��ȯ�� �ʿ䰡 ������ ���� ��� �ΰ��� ���, gender�� string, color�� int�� ���. 
//	enum Gender {
//		FEMALE("Female"),
//		MALE("Male");
//		
//		private String value;
//		private Gender(String value) {
//			this.value = value; //this�� �� ����ϴ� ��� : ���ú����� ��������� �̸��� ����, this�� ���� value�� ��������� ����.  
//			//������ ����������ٽ����� �켱�̱⶧����, this�� �Ἥ ��������� ����
//		}
//		
//		public String value() {
//			return this.value; //�� ���� this�� �� �ʿ��Ѱ� �ƴ�
//		}
//	}
//
//
//	enum Color {
//			RED(0xff0000),
//			GREAN(0x00ff00),
//			BLUE(0x0000ff);
//			
//			private int value;
//		
//			private Color(int value) { //������, new�Ҽ����� �Ϸ��� public �̾����. 
//				this.value = value;//color��� �������� �������� ��������
//				
//			}
//			
//			public int value() {//����Լ� ���� ���� ������ �ٷ�������
//				return this.value;
//			}
//		};
//		
//		
//		
//	
//		
//
//	abstract class Shape {
//		//Ŭ����(����) ������
//		private static final int RED = 0;
//		private static final int GREEN = 1;
//		private static final int BLUE = 2;
//	
//	    
//	
//		
//	    private int borderColor;
//	    private int borderWidth;
//	    private Color fillColor; // �̸� �����Ǿ��ִ� ���߿� ����� red green blue.. ���� ������  ���� enum Color�� ���ѵǾ����� 
//	 
//
//	    public Shape() {
//	    	//this.fillColor = new Color(0xff0000); << new�� �� �� ����. private�� �Ұ���..?
//	    	this.fillColor = Color.GREAN; 
//	    	int value = Color.RED.value(); //�������� �������¹��
//	    }
//	    
//	    
//	    
//	    
//	    public void draw() {
//	        System.out.println("Draw shape");
//	    }
//
//	    public abstract void move(int x, int y);
//
//	    public abstract void rotate(int radian);
//
//	    public final int getFillColor() {
//	        return fillColor;
//	    }
//
//	    public final void setFillColor(int color) {
//	        this.fillColor = color;
//	    }
//
//	    public final int getBorderColor() {
//	        return borderColor;
//	    }
//
//	    public final void setBorderColor(int color) {
//	        this.borderColor = color;
//	    }
//
//	    // getter of borderWidth
//	    public final int getBorderWidth() {
//	        return borderWidth;
//	    }
//
//	    // setter of borderWidth
//	    public final void setBorderWidth(int width) {
//	        this.borderWidth = width;
//	    }
//
//}
