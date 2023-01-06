package utilex;

import java.util.Calendar;

import javax.swing.JOptionPane;

/*
 * roll() : 필드의 값을 증가시키는 메서드...다른 필드엔 영향 없음..
 * 단, 일필드가 말일인 경우, 월을 변경하는 케이스엔 일필드가 변경된다.
 * 
 * add() : 특정 필드를 변경시, 다른 데이터에도 영향을 미친다..
 */
public class ShowCalendar {

	public static void main(String[] args) {
		
		//사용자에게 입력 받기
		String input = JOptionPane.showInputDialog("년도와 월을 입력하세요");
		
		if(input != null) {
			//년 분리
			int year = Integer.parseInt(input.substring(0, 4));
			//월 분리
			int month = Integer.parseInt(input.substring(4, input.length()));
			
			int start_Day_Of_week = 0;
			int end_day = 0;
			
			//요청한 년월에 맞는 객체 생성
			Calendar sDay = Calendar.getInstance();
			//요청한 월의 마지막 날을 계산하기 위한 다음달의 정보를 가지는 객체 생성.
			Calendar eDay = Calendar.getInstance();
			
			//월 세팅..0 ~ 11 이므로 연산해야함.
			sDay.set(year, month-1,1);
			eDay.set(year, month, 1);//요청한 달의 다음달 1일
			
			//요청한 달의 마지막 날 추출하기..add()
			eDay.add(Calendar.DATE, -1);
			
			//이제 사용자가 요청한 달의 첫날과 끝날을 찾았으니.
			//다음엔 1일이 무슨요일인지 찾아야함..DAY_OF_WEEK 이용해서 찾음
			start_Day_Of_week = sDay.get(Calendar.DAY_OF_WEEK);
			end_day = eDay.get(Calendar.DATE);
			
			System.out.println(" SU MON TU WE TH FR SA");
			
			//출력시 해당월의 1일이 어느 요일인지를 파악후, 이전 요일은 공백을 줍니다.
			for(int i = 1; i<start_Day_Of_week;i++) {
				System.out.print("   ");//3칸 띄세요.
			}
			
			//날짜를 출력 시키는데, 2가지 생각해야 함.
			//1. 정렬 : 10일 이전은 문자가 하나이고, 이후는 2개임..따라서
			//공백을 적절히 이용해서 정렬을 해줄 예정입니다.(2칸, 1칸)
			//2. 일요일 ~ 토요일까지 출력후 라인을 변경해서 다시 날짜를 출력해야하는데
			//그 기준점이 일주일 기준인 7 입니다. 따라서 % 를 사용해 주 변경을 하도록 합니다.
			for(int i =1, n= start_Day_Of_week; i<=end_day; i++,n++) {
				System.out.print((i<10) ?"  "+i:" "+i);//2칸공백,1칸 공백
				if(n%7==0) {
					System.out.println();
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
