package utilex;

import java.util.Date;

public class DateEx1 {

	public static void main(String[] args) {
		/*
		 * System.curruntTimemillis() : 시스템으로부터 현재 시간을 long 으로 리턴함.
		 * long 은 MilliSecond 을 뜻합니다.
		 */
		System.out.println(System.currentTimeMillis());
		
		Date now = new Date();
		Date now2 = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24));
		
		System.out.println(now);
		System.out.println(now2);
		now.setTime(System.currentTimeMillis() + (1000 * 60 * 60 * 24));
		System.out.println(now);

	}

}
