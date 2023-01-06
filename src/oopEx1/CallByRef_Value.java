package oopEx1;

import java.util.Arrays;

public class CallByRef_Value {

	/*
	 * 지금 하는 내용은 정말 중요합니다.
	 * 객체의 참조(ref)를 이해한 분에겐 당연한 거지만,그렇지 않은 분들은 반드시
	 * 깨우치세요.
	 * 
	 * CallByValue 라는 개념은 메서드간의 call 시 파라미터를 Ptype 으로주고 받는경우에
	 * 일어납니다.
	 * 
	 * 이때는 전에 자바스크립트시간에 말했듯이 값을 보내기 전에 다른 메모리에 복사 후
	 * 복사된 메모리에서 값을 꺼내 전달하기 때문에 전달 받은 쪽에서 값을 변경해도
	 * 전달한 쪽의 값은 변함이 없습니다.
	 */
	
	static void callByValue(int a) {
		a = a + 10;
		System.out.println("파라미터로 전달 받은 a " + a);
	}
	static void callByRef(int[] arr) {
		arr[0] = 100;
		arr[1] = 200;
		arr[2] = 300;
		
		System.out.println("CallByRef 에서의 배열 값 : " + Arrays.toString(arr));
	}
	public static void main(String[] args) {
		//지역 변수 a 초기화
		int a = 1;
		//a값을 callByValue() 에게 전달 후 a 값 출력
		callByValue(a);
		System.out.println(a);
		
		int[] arr = {1,2,3,};
		System.out.println("CallByRef() 호출전 배열값 : " + Arrays.toString(arr));
		callByRef(arr);
		System.out.println("CallByRef() 호출후 배열값 : " + Arrays.toString(arr));
		
		
		

	}

}
