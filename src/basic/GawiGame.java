package basic;
import javax.swing.JOptionPane;

public class GawiGame {

	JOptionPane thePane;
	String userinput;
	String com;
	int playCount;
	int win;
	int loss;
	String[] theMessage;
	boolean isCorrect;

	public GawiGame() {
		theMessage = new String[] { "가위(1), 바위(2), 보(3) 중 하나 입력하세요" };
		showMenu();
	}

	private void showMenu() {
		while(!isCorrect) {
			userinput = thePane.showInputDialog(theMessage[0]);
			playGame();
			isCorrect = true;
		}

	}

	private void playGame() {
		if (this.userinput.equals("1") || this.userinput.equals("가위")) {
			//가위바위보의 결정을 함.., 
			
		} else if (this.userinput.equals("2") || this.userinput.equals("바위")) {
			win++; loss++ playCount++
		} else if (this.userinput.equals("3") || this.userinput.equals("보")) {
			
		} else {
			thePane.showMessageDialog(null, "잘못된 값입니다. 재입력 바랍니다.");
			showMenu();
		}
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
	public int getLoss() {
		return loss;
	}
	public int getWin() {
		return win;
	}
	public int getPlayCount() {
		return playCount;
	}

}
