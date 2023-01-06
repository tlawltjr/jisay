package oopEx1;

public interface GhostAbility extends Moveable, Attackable {

	//유령 : 자신의 몸체를 invisible 시킨후에 레이져로 유도해서 몰래 적진에
	//핵 폭탄을 유도하는 기능을 가지고 있는 unit
	
	void nuclearLaunch(int x, int y);
}
