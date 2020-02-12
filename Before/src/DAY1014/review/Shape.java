package DAY1014.review;

//
////열거형
//
//	//열거형과 열거형이 아닌 타입을 연결해줄때, 변환할 필요가 있을때 쓰는 방법 두가지 경우, gender은 string, color는 int인 경우. 
//	enum Gender {
//		FEMALE("Female"),
//		MALE("Male");
//		
//		private String value;
//		private Gender(String value) {
//			this.value = value; //this를 꼭 써야하는 경우 : 로컬변수와 멤버변수의 이름이 같음, this가 붙은 value는 멤버변수를 말함.  
//			//로컬이 멤버변수보다스콥이 우선이기때문에, this를 써서 멤버변수에 접근
//		}
//		
//		public String value() {
//			return this.value; //이 경우는 this가 꼭 필요한건 아님
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
//			private Color(int value) { //생성자, new할수없음 하려면 public 이어야함. 
//				this.value = value;//color라는 열거형과 정수값을 연결해줌
//				
//			}
//			
//			public int value() {//멤버함수 실제 색은 정수로 다뤄져야함
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
//		//클래스(정적) 멤버상수
//		private static final int RED = 0;
//		private static final int GREEN = 1;
//		private static final int BLUE = 2;
//	
//	    
//	
//		
//	    private int borderColor;
//	    private int borderWidth;
//	    private Color fillColor; // 미리 지정되어있는 값중에 써야함 red green blue.. 값의 범위가  위의 enum Color로 제한되어있음 
//	 
//
//	    public Shape() {
//	    	//this.fillColor = new Color(0xff0000); << new를 할 수 없음. private라 불가능..?
//	    	this.fillColor = Color.GREAN; 
//	    	int value = Color.RED.value(); //정수값을 가져오는방법
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
