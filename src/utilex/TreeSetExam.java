package utilex;

import java.util.NavigableSet;
import java.util.TreeSet;

/*
 * 검색기능을 강화한 컬렉션...
 * 각 노드를 부모노드의 좌(작음)우(큼)에 배치를 시켜서 검색을 빠르게 하는 장점이있다.
 * 이 검색 기능을 이용하기 위해선 반드시 TreeSet 객체로 생성해야한다.
 * 이유는 검색 메서드는 TreeSet 에서만 정의 했기 때문이다.
 */
public class TreeSetExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Integer> scores = new TreeSet<Integer>();
		//참고로 중복값은 여전히 저장이 않됩니다.
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		scores.add((int)(Math.random() * 100) + 1);
		
		//저장된 Element 출력하기.
		//기본 정렬은 Ascending(오름차순) 으로 되어있음..
		for(Integer i : scores) {
			System.out.println(i + " ");
		}
		System.out.println("-----------------------------------");
		
		System.out.println("가장낮은 수 " + scores.first());
		
		System.out.println("50점 아래 : " + scores.lower(50));
		System.out.println("80점 다음 수 : " + scores.higher(80));
		System.out.println("점수 이거나 바로 아래 : " +scores.floor(80));
		System.out.println("점수 이거나 바로 위 : " +scores.ceiling(90));
		
		System.out.println("--------------------------------------");
		
		NavigableSet<Integer> descSco = scores.descendingSet();
		for(int i : descSco) {
			System.out.println(i);
		}
		System.out.println("------------------------------------");
		NavigableSet<Integer> rangeSet = descSco.tailSet(50, true);
		for(int i : rangeSet) {
			System.out.println(i);
		}
		System.out.println("------------------------------------");
		
		
		
		
		
		
		
		
		
		

	}

}
