package netEx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;

public class JSONParserEx {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader("info.json"));
		String json = br.readLine();
		br.close();
		
		//JSON 파싱
		JSONObject root = new JSONObject(json);
		System.out.println("id : " + root.getString("id"));
		System.out.println("name : " + root.getString("name"));
		System.out.println("학생여부 : " + (root.getBoolean("isStu") == false?"N":"Y"));
		System.out.println("나이 : " + root.getInt("age"));
		
		//객체 내부의 객체 얻어내기
		JSONObject tel = root.getJSONObject("telNum");
		System.out.println("\n" + "home : " + tel.getInt("home"));
		System.out.println(tel.getInt("Cell"));
		System.out.println(tel.getInt("Emergency"));
		
	}

}
