package homework;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

public class IDChecker {

	String email;
	String passwd;//암호 필드 추가..
	
	public IDChecker(String email) {
		this.email = email;
	}
	//public static void main(String[] args) {
	public int checkId() {//main 메서드에서 변경.
		int result = 0; 
		
		// TODO Auto-generated method stub
		//String email = JOptionPane.showInputDialog("이메일 입력");
		String id = null, server = null;

		String invalidReason = null;
		
		while (true) {

			if (isEmail(email)) {
				id = email.substring(0, email.indexOf('@'));
				server = email.substring(email.indexOf('@') + 1, email.length());
				
				int upperChar = 0;
				int digit = 0;
				
				
				if (id.length() > 12 || id.length() < 6) {
					email = JOptionPane.showInputDialog("ID 길이가 맞지 않습니다.(6 ~ 12)");
					result = 1;
					//continue; 
				}
				// ID 검증 시작..
				for (int i = 0; i < id.length(); i++) {
					char ch = id.charAt(i);
					
					/*Character API 응용
					if(Character.isUpperCase(ch)) {
						upperChar++;
					}
					if(Character.isDigit(ch)) {
						digit++;
					}
					*/
					
					//하드코딩.
					if (ch >= 'A' && ch <= 'Z') {
						upperChar++;
					}
					if (ch >= (int) '0' && ch <= (int) '9') {
						digit++;
					}
					
				}
				if (upperChar == 0) {
					invalidReason = "대문자가 하나 이상 포함되어야 합니다.\n";
					result = 2;
					email = JOptionPane.showInputDialog(invalidReason);
					continue;
				}
				if (digit == 0) {
					invalidReason = "숫자가 하나 이상 포함되어야 합니다.\n";
					result = 3;
					email = JOptionPane.showInputDialog(invalidReason);
					continue;
				}
				result = 4;
//				
//				server = server.replace(server, "itkorea.co.kr");
//				email = id + "@" + server;
//				JOptionPane.showMessageDialog(null, email + "님 회원가입 축하!!\n메일 서버 변경도 완료했습니다.");
//				System.exit(0);

			} else {
				email = JOptionPane.showInputDialog("올바른 이메일 형식 아님. 재입력 바람");
				
			}
			return result;
		}

	}
	public boolean isEmail(String email) {//기존 메서드 변경...
		if (email.indexOf('@') == -1) {
			this.email = JOptionPane.showInputDialog("올바른 이메일 형식 아님. 재입력 바람");
			//return false;
		}
		return true;
	}
	public String getEmail() {//Email getter 추가..
		return email;
	}
	public void setPasswd(String passwd) {//추가
		this.passwd = passwd;
	}
	public String getPasswd() {//추가
		return passwd;
	}

}
