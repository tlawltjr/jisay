package langEx;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class StringExam {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//"" 을 이용해서 생성된 문자열은 모두 String pool 에저장되고
		//새로운 리터럴을 생성할시엔, 먼저 pool 내에 같은 값이 있는 객체가 존재하는지
		//만약 있다면 해당 Ref 를 리턴합니다. 이 조건은 오직 ""(리터럴) String 객체에만
		//적용됩니다.
		
		String a = "abc";
		String b = "abC";
		
		String c = new String();
		String d = new String(b);
		
		if(d == b) {
			System.out.println("같은 객체니 값도 당연히 같음"); //1
		}else {
			System.out.println("틀린 객체이고, 값이 같은지는 모르겠음.");//2
		}
		//String 의 override 된 equals 사용. 두 문자열 객체가 같은 값이면
		//true 아님 false 리턴.
		if(d.equalsIgnoreCase(b)) {
			System.out.println("다른 문자열객체지만 대소문자 구분없이 값은 같음");
		}else {
			System.out.println("다른 문자열객체며 값도 틀림");
		}
		
		
		byte[] bArr = {65,66,67,68,69};
		bArr = "안녕하세요.".getBytes();
		//앞으로 배열내부의 값을 문자열로 확인 하고 싶으면 아래의 API 이용하세요
		System.out.println(Arrays.toString(bArr));
		
		
		String bStr = new String(bArr,2,6);
		System.out.println(bStr);

		
		Charset charset= Charset.defaultCharset();
		System.out.println(Charset.availableCharsets());
		
		
		char[] chArr = {'오','늘','하','루','고','생','함'};
		String chStr = new String(chArr);
		System.out.println(chStr);
		
		char[] uniCodes = chStr.toCharArray();
		int[] converUni = new int[uniCodes.length];
		for(int i = 0; i<uniCodes.length; i++) {
			converUni[i] = uniCodes[i];
		}
		System.out.println(Arrays.toString(converUni));
		
		String uniStr = new String(converUni,0,converUni.length);
		System.out.println(uniStr);
		
		
		
		
		
		
		
		/*
		 * 아래의 퀴즈를 풀어보세요.
		 * 
		 * String myMsg = "오늘의 자바는 문자열 객체 까지 했습니다";
		 * 
		 * 위 myMsg 를 byte[] 배열로 리턴하는 메서드가 있습니다. 리턴 타입이 byte[] 임
		 * 
		 * 얘를 호출해서 바이트 배열로 변환후, 배열의 모든 값을 다시 새로운
		 * 문자열로 생성하는데, 단, 문자열의 캐릭터셋을 ISO8859 1 로 되어진 애로 변환해서
		 * 출력해보세요.
		 */
		
		byte[] bt = "오늘의 자바는 문자열 객체 까지 했습니다".getBytes();
		//String btStr = new String(bt, 0, bt.length, "ISO-8859-1");
		String btStr = new String(bt, 0, bt.length);
		System.out.println(btStr);
		
		
		System.out.println(btStr.length());
		//btStr 의 전체를 돌면서 문자(char) 를 리턴받는다.
		
		for(int i=0; i<btStr.length(); i++) {
			char ch = btStr.charAt(i);
			System.out.print(ch);
		}
		
		//System.out.println(btStr.charAt(btStr.length()));
		
		System.out.println();
		System.out.println(Integer.toHexString(btStr.codePointAt(0)));
		
		char uniCar = '\uc624';
		System.out.println(uniCar);
		
		
		String msg = "오늘";
		String msg2 = msg.concat("하루도 즐겁게");
		System.out.println(msg);
		
		
		
		System.out.println(msg2.contains("즐겁게"));
		
		
		String hi = String.copyValueOf(new char[] {'h','e','l','l','o'});//hello 값을 갖는 char 배열을
		//파라미터에 완성시켜보세요.
		
		
		//문자열의 끝과 처음 판별하기
		String email = "newno7134@hotmail.com";
		if(email.endsWith(".com") || email.endsWith("co.kr")) {
			System.out.println("올바른 서버명입니다.");
		}
		
		
		//format() : static 이면서, 문자열, 수치형등을 모두 특정 형식대로
		//포맷하여 설정 할 수 있습니다.
		/*
		 * 아래는 간단한 문법입니다.
		 * 
		 * %d(10진수 형식), %s(문자열 형식), %f(실수형), Locale(날짜등의 형식)
		 * 기본적으로 포맷을 적용하면 우측 정렬이 적용됩니다. 만약 -표시를 하게 되면
		 * 왼쪽 정렬을 하게 됩니다.
		 */
		
		int i = 23;
		
		System.out.println(String.format("%d", i));
		System.out.println(String.format("%d_", i));
		System.out.println(String.format("%5d_", i));
		System.out.println(String.format("%-5d_", i));
		System.out.println(String.format("%05d_", i));
		
		
		//십진수 정수의 큰 값을 특정 포맷대로 출력시켜보기..
		int  i2 = 123456789;
		//%뒤에 , 를 주면 자동으로 3자리 마다 , 를 넣어줍니다.
		System.out.println(String.format("%,d", i2));
		System.out.println(String.format("%,015d", i2));
		
		//문자열 표시하기..
		String str = "hello";
		System.out.println(String.format("%-12.2s_", str));
		
		
		//실수형 표기 하기.. 키워드 f
		double n = 123.45678;
		System.out.println(String.format("%f", 3.4));
		System.out.println(String.format("%f", n));
		System.out.println(String.format("%.2f", n));
		
		
		System.out.println(email);
		
		
		//이메일에 @ 여부 판단하기..indexOf(char ch)
		int idx = email.indexOf('n',email.indexOf('n') + 1);
		
		System.out.println(idx);
		
		if("".isEmpty()) {
			System.out.println("문자열의 값이 없습니다.");
		}
		
		//delimeter 는 문자열의 구분자를 뜻합니다. ",/"
		String deliStr ="HelloMyFriend";
		deliStr = String.join(":", "Hello","Java","World");
		System.out.println(deliStr);
		
		System.out.println(email.lastIndexOf('.'));
		
		//email = email.replace('@', 'a');
		System.out.println(email);
		
		//여러분의 이메일의 서버명, green.com 으로 변경해보세요
		
		String server = email.substring(email.indexOf('@') + 1);
		String id = email.substring(0, email.indexOf('@')+1);
		String newServer = server.replace(server, "green.com");
		
		String newEmail = id.concat(newServer);
		System.out.println(newEmail);
		
		
		String wSpace = "  h  ";
		System.out.println(wSpace.trim().length());
		
		int aa = 11;
		
		String aaStr = String.valueOf(aa);
		System.out.println(aaStr + 1);
		
		/*
		 * 사용자의 이메일을 입력 받아서 아래의조건에 맞게 출력해보세요
		 * 1. ID(Email) 입력하세요 
		 * 2. 입력 후 빈 문자열인지 검사 하세요.
		 * 3. 빈 문자열이 아닌경우 아래처럼 검사하세요
		 * 3_1 ID 와 서버로 분리하여 ID 를 검증(idValidate())하시는데
		 * 길이는 8 ~ 12 자 사이여야 하고, 반드시 첫자는 대문자 여야 합니다.
		 * 또한 ID 중에는 반드시 숫자가 하나 이상 이어야 합니다.
		 * 만약 위의 조건이 틀린경우, 뭐가 틀렸는지 메세지를 띄우고, 모두 정상이면
		 * 사용자에게 로그인 되었습니다 라고 출력시키세요.
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
