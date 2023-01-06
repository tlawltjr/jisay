package langEx.nestcls;

/*
 * Local Inner(지역 중첩 클래스) : 이 클래스는 특정 메서드에 종속되어진 클래스입니다.
 * 구현하는 목적은 특정 메서드를 호출 할 때 해당 내용부가 특정 클래스에 정의된 내용 결과를 리턴하도록
 * 정의 하는데 있습니다. 
 * 주의 해야 할 점은 이 로컬 클래스는 메서드에서만 존재하기 때문에 메서드가 실행이 되지않을경우엔
 * 존재 자체가 없습니다, 반대로 메서드가 실행이 끝나 경우에도 존재가 사라집니다.
 * 즉 외부에는 절대 노출이 안된다는 뜻입니다.
 * 
 * 이 로컬 클래스는 JDK 버전 없이 되기전에는 상수(final) 만 가질수 있었는데, 아마 15? 이상부터는
 * 상수 아니어도 지역 변수를 가질수있게 되었습니다. 어려우면 상수만 가질수 있다라고 생각하세요.
 * 
 * 이 메서드는 앞에서처럼 메서드 외부에 있는 다른 필드등(Inner 클래스 포함) 에 모두 접근 가능합니다.
 */
public class LocalInner {
	
	int k = 1;
	
	class InstanceInner{//멤버inner 클래스 정의
		int a = 100;
	}
	static class StaticInner{
		int b = 200;
		static int c= 300;
	}
	
	void yourMethod(int gg) {
		/*
		 * 로컬inner 클래스에서 접근 가능한 지역 변수는 반드시 final 이어야합니다.
		 * 단 jdk 10x 버전 이후부터는 이 제한이 풀어졌습니다.
		 */
		int localVar = 100;
		//여기에 지역 Inner 클래스 정의 예정입니다.
		class LocalInner1{
			int d = 400;
			InstanceInner in = new InstanceInner();
			int k = gg + 10 + localVar;
			
			//클래스이기 때문에 메서드도 정의 가능함..
			//해당 메서드에서는 outer 의 멤버들도 참조 가능함.
			void doSome() {
				int r = k + d + StaticInner.c + localVar + gg;
				System.out.println(r);
			}
			
		}//local class End
		new  LocalInner1().doSome();
	}//method end
	
	public static void main(String[] args) {
		LocalInner outer = new LocalInner();
		//LocalInner 의 InnerInstance 타입의 instance 를 생성해보세요.
		LocalInner.InstanceInner in = outer.new InstanceInner();
		
		System.out.println(in.a);
		
		//지역Inner객체를 수행하도록 만듭니다.
		outer.yourMethod(10);
		
		

	}

}
