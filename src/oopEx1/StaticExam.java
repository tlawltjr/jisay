package oopEx1;

public class StaticExam {

	
	
	static final int a;//공유 변수(상수) 선언..
	int b;//멤버필드
	
	static {
		a = 10;
		System.out.println("static 블락 호출됨..");
		System.out.println("static 의 값 : " + a);
	}
	
	
	
	void showB() {
		System.out.println("멤버필드 b 값 " + this.b);
	}
	
	static void showA() {
		
	}
	
	public static void main(String[] args) {
		//a = 10;
		
		showA();
		System.out.println("메인 메서드 호출됨..");

	}

}








