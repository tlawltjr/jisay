package basic;
import javax.swing.JOptionPane;

public class IFexam {

	public static void main(String[] args) {
//		
//		int a = -1;
//		
//		if(a > 0)
//			System.out.println("a는 0보다 큽니다.");
//		System.out.println("여긴 if 실행문이 아닌 main() 실행문 입니다.");

		//조건식을 이용해서 아래와 같은 로직을 완성 하세요.
		/*
		 * 수 3개를 입력 받습니다.
		 * 출력 결과는 가장 큰 수 부터 출력시키세요...
		 * ex> 4, 1001, 985 --> 결과 : 1001 >= 985 >= 4
		 *  
		 */
		
		
		int fir = Integer.parseInt(JOptionPane.showInputDialog("첫수입력"));
		int sec = Integer.parseInt(JOptionPane.showInputDialog("두번째수입력"));
		int third = Integer.parseInt(JOptionPane.showInputDialog("세번쨰수입력"));
		int temp;
		
		if(sec>= fir && sec >=third) {
			//무조건 두번째 수가 크다.
			//값을 치환한다..
			temp = fir;//fir 값을 temp 에 저장후 sec 에 넘긴다.
			fir = sec;//그냥 이렇게 하면 fir 의값은 날아가버림..
			sec = temp;
		}else if(third >= fir && third >= sec) {
			//무족건 3번째 입력값이 젤 큰경우
			temp = fir;
			fir = third;
			third = temp;
		}
		
		//3번째수가 2번보다 클경우..
		if(third >= sec) {
			temp = sec;
			sec = third;
			third = temp;
		}
		
		System.out.println(fir + " >= "+ sec + ">=" + third);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
