package basic;
import javax.swing.JOptionPane;

/*
 * 오전에 작성한 Score.java 를 배열을 이용해서 구현하는 겁니다.
 * 국영수 세점수를 받는건 같고, 다른 점수시 해당 과목에 대한 입력이 반복 출력되야 합니다.
 * 모두 정상적이면, 출력결과는 아까와 같게 하시면 됩니다.
 */
public class ScoreEx2ByArr {
	
	public static void main(String[] args) {
		int score[] = new int[4];//이 배열에는 각 과목의 점수와 총점도 int 라
		//총점 까지 넣도록 배열을 생성 했습니다.
		
		//아래 배열은 메세지 출력시 과목명을 출력 토록 한겁니다.
		String theMsg[] = {"국어","영어","수학"};
		float avg = 0F;
		
		for(int i = 0; i<theMsg.length; i++) {
			do {
		score[i] = Integer.parseInt(JOptionPane.showInputDialog(theMsg[i] 
				+ " 를 입력하세요") );
			}while(score[i] < 0 || score[i] > 100);//do while End
			score[theMsg.length] += score[i];//총점 누적 대입
		}
		avg = (float)(score[theMsg.length] / 3.0);
		
		System.out.println("총점 " + score[score.length-1] + 
				" 평균 : " + (Math.round(avg * 100) / 100.0));
		
	}

}
