package netEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 이 클래스에서는 Socket 클래스의 메서드를 알아보는 클래스입니다
 * 많지는 않지만 보면 대충 알수 있습니다
 */
public class SSocketEx2 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(40001);
			System.out.println("[Server is ready]");

			while (true) {
				try {
					System.out.println("서버가 연결요청을 기다립니다.");

					// 특정 시간동안 연결이 이루어지지 않으면 예외를 발생시키는 매서드 활용
					// serverSocket.setSoTimeout(5000);

					Socket socket = serverSocket.accept();

					// 접속자의 IP get
					System.out.println(socket.getInetAddress());
					System.out.println("접속된 유저의 포트 : " + socket.getPort());
					System.out.println("바인딩된 port " + socket.getLocalPort());
					
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					System.out.println(getTime() + " 에 클라이언트로부터 받은 메세지입니다");
					System.out.println(br.readLine());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}
}
