package netEx;
//송신을 담당하는 스래드 클래스 정의
//이 클래스는 송신을 담당하기 때문에 송신 대상 즉, Socket 정보가 필요합니다
//따라서 필드로 Socket을 선언하고, 객체화시에 초기화 합니다
//이후 얻어낸 소켓대상에 사용자의 입력(Scanner)을 기다리다가, 입력된 값을 Socket 대상에게
//sending하는 역할을 합니다

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class Sender extends Thread{
	Socket socket;
	DataOutputStream dos;
	String userName;
	
	//생성자의 객체생성시에 Socket 객체를 초기화합니다
	public Sender(Socket socet, String name) {
		this.socket = socket;
		this.userName = "[" + name + "] ";
		//얻어낸 소켓을 이용 OutputStram얻어내서 dos에 바인딩 합니다
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			
			userName = "sjs";
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	//run()오버라이드 얻어낸 소켓에 사용자의 입력을 writeUTF()로 보냅니다
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		while(dos != null) {
			try {
				dos.writeUTF(userName + sc.nextLine());
			}catch (Exception e) {
				System.out.println("송신예외 발생함" + e.getMessage());
			}
		}
	}
}//sender클래스 end

/*
 * 메세지 수신 쓰래드 정의 : run() 에는 연결된 소켓으로부터 오는 메세지를 readUTF()로 
 * 읽어서 콘솔에 출력합니다. 이를 위해서 Socket 정보와 여기서 할당받은 InputStream을 
 * DataInputStream에 바인딩하여 구현토록 합니다
 */
class Reciever extends Thread{
	Socket socket;
	DataInputStream dis;
	
	public Reciever(Socket soket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void run() {
		while(dis != null) {
			try {
				System.out.println(dis.readUTF());
			}catch (Exception e) {
				e.getMessage();
			}
		}
	}
}

public class P2ServerChatting {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket= null;
		try {
			serverSocket  = new ServerSocket(40001);
			socket = serverSocket.accept();
			
			//쓰래드 소켓주고 start()시킴
			Thread senderThread = new Sender(socket, "Server Jason");
			Thread recieveThread = new Reciever(socket);
			senderThread.start();
			recieveThread.start();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
