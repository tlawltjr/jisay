package basic;

public class TypeCasingEx {

	public static void main(String[] args) {
		//타입 프로모션 : 작은 타입을 큰 타입에 대입하는 형태..무조건 된다.
		//타입 케스팅(Casting) : 큰 타입을 작은 타입에 대입할 때 사용되는 연산자를
		//이용해서 대입하는 형태를 말한다.
		
		byte b = 1; short s; int i; long lo;
		float f; double d;
		//타입 프로모션..
		s = b;
		i = s;
		lo = i;
		f = lo;
		d = f;
		//케스팅 연산자는 연산자 우선순위의 1순위중 ., [], () 다음이다.
		f =(float)d;
		lo = (long)f;
		i = (int)lo;
		s = (short)i;
		b = (byte)s;
		
		d = 3.14;
		//위 d 를 int i2 에 값을 넣고 결과를 출력하라.
		
		System.out.println(Integer.toBinaryString(-128));
		System.out.println("10000000".length());
		
		
		
		b = (byte)128;
		System.out.println(b);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
