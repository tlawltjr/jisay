package netEx;

import java.net.Socket;

public class P2SChattClient {

	public static void main(String[] args) {
		/*
		 * 서버에 소켓 연결 후 연결된 소켓을 쓰래드에 바인딩후
		 * 쓰래드 start() 시킵니다
		 */
		String serverIp = "14.42.124.103";
		int port = 40001;
		
		try {	
			Socket socket = new Socket(serverIp, port);
		
			Thread sThread = new Sender(socket, "sjs");
			Thread rThread = new Reciever(socket);
			
			sThread.start();
			rThread.start();
		}catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
