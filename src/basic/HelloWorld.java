package basic;

public class HelloWorld {
	//자바 Application(모바일이나, 웹이아닌 일반PC에서 실행되는 App) 
	//은 몇천개의 클래스가 구성되어 하나의 프로그램으로 완성되어집니다.
	//위에서 완성된 App 이 실행이 될 때 JVM 은 반드시 찾게되는 메서드가 있습니다.
	//즉 프로그램이 시작되는 시작점을 말합니다.
	//이 메서드를 main 메서드라고 합니다.
	//main 메서드는 이렇게 중요한 의미를 가지고 있기 때문에 이 메서드를 보유한 클래스가
	//일반적으로 main 클래스가 됩니다.
	//이 메서드는 하나의 앱에서 하나의 클래스만 가질수 있습니다. 즉 시작점이 하나란 말입니다.
	//따라서 main() 는 반드시 아래와 같은 정의만 가능합니다.
	
	public static void main(String[] bbb) {
		
		//자바스크립트의 write() 와 같은 기능을 가진 메서드가 있습니다.
		//System.out.println("값" or 변수);
		//자바는 스크립트와 달리 반드시 명령, 선언, 대입 등 모든 실행문의 끝엔
		//" ; " 을 넣어야 합니다. 반드시!!!!!!!
		
		String myName = "노재현";
		
		System.out.println("Hello " + myName + "님!!");
	}
	
	
	
}
