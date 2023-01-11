package netEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import D20.MemberDAO;

public class MultiChatServer extends MemberDAO {

	//채팅 사용자의 소켓 정보 및 스트림 정보를 관리하는 HashMap 선언
	HashMap clients;
	
	public MultiChatServer() {
		//생성자를 통해 맵객체 초기화 및 동기화된 맵 get
		clients = new HashMap();
		//아래의 Collection 메서드를 이용하면 동기화가 자동 적용된 Map 객체로 변환됩니다
		Collections.synchronizedMap(clients);
		}
	
	public void start() {
		//서버 소캣 생성 및 클라이언트 별 쓰래드 생성 구현
		try {
			ServerSocket sSocket = new ServerSocket(40001);
			System.out.println("서버 시작됨");
			Socket socket = null;
			
			while(true) {
				socket= sSocket.accept();
				System.out.println(socket.getInetAddress() + "의 사용자가 " + socket.getPort() + "로 접속함");
				
				//생성된 소켓을 쓰래드에 넘김
				ServerReciever thread = new ServerReciever(socket);
				thread.start();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//접속된 모든 사용자에게 BroadCasting(한곳에서 다중으로 일방적인 송출을 뜻함) 메서드 정의
	public void sendToAll(String msg) {
		//클라이언트의 키정보를 Iterator를 리턴받는다
		Iterator it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = new DataOutputStream((DataOutputStream)clients.get(it.next()));
				out.writeUTF(msg);
			}catch (Exception e) {
				System.out.println("브로드캐스팅시 예외 : " + e.getMessage());
			}
		}// e o while
	}//e o sendToAll
	
	public static void main(String[] args) {
		
		new MultiChatServer().start();
	}

	//서버 리시버 클래스를 inner로 정의합니다
	//Outer의 멤버와 메서드를 사용하기 위함입니다
	
	class ServerReciever extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;
		
		public ServerReciever(Socket socket) {
			this.socket = socket;
			
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			}catch (Exception e) {
				// TODO: handle exception
			}
		}// e o 생성자
		@Override
		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				
				sendToAll("[" + name + "] 님이 입장했습니다 " );
				
				//접속한 사용자의 name을 key, outputStream 객체를 Value 로 넣어준다
				clients.put(name, out);
				System.out.println("현재 접속자 수 : " + clients.size());
				
				while(in != null) {
					sendToAll(in.readUTF());
				}
			}catch (Exception e) {
				System.out.println("쓰래드의 클라이언트 메세지 전송 예외");
			}finally {
				sendToAll(name + " 님이 채팅을 나갔습니다.");
				clients.remove(name);
				System.out.println("현재 사용자 수 : " + clients.size());
			}
		}// e o run
	} //e o inner class
}
