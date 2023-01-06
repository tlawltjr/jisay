package langEx.nestcls;
/*
 * 중첩클래스(Nested Class) : 자바에서는 4대 중첩 클래스가 존재합니다.
 * 멤버중첩, 정적(static) 중첩, 지역 중첩, 익명 중첩
 * 
 * 이렇게 중첩클래스 OR 중첩인터페이스를 두는 이유는 특정 클래스가 외부에 노출되어
 * 어떤 일을 하기보다는, 특정 클래스에서만 사용되어야 하고, 또한 코드의 복잡성을 내부에 감추어서
 * 사용하기 편하도록 하는데 있습니다.
 * 
 * 1. 멤버중첩클래스 : 이 클래스는 위치가 내부 클래스의 멤버 필드 위치로 선언되어있는 형태입니다.
 * 사용목적으론 외부 클래스의 인스턴스 멤버처럼 활용하는데 있고, 주로 외부 클래스의 멤버들과 관련해서
 * 작업을 하는데 사용됩니다.
 */
class InnerEx1{

	
	int a = 10;
	private int b = 100;
	static int c = 300;
	
	private int getA() {
		return a;
	}
	
	//Inner1_1 myIn = new Inner1_1();
	
//	public InnerEx1() {
//		myIn = new Inner1_1();
//	}
	//중첩 클래스 정의합니다.
	//정의 위치가 멤버들(메서드 or 필드)가 같은 위치에 있기에, 멤버 중첩클래스 라고 합니다.
	class Inner1_1{
		
		//Inner 클래스에서도 생성자, 필드, 메서드 모두 선언 및 정의 가능함.
		int d = 400;
		
		//non static inner 에선 static 필드 선언 불가함..
		//단 jdk 17 이상부터는 가능함.
		//static int e = 500;
		//하지만 상수로서는 가능하다.
		static final int e = 500;
		
		public void printData() {
			//inner 의 메서드는 outer 의 private 도 마음껏 접근 가능하다.
			System.out.println("int a = " + a);
			System.out.println(getA());
			System.out.println("int b = " + b);
			System.out.println("int c = " + c);
			System.out.println("int d = " + d);
			System.out.println("int e = " + e);
			
		}
		
	}
	
	
}

public class Inner1Ex {

	public static void main(String[] args) {
		//Inner 클래스의 인스턴스를 생성시엔 Outer.Inner 타입으로 생성해야합니다.
		//꼭 기억하세요.
		InnerEx1.Inner1_1 inner = new InnerEx1().new Inner1_1();
		
		
		//아래는 위의 생성코드를 풀어서 한예입니다.
		InnerEx1 outer = new InnerEx1();
		InnerEx1.Inner1_1 inner2 = outer.new Inner1_1(); 
		inner2.printData();
		
		
		
		

	}

}
