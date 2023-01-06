package oopEx1;

public class UseStatic {

	public static void main(String[] args) {
		//static 으로 선언된 필드,메서드 호출 방법..
		StaticExam.showA();
		new StaticExam().showB();
		new StaticExam().showA();
		
		
		
	}

}
