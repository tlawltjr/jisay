package basic;
import javax.swing.JOptionPane;

public class ScoreEx1 {

	public static void main(String[] args) {
		int kor,eng,math,total;
		double avg;
		char grade='F';
		
		
		do {
			kor =Integer.parseInt(JOptionPane.showInputDialog("국어점수입력"));
		}while(kor < 0 || kor > 100); 
		do {
			math =Integer.parseInt(JOptionPane.showInputDialog("수학점수입력"));
		}while(math < 0 || math > 100); 
		do {
			eng =Integer.parseInt(JOptionPane.showInputDialog("영어점수입력"));
		}while(eng < 0 || eng > 100);
		
		total = kor + eng + math;
		avg = total / 3.0;
		switch ((int)(avg/10)) {
		case 10: 
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;	
		}
		
		System.out.println("총점 : " + total + ", 평균 : " + avg + ", 학점 "
				+ grade);
	}

}
