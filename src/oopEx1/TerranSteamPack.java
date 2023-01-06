package oopEx1;
/*
 * 테란을 위한 Streapack 기능을 선언합니다.
 **/
public interface TerranSteamPack {

	//인터페이스내부에는 목적에 따라서 클래스를 정의 할 수 있습니다.
	//이러한 클래스를 중첩(Nested) 클래스라고 하는데,
	//나중에 따로 다시 공부할 겁니다.(무쟈게 지겨움)...
	//여튼 지금은 inner Class 를 정의해서, 외부에서 해당 클래스를
	//객체화 하여 구현 할 수 있도록 할 예정입니다.
	
	//마린과 파이어벳과 스팀팩을 사용가능합니다.
	class SteamPack{
		//마린과, 파벳만 스팀팩 메서드를 쓸수 있습니다.
		Terran terran;
		public SteamPack(Terran theUnit) {
			if((theUnit instanceof Marine) || (theUnit instanceof FireBet))
				this.terran = theUnit;
		}
		public void steamPack() {
			System.out.println("스팀팩을 이용해서 공격합니다..체력 -10%, 공력은 +10%");
		}
	}
	
	
}
