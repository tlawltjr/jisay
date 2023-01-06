package langEx;

public class StringBuilerEx {

	public static void main(String[] args) {
	
		StringBuilder sb = new StringBuilder("Hello");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb = sb.append(new String(" Java World...졸려도 일어나세요!!")
				.toCharArray());
		System.out.println(sb.capacity());
		System.out.println(sb.delete(0, 5));
		sb.ensureCapacity(200);
		System.out.println(sb.capacity());
		
		System.out.println(sb);
		
		char[] addMsg = "기지개좀 켜고".toCharArray();
		
		//18 번 index
		
		//sb 결과 내용에 insert 를 이용해서 위 addMsg 를 일어나세요 앞에 추가해보세요
		sb.insert(sb.indexOf("일어"), addMsg);
		System.out.println(sb);
		
		sb.setCharAt(0, 'k');
		System.out.println(sb);
		
		//sb 객체를 그대로 String 객체로 변환 해보세요.
		
		
		
		
		
		
		
		
		

	}

}
