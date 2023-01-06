package basic;
import javax.swing.JOptionPane;

public class WhileExam {

	public static void main(String[] args) {
		
		boolean flag = false;
		int a = 1;
		Outer:while(a <= 5) {
			a++;
			System.out.println("현재 위 변수가 false 라 이건 실행 안됨.");
			inner:while(true) {
				int y = JOptionPane.showConfirmDialog(null, "계속 돌리래?");
				if(y == 1 || y== 2) {
					System.out.println("Label을 이용해서 Outer while 을 끝냅니다.");
					break Outer;
				}
			}
		}
		System.out.println("현재 a의 값 : " + a);
	}
}


