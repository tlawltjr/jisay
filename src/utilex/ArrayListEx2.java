package utilex;

import java.util.ArrayList;

import oopEx1.FireBet;
import oopEx1.Ghost;
import oopEx1.Marine;
import oopEx1.Medic;

public class ArrayListEx2 {

	public static void main(String[] args) {
		//Collection 의 Generic
		/*
		 * Generic 이란 jdk 1.5 부터 지원하는 개념입니다.
		 * Collection 의 요소로 Object 로 기본적으로 채웠을때, 채우기는 쉬우나
		 * 만약 다른 객체들이 추출되어진다면, 각 객체의 특정 메서드 등을 호출할때 문제가 발생합니다.
		 * 때문에 instanceof 를 이용 객체의 타입을 일일이 비교하여 호출 하는 방법밖엔
		 * 없게 됩니다.
		 * 
		 * 해서 Generic 이라는 개념을 도입하여, Element 요소를 한정하도록 하는게 목적입니다.
		 * 문법은 <Element Type> 을 선언하면 됩니다. 이때 추가되는 모든 요소는 반드시
		 * <Element Type> 이어야만 합니다.
		 */
		
		Marine marine = new Marine(null, null, 0, 0);
		Medic medic = new Medic(null, null, 0, 0);
		FireBet firebet = new FireBet(null, null, 0, 0);
		Ghost ghost = new Ghost(null, null, 0, 0);
		
		ArrayList terran = new ArrayList();
		terran.add(marine);
		terran.add(medic);
		terran.add(firebet);
		terran.add(ghost);
		
//		for(int i = 0; i<terran.size(); i++) {
//			Medic m = (Medic)terran.get(i);
//		}

		
				
				
				
				
				
				

	}

}
