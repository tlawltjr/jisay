package basic;
/*
	 * 자바 메서드(method) : 자바를 포함 모든 객체지향 언어에는 메서드라는 이름의 기능을
	 * 정의 하고, 제공 하고 있습니다.
	 * 
	 * 메서드는 간단히 말하자면 자바스크립의 펑션, 우리가 어렸을때 배운 함수와 같은 개념입니다.
	 * 
	 * 어떤 로직이 반복적으로 필요할 경우 해당 로직을 분리해서 메서드로 정의 해놓으면
	 * 그 기능이 필요할 때마다 사용할 수 있기에 재활용 적인 면에서도 좋습니다.
	 * 
	 * 이렇듯 자바에서는 메서드와 필드를 떼놓고 말하기 어려울 정도로 많이 사용 되어지니깐,
	 * 이 시간에 꼭 알고 넘어갑시다.
	 * 
	 * 아래는 메서드 선언 syntax 입니다. [] 내의 키워드는 option 이라서, 선언해도 그만
	 * 안해도 그만입니다.
	 * 
	 * 앞으로 객체지향을 공부하기 전까지는, main() 에서 다른 메서드를 호출 하여 사용할텐데
	 * 그때 호출되어지는 메서드는 반드시 static 으로 정의 해야한다라고만 기억하세요.
	 * 
	 * 문법 : [public,protected,default,private] -- 4중의 하나, 만약 비선언시 
	 * 무조건 default 선언으로 간주됨.
	 * [static] : 클래스단의위 메서드인지의 여부 키워드..없으면 무조건 객체의 메서드로 선언한
	 * 것과 같음.
	 * return type : 정의한 메서드가 실행 중 또는 종료시에 넘겨줄 값이 존재한다면
	 * 해당 타입을 리턴으로 지정해야합니다. 만약 넘겨줄 것(return) 이 없을경우엔
	 * void 로 선언해야 합니다. 리턴타입에는 [] 를 쓰지 않았기 때문에 필수 입니다.
	 * 
	 * methodName : 리턴타입 바로 옆에는 반드시 메서드 명을 선언 하셔야 합니다.(이름 규칙은
	 * 변수와 같음..)..역시 필수입니다.
	 * 
	 * methodName([parameter1 ex)String p,parameter2...p(n)]) : 이름옆의 괄호는 
	 * 메서드가 정의될 때 어떤 파라미터 값이 필요가 없을땐
	 * 그냥 괄호만, 만약 필요시엔 해당 값의 타입과, 그 값을 local 에서 사용시 사용될 변수명
	 * 을 넣어줍니다. 이렇게 선언된 변수명은 해다 메서드의 지역 변수로 활용 되어집니다.
	 * 
	 * 
	 * 메서드 body {} : 메서드이름(){메서드바디} 좌에서 보듯이 일반적인 메서드 정의 형식입니다.
	 * 메서드 바디에는 해당 메서드가 어떤 로직을 구현 할 지에 대한 상세 로직을 구현하는 부분입니다.
	 * 나중에 배우겠지만, 상속시 필요에 따라서 바디가 없는 선언부만 갖을수도 있습니다.(일단 지금은
	 * 기본적으로 {} 바디를 정의해야 한다라고 생각하세요.
	 * 
	 * 바디{} 내의 return : 만약 메서드가 수행 중간 또는 후에 뭔가를 되돌려줄(return) 의도가 
	 * 있다면, return 키워드를 이용, 메서드의 선언시 선언된 리턴 타입과 같거나, 큰 타입으로
	 * 리턴 시키면 됩니다. 로직 중간에 return 이 호출되면 해당 메서드는 그 시점에 종료가 되어집니다
	 * 만약, void 타입의 메서드에서 return 을 사용하게 되면 명시적으로 해당 시점에
	 * 그 메서드의 수행을 멈추겠다는 의미 입니다.
	 * 
	 * 
	 * 총론 : 위의 내용을 종합하여 메서드를 정의한 예는 아래와 같습니다.
	 * [public] [static] (ptype or rtype) or void doSome([p1,p2..]){
	 * 
	 * 		로직 구현...
	 * 		[return] 
	 * } 
	 */
public class MethodExam1 {
	//두개의 int type 정수를 입력 받아서 누가 더 큰 값인지를 리턴하는 메서드를 정의해봅니다.
	
	static int max(int x, int y){
		if(x > y) 
			return x;
		return y;
	}
	
	
	static String[] doSome() {
		return new String[] {"",""};
	}
	public static void main(String[] args) {
		//int whichMax = max(10, 11); //11
		System.out.println("두 수중 : " + max(10, 11) + " 이 더 큽니다.");
		
		boolean is =String.valueOf(true).concat("h").contains("s");
	}
	//메서드 시그니쳐(method signature) : 
	//동일명으로 정의한 메서드가 컴파일러가 컴파일시 중복 정의 여부를 판별하는 요소
	//파라미터의 갯수, 타입, 순서 모두가 같은 경우 같은 메서드로 인식하여 컴파일 에러
	//발생됨.
	
	//여러분이 메서드를 같은 이름으로 목적은 같지만 디테일이 조금씩 틀린경우
	//정의 하였을때, 컴파일러(VM)는 호출하는 메서드의 시그니쳐를 기준으로 해당 메서드를 
	//호출하게 됩니다. 해서 아래처럼 동일명으로 시그니쳐만 틀리게 정의한것을
	//메서드를 오버로딩(overloading) 했다라고 합니다.
	
	//이번에도 출력 메서드를 정의 하는데, 파라미터 순서만 바꿔봅니다.
	static void print(int count, String msg) {
		for(int i = 0; i<count; i++) {
			System.out.println(msg + " 출력됨");
		}
	}
	
	
	static void print(String msg, int count) {
		for(int i = 0; i<count; i++) {
			System.out.println(msg + " 출력됨");
		}
	}
	//출력내용을 받아서 출력하는 메서드 정의 합니다.
	static void print(String msg) {
		System.out.println(msg + " 출력됨");
		System.out.println(msg + " 출력됨");
		System.out.println(msg + " 출력됨");
		System.out.println(msg + " 출력됨");
		System.out.println(msg + " 출력됨");
		
	}
	//출력을 하는 메서드 정의 해봅니다.리턴타입은 void 로 합니다.
	static void print() {
		System.out.println("출력됨");
		System.out.println("출력됨");
		System.out.println("출력됨");
		System.out.println("출력됨");
		System.out.println("출력됨");
	}
	

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

