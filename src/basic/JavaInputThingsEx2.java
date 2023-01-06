package basic;
import java.io.IOException;
import java.util.Scanner;


public class JavaInputThingsEx2 {

	//스케너 객체를 클래스 변수로 초기화 함..
	//이렇게하면 이 클래스 내부에 있는 모든 메서드가 참조(ref) 가능합니다.
	static Scanner sc = new Scanner(System.in);  
	
	public static void main(String[] args) throws IOException {
		System.out.println("메세지 입력 하세요.");
		//콘솔에 입력한 값을 문자열로 return 시키는 메서드 이용합니다.
		String value1 = sc.nextLine();
		System.out.println(value1);
		int fir = sc.nextInt();
		System.out.println(fir + 1);
	}
	static void doSome() {
		sc.nextLine();
	}

}










