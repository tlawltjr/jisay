package utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * Set 타입 : Set 타입은 Collection 의 자식타입으로 기본적으로는 List 와 메서드가
 * 동일한게 많음.. 특징으론 중복을 허용 하지 않는게 있고, 또하난, 검색 기능을 추가한 형태의
 * API 들이 Set 타입에 있습니다. 또한 정렬 기능을 적용한 TreeSet 등도 있습니다.
 * 먼저 간단한 API 사용법 부터 확인 합니다.
 * HashSet 은 대표적 클래스로 일반적인 Set 을 구현할때 사용하는 클래스 입니다
 */
public class SetExeam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("1");
		set.add("5");
		
		System.out.println(set);
		
		
		//lotto 생성기 만들어봅니다.
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for(int i =0; set2.size() < 6; i++) {
			
			int num = (int)(Math.random() * 45) + 1;
			set2.add(num);
		}
		
		System.out.println(set2);
		
		//API 보고 위의 Set 을 List Type 으로 요소를 가진 애들로 변경하고
		//Collections 클래스에 보면 List 파라미터로 받아서 정렬을 해주는 메서드가 있습니다.
		//그걸 이용해서 위 생성된 로또 번호를 정렬후 출력해보세요
		
		List<Integer> list = new LinkedList<Integer>(set2);
		
		Collections.sort(list);
		
		System.out.println(list);
		
		
		
		
		
		
		
	}

}
