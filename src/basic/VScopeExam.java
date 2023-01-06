package basic;

public class VScopeExam {

	//이렇게 클래스 or 멤버필드로 선언된 변수는 선언과 동시에 기본값으로 초기화 되어집니다.
	//즉 내가 따로 초기화 하지 않는 이상은 기본값으로 초기화 되어진다는 말입니다.
	//수치형은 0 or 0.0, boolean 은 false, 문자는 \u0000 으로 초기화 되어집니다.
	//Rtype 은 무조건 null 로 초기화 되어집니다.
    static int i;//클래스 변수 선언..
	static String myName;

	
	public static void main(String[] args) {
		//클래스 변수를 출력합니다.
		//기본적으로 지역변수는 초기화 되지 않은 상태에서 사용되면 에러인데,
		//클래스 변수는 선언후 클래스가 메모리에 로드되는 시점에 기본값으로 
		//초기화되어지기때문에 사용하는데 문제가 되질 않습니다.
		System.out.println(i);
		System.out.println(myName);
		
		
		
		
		//여기서는 자바에서 사용되는 변수의 scope 에 대해 알아봅니다.
		//기본적으로는 메서드내에서 선언된 변수는 로컬변수, 어떤 곳이던 {} 내에서 선언된
		//변수는 블락변수, 그리고 클래스에서 선언된 변수는 클래스 or 멤버필드로 지정되어집니다.
		//위, 클래스 or 멤버의 기준은 static 이라는 키워드가 좌우 합니다.
		//즉 static 이붙은 변수는 클래스 변수, none static 은 멤버필드(Instance 변수)
		//라 합니다.
		//위 클래스 or 멤버필드는 순선대로 클래스가 메모리에 남아있는동안 살아았고,
		//멤버는 객체가 몹쓸객체로 변이되기 전까지는 살아있습니다.
		//지역(local) 변수는 메서드의 body 가 끝나면 삭제되고, 블락은 블락이 실행후
		//삭제 됩니다.
		int i;//main() 에서 처음 선언 되었으므로 지역 변수입니다.
		i = 10;
		{
			int j = 2;//블락변수 선언
			int sum = i * j;//블락변수 선언..
			System.out.println(sum);
		}
		//블락 밖에서 블락 변수를 호출을 해서 아래는 컴파일 에러입니다.
		//System.out.println(i + " * " + j + " = " + sum);
		
	}
	
	/*
	static void doSome() {
		System.out.println(i);
	}
	*/

	
}








