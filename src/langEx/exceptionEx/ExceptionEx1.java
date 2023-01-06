package langEx.exceptionEx;

import javax.swing.JOptionPane;

/*
 * 예외를 일부러 발생시켜서, 예외 객체자 JVM 에서 던져지는(throw) 걸 확인하고
 * 예외 타입을 알아봅니다, 또한 콜 스택에서 예외가 어떻게 전파 되어지는지도 확인합니다
 * 
 * 예외의 최고 대빵 클래스는 Exception 이고 이 클래스는 부모(Throable) 로부터 모든걸 상속
 * 받고 있습니다. 해서 최고 클래스를 Exception 으로 생각하시면 됩니다.
 * 
 * 또 Exception 하위에는 각 예외내용별로 클래스가 정의 되어있는데, 이중 RuntimeException
 * 을 기준으로 구분해야 합니다. 이 말은 RuntimeException 은 실행 예외를 정의한 클래스로
 * 하위에 있는 모든 예외는 실행이 되어야만 발생할 수 있는 예외 입니다. 즉 컴파일러가 알수 없다는 말
 * 입니다. 해서 위 예외의 하위 타입들은 컴파일시에 여러분이 예외 핸들링을 하지 않아도 컴파일러가
 * 관여하지 않습니다. 하지만 위 예외와 같은 계층이거나 상위에 있는 예외들은 알려진예외로 컴파일러가
 * 관여를 하기에 여러분이 이런 API 를 사용할때는 예외를 핸들링(try~catch), 전파선언(throws),
 * 중 하나를 하지 않으면 컴파일 에러가 발생합니다.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class ExceptionEx1 {

	static void c() {
		String input = JOptionPane.showInputDialog("나눌 숫자값입력");

		int d = 3;

		try {// 예외 핸들링
			System.out.println(3 / Integer.parseInt(input));

			System.out.println("여기 try 구문의 예외 발생후에 코드입니다.");
		} catch (Exception ae) {
			System.out.println("계산사의 예외 발생함..");
			System.out.println("원인 : " + ae.getMessage());
			System.out.println("0 으로 나눌수 없습니다.");
		}

		System.out.println("여긴 예외절 이후의 c() 의 나머지 구문.");

	}

	static void b() {
		c();
	}

	public static void main(String[] args) {
		b();
	}

}
