package homework;

/**
 * 
 * @author 노재현
 * 
 * 이 클래스는 사용자의 게임 결과 정보를 유지하는 DTO 
 * 필요한 필드 선언후 setter, getter 모두 만들었지만 다 쓰이지는 않았음..
 * 필요에 따라 setter 에 로직 정의 했으니 눈여겨 볼것.
 *
 */
public class PlayerInfo {
	
	private int win;
	private int draw;
	private int lose;
	private int total;
	private double win_Rate;
	
	//플레이 결과에 따른 승,패,무 를 자동 처리하는 메서드..메인 클래스에서 편하게 사용됨
	public void autoSet(int result) {
		if(result == 0) {//비김
			setDraw(1);
		}else if(result == 1) {//이김
			setWin(1);
		}else if(result == 2) {//짐
			setLose(1);
		}
	}
	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win += win;
		setTotal();
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw += draw;
		setTotal();
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose += lose;
		setTotal();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = this.win + this.lose + this.draw;
		setWin_Rate();
	}

	//소숫점 2자리 까지만 표현하도록 String 객체의 메서드 사용함.
	public String getWin_Rate() {
		return String.format("%.2f", this.win_Rate);
	}

	public void setWin_Rate() {
		try {
			this.win_Rate = this.getWin() / (double)this.getTotal() * 100.0;
		}catch (ArithmeticException e) {
			this.win_Rate = 0;
			System.out.println("예외");
		}
		
	}
}
