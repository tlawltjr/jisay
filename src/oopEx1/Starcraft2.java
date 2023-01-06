package oopEx1;

import java.lang.*;

import oopEx1.TerranSteamPack.SteamPack;

/*
 * 인터페이스의 강의 파일입니다.
 */
public class Starcraft2 extends Object{

	Object obj;
	public static void main(String[] args) {
		
		Object ojb = new StarCraft();
		
		new Starcraft2().obj = new Object();
		Terran marine = new Marine("Jason", "이병", 60, 60);
		Terran firebet = new FireBet("불쏘시게", "상병", 40, 70);
		Terran medic = new Medic("쥴리아", "하사", 50, 0);
		
		//모든 공격 유닛에게 공격 명령을 내립니다.
		((Attackable)marine).attack("저그");
		((Attackable)firebet).attack("저그");
		
		((Moveable) marine).move(100,100);
		
		 TerranSteamPack.SteamPack steamPack = new SteamPack(marine); 
		 TerranSteamPack.SteamPack steamPack2 = new SteamPack(firebet); 
		 
		 steamPack.steamPack();
		 steamPack2.steamPack();
		
		 //Ghost 유닛을 만든후, 좌표 550, 350 지점에 핵폭탄을 유도해 보세요
		Ghost ghost = new Ghost("유령", "대위", 30, 20);
		ghost.nuclearLaunch(550, 350);
	
		/*
		StrarUnitsProp.StreamPack steamPack = new StreamPack(marine);
		steamPack.useSteamPack();
		*/

		
	}

}
