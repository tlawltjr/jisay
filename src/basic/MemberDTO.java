package basic;
import javax.swing.JOptionPane;

public class MemberDTO {

	private String mem_Email;
	JOptionPane input;
	GawiGame game;
	
	public MemberDTO() {
		inputEmain();
	}

	//메서드 리턴을 void 로 했는데, 예시 끝난후 로직상 변경해야 할겁니다.
	private void inputEmain() {
		this.mem_Email = input.showInputDialog("Email 을 입력 바랍니다");
		if(this.mem_Email == null) {
			System.out.println("입력하세요..");
		}
		game = new GawiGame();
	}

	public String getMem_Email() {
		return mem_Email;
	}
}
