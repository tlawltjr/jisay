package utilex;

import java.util.Calendar;

public class CalendarEx1 {

	static String toString(Calendar cal) {
		return cal.get(Calendar.YEAR) + " 년 " + (cal.get(Calendar.MONTH) +1) + " 월 " +
				cal.get(Calendar.DATE) + " 일 ";
	}
	
	public static void main(String[] args) {
		final String[] DAY_OF_WEEK = {"","일","월","화","수","목","금","토"};
		// TODO Auto-generated method stub
		Calendar rightNow = Calendar.getInstance();
		Calendar rightNow2 = Calendar.getInstance();
		
		
		rightNow.set(Calendar.YEAR, 2022);
		rightNow.set(Calendar.MONTH, 0);
		rightNow.set(Calendar.DATE, 4);
		
		
	
		
		System.out.println("rightNow 는 " + toString(rightNow) + 
				DAY_OF_WEEK[rightNow.get(Calendar.DAY_OF_WEEK)] + " 요일입니다.");
		System.out.println("rightNow2 는 " + toString(rightNow2) + 
				DAY_OF_WEEK[rightNow2.get(Calendar.DAY_OF_WEEK)] + " 요일입니다.");
		
		
		
		long differ = (rightNow2.getTimeInMillis() - rightNow.getTimeInMillis()) /1000;
		
		System.out.println("작년 오늘 날짜부터 현재까지는 " + differ + " 초가 지남.");
		System.out.println("일단위로표현하자면 --> " + differ / (24*50*60));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//		System.out.println(rightNow);
		
	}

}
