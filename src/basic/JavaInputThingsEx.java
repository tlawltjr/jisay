package basic;
import java.io.IOException;

public class JavaInputThingsEx {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("수나 문자 하나를 입력해보세요.");
		//아래는 콘솔을 이용해서 사용자가 입력한 값 "하나" 를  프로그램내부로 return 시키는
		//메서드 입니다.
		
		
		//첫수입력받기
		int fir = System.in.read()-48;
		//엔터를 처리하기 위한 코드입니다.
		System.in.read();
		System.in.read();
				
		//두번째수입력받기
		int sec = System.in.read()-48;
		//엔터를 처리하기 위한 코드입니다.
		System.in.read();
		System.in.read();
		
		//+ 입력받기
		char yon = (char)System.in.read();
		
		//결과 변수에 + 결과 담기
		int result = fir + sec;
		
		System.out.println(""+fir + yon + sec + " = " + result);
	}

}
