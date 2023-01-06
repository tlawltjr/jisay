package homework;

import javax.swing.JOptionPane;

/**
 * 
 * @author 노재현
 * 사용자의 입력값이 올바른지 검증 및 오류 횟수에 따른 프로그램 종료 기능 추가.
 */
public class Checker {

	private String input; //사용자 입력값
	private int faultCount; //사용자의 오류 카운터

	public Checker(String input) {
		super();
		this.input = input;
	}

	public boolean check() {
		boolean result = false;
		//사용자의 입력값이 배열중 하나인지 검색해본다..맞으면 true 리턴 하고 for 종료됨
		for (String str : Gawibawibo.strValues) {
			if (str.equals(input)) {
				return !result;
			}
		}
		//올바른 값이 아니기에 실수 횟수 업, 사용자에게 알럿띄우고, 결과 리턴함.
		faultCount++;
		showAlert();
		return result;

	}

	/*
	 *	가위바위보 아닌 다른 값 입력시 알럿 보여주고 오류가 5번 인 경우 프로그램 종료 기능 적용함. 
	 */
	private void showAlert() {
		if (faultCount >= 5) {
			//JOptionPane.showMessageDialog 는 화면에 메세지만 보여주는 객체의 메서드임. 두번째 파라미터가 내용임
			JOptionPane.showMessageDialog(null, "오류 횟수가 5회 넘어 프로그램을 종료 합니다");
			//아래코드는 명시적으로 실행중인 자바 프로그램을 종료시키는 코드임.
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null, Gawibawibo.messages[2] + "\n 오류횟수 : " + faultCount);
		// check();
	}
	
	//사용자가 가위바위보를 잘못 입력후 재 입력시 setter.
	public void setInput(String input) {
		this.input = input;
	}

}
