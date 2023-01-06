package basic;
import javax.swing.JOptionPane;

public class SwitchExam {

	public static void main(String[] args) {

		/*
		 * 자바에서는 switch~case 구문의 조건값으로는 int 이하만 됩니다. 반드시 기억 하세요.
		 */

		/*
		 * 두수와 연산자를 입력해서 결과를 출력하도록 switch 문을 이용해서 구현하세요 첫수 1 연산자 * 두번째수 2 --> 결과 : 1 * 2
		 * = 3
		 * 
		 * 출력문은 반드시 한번만 정의 하세요..
		 * 
		 * 
		 * 계산기를 시작하면 아래의 메세지를 띄우세요. 계산기를 실행 하시겠습니까? --> 확인을 누르실에만 계산기가 작동합니다.(즉 수를 입력
		 * 받기를 시작합니다. 만약 cancel, no 를 입력하면 좋은 하루 되세요! 출력후 프로그램 종료) 계산이 끝난후 사용자에게 더 계산할지
		 * 물어봅니다.(y or n) 만약 y 가 입력되면, 첫수를 다시 입력받도록 하고, 즉,,계산기가 재 실행되게 합니다. n 입력시..좋은
		 * 하루되세요! 메세지 출력 후 종료
		 */

		int user_choice = JOptionPane.showConfirmDialog(null, "계산기 할래?");
		if(user_choice != 0) {
			System.out.println("좋은 하루 되세요.");
			System.exit(0);
		}
		while (true) {
					
				int fir = Integer.parseInt(JOptionPane.showInputDialog("첫수입력"));
				char op = JOptionPane.showInputDialog("연산자입력").charAt(0);
				int sec = Integer.parseInt(JOptionPane.showInputDialog("두번째수입력"));
				String msg = "";// 사용자가 올바르지 않은 연산자를입력시 처리할 메세지 변수.
				double result = 0;// 결과값 선언..

				switch (op) {
				case '*':
					result = fir * sec;
					break;
				case '+':
					result = fir + sec;
				default:
					msg = "장난하지마";
					break;
				}

				if (msg.equals("")) {
					JOptionPane.showMessageDialog(null, msg);
					System.exit(0);// 자바프로그램을 명시적으로 완전종료 하는 API
					// return;

				}

				System.out.println("결과 : " + fir + op + sec + " =" + result);
				
				//int isCon = JOptionPane.showConfirmDialog(null, "게임 더할래?");

				String u_choice = JOptionPane.showInputDialog("더할래?(y or n)");
				if(u_choice.equals("n")) {
					System.out.println("좋은 하루되세요");
					break;
				}
				
				//				if(isCon != 0) {
//					System.out.println("좋은 하루 되세요.");
//					break;
//				}
				
		}
	}
	
	
	
	
	
	
	
	
	private static int showMsg(int i) {
		String[] msg = { "계산기 Go??", "Again?", "좋은 하루 되세요" };
		int res = 0;
		if (i == 0 || i == 1) {
			res = JOptionPane.showConfirmDialog(null, msg[i]);
			return res;
		} else {
			JOptionPane.showMessageDialog(null, msg[i]);
		}
		return res;
	}
}
