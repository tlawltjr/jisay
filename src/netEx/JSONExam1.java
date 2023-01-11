package netEx;

import java.io.FileWriter;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import org.json.JSONArray;
import org.json.JSONObject;

/*
 * JSON 데이터 형식 : JSON은 네트웤 상에서 데이터를 주고 받는 형식 중에 
 * 가장 유명하고 많이 쓰이는 형식이다
 * 형태는 Map과 유사하며, key:value 형태로 데이터를 저장 관리한다
 * 그런데, 이렇게 key:value로만 생성하면 데이터의 한계가 있기에
 * 여기에 객체와, 배열까지 추가하여 실질적으로 모든 데이터를 표기 가능한 형식이다
 * 
 * 형식1 : {} --> 중괄호는 JSON의 데이터 기본 형식 구문이다
 * 형식2 : 위 괄호 내에 다음처럼 key : value 를 추가하고 분류기호로는 ","
 * 2_1 : "속성명":속성값, "속성명":속성값
 * 2_2 : 2_1의 규칙 --> 속성명은 반드시 ""로 감싸야 한다.
 * 값으로 가능한것은 "문자열(반드시 더블 쿼트로)", number, boolean, 객체{}(내부적으로 
 * 값이 객체 형태인 것은 {}를 이용해서 정의해야함.[] --> 배열
 * 2_3 : 배열은 각각의 값을 ","로 구분하여 정의 할 수 있다
 * 값으로 가능한 타입은 "문자열",Number,boolean, {객체},[배열]
 * 
 * 참고로 객체를 사용해야 할 필요가 있는 경우는 아래와 같다
 * 예를 들어 이름 : 값은 1 key 에 1 value 가 일반적이지만,
 * 전화번호 tel같은 경우엔, 하나의 속성에 값으론 home_tel, cell_tell 등으로
 * 나뉘어 질 수 있다. 이때 객체를 이용한다
 * 
 * 배열은 알다시피 하나의 속성에 값이 다양할때 사용된다
 * 
 * 
 * 
 * https://github.com/stleary/JSON-java
 */
public class JSONExam1 {

	public static void main(String[] args) {
		//json객체생성
		JSONObject root = new JSONObject();
		//jsason 속성 주기
		root.put("id", "jason");
		root.put("name", "노재현");
		root.put("age", 30);
		root.put("isStu", false);
		//여기까지 일반 속성 준 것
		
		//이번엔 속성(tel)중에 전화 모든 전화번호를 담고싶은데, 집전화, 폰, 비상연락망
		//등으로 다시 속성들이 나열이 될 경우엔, 새로운 JSONObject를 생성해서 값을 추가
		JSONObject telNum = new JSONObject();
		telNum.put("home", 12345);
		telNum.put("Cell", 123456);
		telNum.put("Emergency", 1234567);
		
		//위에서 생성된 telNum 객체는 노재현에 관련된 정보이니 root에 다시 추가합니다
		root.put("telNum", telNum);
		
		//이번엔 취미를 추가합니다. hobby라는 속성엔 하나 이상의 값만이 존재하니
		//객체보다는 배열이 맞음 하지만 JSON에서도 배열도 객체로 표기해야하니
		//JSONArray 를 생성, put만 이용해서 값을 넣습니다
		JSONArray hobby = new JSONArray();
		hobby.put("스포츠");
		hobby.put("여행");
		hobby.put("프로그래밍");
		
		//hobby 또한 노재현에 관련된 객체 정보니까 다시 put합니다
		root.put("hobby", hobby);
		
		String objString = root.toString();
		
		System.out.println(objString);
		try {
		FileWriter fw = new FileWriter("info.json");
		fw.write(objString);
		
		fw.flush();
		fw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
