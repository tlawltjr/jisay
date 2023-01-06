package langEx.nestcls;
/*
 * 외부 클래스의 멤버필드 선언위치에 선언되며, 외부 클래스의 static 멤버처럼 호출 및 객체 생성가능함
 * 주로 외부 클래스의 static 멤버, 특히 static 메서드를 사용할 목적으로 주로 정의함
 * 만약 내부 클래스에서 static 필드(상수 아님) 을 선언해야 할 경우엔 무조건
 * static inner 클래스로 선언되어야 함.(JDK 17 이전 버전까지..)
 */
public class StaticInnerEx {
	
	int a = 10;
	private int b = 100;
	static int c = 200;
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	static int getC() {
		return c;
	}
	
	public static class StaticInner{
		
		int d= 300;
		static final int e = 400;
		static int f = 500;
		
		//static method 정의
		public static void printA() {
			//non static 필드 호출 불가..
			//System.out.println("a = " + a);
			System.out.println("c = " + c);
			//non static 메서드 호출 불가.
			//System.out.println("getB()" + getB());
			System.out.println("getC() " + getC());
			
		}
		
		public void printB() {
			//System.out.println("a = " + a);
			System.out.println("c = " + c);
			
			//System.out.println("getA() --> " + getA());
			System.out.println("getC() = " + getC());
			
			printA();
		}
		
	}
	public static void main(String[] args) {
		
		StaticInnerEx.StaticInner.printA();
		StaticInnerEx.StaticInner sInner = new StaticInner();
		sInner.printB();
		
	}

}
