package netEx;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 이 클래스는 서버에서 쓰레드를 생성, 클라이언트의 요청이 오면 동적으로 쓰래드가 
 * 요청에 대한 1:1로 맺도록 정의합니다
 * 
 * 이렇게 처리해야 클라이언트의 요청을 바로바로 처리할 수 있답니다
 * 
 * 쓰래드가 처리한 Runnable 타입을 내 자신이 되도록 정의합니다
 */
public class SSocketEx3 implements Runnable{

	
	ServerSocket serverSocket;
	Thread[] threadArr;
	
	//주어지는 개수만큼 쓰래드를 생성하는 생성자
	public SSocketEx3(int num) {
		try {
			//소켓을 40001에 바인딩
			serverSocket = new ServerSocket(40001);
			System.out.println("서버 준비됨");
			
			threadArr = new Thread[num];
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//각각의 쓰래드를 start()시키도록하는 메서드
	public void start() {
		for(int i = 0; i<threadArr.length; i++) {
			//쓰래드가 수행할 Runnable 객체를 자신으로 지정함 즉
			//하나의 쓰래드가 하나의 서버소켓을 수행하도록 함
			threadArr[i] = new Thread(this);
			threadArr[i].start();
		}
	}
	
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println("서버가 연결을 기다림");
			Socket socket;
			try {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress() + "로 부터 연결요청옴");
				
				//스트림 얻기
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("서버접속을 확인했습니다");
				System.out.println("클라이언트레 데이터 전송완료");
				
				dos.close();
				socket.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
	public static void main(String[] args) {
		SSocketEx3 server = new SSocketEx3(10);
		server.start();
		//5개의 쓰래드를 생성하는 서버 구현
	}


}
