package netEx;

import java.net.InetAddress;
import java.util.Arrays;

public class InetAddrExam {

	public static void main(String[] args) {
		try {
			//localhost 의 InetAddress 객체 얻기
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 PC의 IP주소 : " + local.getHostAddress());
			System.out.println(Arrays.toString(local.getAddress()));
			System.out.println(InetAddress.getLoopbackAddress());
			
			//Daum에 대한 호스트 정보 얻기
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com");
			for(InetAddress addr : naver) {
				System.out.println("다음에 할당된 IP : " + addr.getHostAddress());
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
