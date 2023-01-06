package homework;

import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 * @author 노재현
 * 
 * 이클래스는 실제 게임을 진행 하는 클래스임.
 * 생성자로 사용자값 초기화 하고, init() 초기화 메서드를 통해 가위바위보를 수치로 변경함.
 *
 */
public class Gamer {
	
	private String input;//사용자 입력값
	private static int[] chgValue = {0,1,2};
	private Random random;
	private int gameResult;//0 무승부,1 유저 승, 2 컴 승
	private int com;//컴의 랜덤값. 사용자에게 결과를 보여주는 기능을 메인 클래스에서 하기 때문에 필드로 선언함.
	
	public Gamer(String input) {
		this.input = input;
		//사용자 값을 숫자로 변경하는 초기화 메서드 호출..일반적으로  init() 명으로 많이 사용함.
		init();
	}
	private void init() {
		//랜덤객체 초기화..이후 메서드만 호출하면 랜덤값 생성됨.
		random = new Random();
		for(int i = 0; i<chgValue.length; i++) {
			if(input.startsWith("가")) {
				play(chgValue[0]);
				return;
			}else if(input.startsWith("바")) {
				play(chgValue[1]);
				return;
			}else if(input.startsWith("보")) {
				play(chgValue[2]);
				return;
			}
		}
		
	}
	private void play(int userVal) {
		//컴퓨터 값 생성.
		com = random.nextInt(3);
		//조건 검색.
		if(userVal == com) {
			//무승부.
			gameResult = 0;
		}else if((userVal == 0 && com == 2) || (userVal == 1 && com == 0) || (userVal == 2 && com == 1)){//사용자가 이기는 조건 나열..
			//유저 승
			gameResult = 1;
		}else if((userVal == 0 && com == 1) || (userVal == 1 && com == 2) || (userVal == 2 && com == 0)){
			//컴퓨터 승..
			gameResult = 2;
		}
	}
	//메인클래스에서 게임 결과 확인시 필요
	public int getGameResult() {
		return gameResult;
	}
	//메인클래스에서 컴값 확인시 필요
	public int getCom() {
		return com;
	}
}
