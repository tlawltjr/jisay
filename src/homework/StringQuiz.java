package homework;
import javax.swing.JOptionPane;

public class StringQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String email = JOptionPane.showInputDialog("이메일 입력");
		String id = null, server = null;

		String invalidReason = null;
		
		while (true) {

			if (isEmail(email)) {
				id = email.substring(0, email.indexOf('@'));
				server = email.substring(email.indexOf('@') + 1, email.length());
				
				int upperChar = 0;//대문자수의 카운트하는 변수
				int digit = 0;//숫자카운트
				
				
				if (id.length() > 12 || id.length() < 6) {
					email = JOptionPane.showInputDialog("ID 길이가 맞지 않습니다.(6 ~ 12)");
					continue; 
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
					}*/
					
					
					
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
					email = JOptionPane.showInputDialog(invalidReason);
					continue;
				}
				if (digit == 0) {
					invalidReason = "숫자가 하나 이상 포함되어야 합니다.\n";
					email = JOptionPane.showInputDialog(invalidReason);
					continue;
				}
				
				server = server.replace(server, "green.co.kr");
				email = id + "@" + server;
				JOptionPane.showMessageDialog(null, email + "님 회원가입 축하!!\n메일 서버 변경도 완료했습니다.");
				System.exit(0);

			} else {
				email = JOptionPane.showInputDialog("올바른 이메일 형식 아님. 재입력 바람");
			}
		}

	}
	public static boolean isEmail(String email) {
		if (email.indexOf('@') == -1)
			return false;
		return true;
	}

}
