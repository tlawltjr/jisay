package D20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.swing.JOptionPane;



public class Intro {
	private Intro() throws IOException {
		first();
	}

	private void first() throws IOException {
		
		Properties prop = new Properties();
	
		String id = "";
		String pw = "";
		int i = 0;
		

		String[] firButton = { "로그인하기", "사용자 계정 생성", "기타 메뉴" };

		int selected = JOptionPane.showOptionDialog(null, "원하는 항목을 누르시오", "게임 실행하기", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, firButton, firButton[0]);
		MemberDAO dao = MemberDAO.getInstance();	
		if (selected == 0) {
			// 아이디 입력하는 부분. 아이디 비번 파일에서 땡겨온 후, 일치한다면 아랫 줄 비밀번호 실행
			id = JOptionPane.showInputDialog("아이디를 입력하세요");
			String userId = id.substring(0,id.indexOf('@'));
			prop.load(new BufferedReader(new FileReader("C:\\members\\" + userId + ".properties")));

			
			if (userId.equals(prop.getProperty("ID"))) {
				System.out.println(id);
				pw = JOptionPane.showInputDialog("비밀번호를 입력하세요");
				// 비밀번호 확인 파트
				if (pw.equals(prop.getProperty("Password"))) {
					JOptionPane.showMessageDialog(null, id + "님 로그인을 환영합니다.");

					// logInTime 넣어주기.
					// 비밀번호 틀릴 경우
				} else if (!pw.equals(/* 땡겨올 부분 */"")) {
					// 틀릴 시 3회 반복분

					while (i < 3) {
						pw = JOptionPane.showInputDialog("비밀번호를 " + (i + 1) + "회 잘못 입력하셨습니다.\n");
						i++;
						if (pw.equals("")) {
							JOptionPane.showMessageDialog(null, "로그인 성공");

							break;
						} else if (!pw.equals("")) {
							System.out.println("로그인 실패!");
							if (i == 3)
								JOptionPane.showMessageDialog(null, "비밀번호 입력 횟수가 초과되었습니다.\n 프로그램을 종료합니다.");
							continue;
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다. \n 다시 시작하시기 바랍니다.");
			}
		}else if(selected  == 1) {
			dao.Crmem();
		}else if(selected == 2) {
			new Fi().showMenu();
			
			
		}
	}


	public static void main(String[] args) throws IOException {
		new Intro();
		
	}

}

// 회원 아이디, 비밀번호 찾기가 필요할 것 같은데....?

