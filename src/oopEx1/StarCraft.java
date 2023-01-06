package oopEx1;

public class StarCraft {

	Terran t;
	Marine m;
	Medic md;
	Ghost gh;
	FireBet fb;
	
	public StarCraft() {
		Marine m1 = new Marine(); 
		Marine m2 = new Marine(); 
		Marine m3 = new Marine(); 
		Marine m4 = new Marine(); 
		Marine m5 = new Marine(); 
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		StarCraft star = new StarCraft();
		
		
		
		Terran marine = new Marine("Jason", "이병", 60, 60);
		Terran firebet = new FireBet("불쏘시게", "상병", 40, 70);
		Terran medic = new Medic("쥴리아", "하사", 50, 0);
		
		marine.sound();
		firebet.sound();
		medic.sound();
		
		((Marine)marine).move(100,100);
		
		
		
		//타입변경을 해봅니다. 즉, 마린인스턴스이 Ref 타입을 원형으로 변경해봅니다.
//		Marine ma  =(Marine)marine;
//		Object obj = ma;
//		ma =(Marine) obj;
//		medic = (Medic)obj;
		
		
		Marine m1 = new Marine("Jason","이등병",40,60);//Instance 화 하는 단계 즉,
		FireBet f1 = new FireBet("불추장", "상병", 60, 80);
		Medic md1 = new Medic("간호사","하사",60,0);
		
//		System.out.println(m1.toString());
//		System.out.println(f1.toString());
//		System.out.println(md1.toString());
		
//		m1.sound();
//		f1.sound();
//		md1.sound();
//		
		//md1.healing("마린");
		
		
		Terran[] allUnit = {m1,f1,md1};
		for(int i = 0; i<allUnit.length; i++) {
			Terran theUnit = allUnit[(int)(Math.random() * allUnit.length)];
			//모든 유닛들의 sound()를 호출해보세요.
			theUnit.sound();
			
			//만약 리턴되는 인스턴스가 메딕이라면, "마린" 을 치료토록 해보세요..
			//즉 healing("마린") 을 호출하세요.
			
//			if(theUnit instanceof Medic) {
//				((Medic) theUnit).healing("마린");
//			}
			
			if(theUnit instanceof Marine)
				((Marine)theUnit).move(300,300);
			else if(theUnit instanceof FireBet) {
				((FireBet)theUnit).move(300,300);
			}else {
				Medic m = (Medic)theUnit;
				m.move(300,300);
				m.healing("마린");
			}
		}
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
