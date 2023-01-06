package myjava;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

/*
 * 다중배열을 이용해서 3명의 성적관리 프로그램을 만듭니다.
 * 전체적인 조건은 다 같되, 한명당 모든 성적입력이 올바르지 않을 경우엔
 * 다음사람의 성적이 입력되면 안됩니다.
 * 
 * 출력시 첫번째 사람은 철수, 다음은 영희, 다음은 순애로 지정하여
 * 예시처럼 출력 시킵니다. 철수님의 총점 : ? 평균 : ?
 * 영희님의 총점 : ? 평균 : ?.......
 * 단 이름값은 입력받지 아니합니다.
 */
public class ScoreEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] scores = new int[3][4];//성적담는 배열
		float[] avgs = new float[scores.length];//평균담는 배열
		String stu_name[] = {"철수","영희","순애"};
		String sub_name[] ={"국어","영어","수학"};
		int isCorrect = -1;//입력오류시..즉 점수가 틀린경우 alert 출력 flag..
		
		//사용자의 점수를 입력 받아서, 해당 점수를 검증 하고, 문제가 있다면
		//다시 점수입력 하도록 하고 싶습니다.
		//만약 한 사용자의 점수가 모두 입력이 되었다면, 해당 점수에 대해
		//총점, 평균도 한번에 처리 되도록 할 예정입니다.
		for(int i = 0; i<scores.length; i++) {
			//이 영역은 어떤 처리를 해야 하는 영역 일까요??
			for(int j = 0; j<scores[i].length-1; j++) {
				//철수의 국어,영어,수학 점수를 입력 받고, 검증도 할겁니다.
				do {
					if(isCorrect != -1) {//처음 점수를입력받을때 출력 되지않도록 처리
						JOptionPane.showMessageDialog(null, "틀렸습니다. 다시 입력 하세요");
					}
					scores[i][j] = Integer.parseInt(
							JOptionPane.showInputDialog(sub_name[j] + "점수 입력"));
					isCorrect++;//점수 입력후 여기로 오면, 첫 점수 입력이 아니라는 의미..
					//따라서 값 증가해줌..
				}while(scores[i][j] < 0 || scores[i][j] > 100);
				isCorrect = -1;//여기로 온다는 말은 한 과목에 대한 입력 검증이
				//끝났으므로, 다음 과목을 입력 받기위해 값 초기화 해줌..
				
				//i 인 학생의 총점을 여기서 넣어줍니다.
				scores[i][scores.length] += scores[i][j]; 
			}//Inner for 끝났다는 의미는?? 한사람의 총점까지가 완료됐다는 말..
			avgs[i] = (float)(scores[i][scores.length] / 3.0);
		}// 이 루프가 다 끝난다는 의미는 모든 학생의 점수 및 총점, 평균까지 완료되었단 뜻.
		
		
		//출력...
		for(int i = 0; i<scores.length; i++) {
			System.out.println();
			System.out.println(stu_name[i] + " 님의 성적: 총점 :"
					+ "" + scores[i][scores.length] + ", 평균 : " + avgs[i]);
		}
		
		
		
		
		
		
		
		
		

	}

}
