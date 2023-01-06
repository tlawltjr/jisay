package oopEx1;

public class Ghost extends Terran implements GhostAbility{

	private String name;// 마린의 이름
	private String rank;// 계급
	private int hp;// 피통
	private int damage;

	public Ghost(String name, String rank, int hp, int damage) {
		super("고스트");
		this.name = name;
		this.rank = rank;
		this.hp = hp;
		this.damage = damage;
	}

	
	public void move(int x, int y) {
		System.out.println(this.name + " 이 " + "[" + x + "," + y + "]로 이동했습니다.");
	}
	
	@Override
	public void sound() {
		System.out.println("Ghost says : Theres No One here!");
	}

	// 치료받는 메서드 정의
	public void getHealing(int hp) throws InterruptedException {
		while (true) {
			if (this.hp == 40) {
				return;
			}
			Thread.sleep(1000);
			this.hp += hp;
			System.out.println(this.name + this.rank + " 이 치료를 받고 있습니다.");
			System.out.println("+" + hp + " 증가");
		}
	}

	public String toString() {
		return super.toString() + "이름은 " + this.name + " 계급은 " + this.rank + " HP : " + this.hp + " 공격력 : "
				+ this.damage;
	}

	@Override
	public void attack(String target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuclearLaunch(int x, int y) {
		System.out.println("핵폭탄 발사됨..좌표는 [" + x + "," + y + "]");
	}

	
	
	
	
	
	
	
	
	
}
