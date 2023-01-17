package netEx;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Client Socket은 Socket 생성시에 서버의 IP, Port 정보를 가지고 객체 생성합니다
 * 문제가 없다면 이후 Stream을 얻어내고 메세지를 송수신합니다
 * 지금은 서버에서 보낸 메세지를 수신만 하도록 정의합니다
 */
public class CSocketEx1 {

	public static void main(String[] args) {
		try {//14.42.124.97
			String ip = "14.42.124.125"; int port = 40001;
			
			Socket socket = new Socket(ip, port);
			
			//연결된 소켓에 스트림을 얻어낸다
			DataInputStream dis = new DataInputStream(socket.getInputStream());

			String msg = "";
			
			//PrintWriter 를 이용해서 데이터 보내기
			PrintWriter pw = null;
			BufferedWriter bw = null;
			OutputStream out = socket.getOutputStream();
			bw = new BufferedWriter(new OutputStreamWriter(out));
			pw = new PrintWriter(bw);
			
			//OutputStream을 bw객체로 변환했으니, println()을 이용해서
			//메세지 전송
			pw.println(msg);
			pw.flush();
			
			System.out.println("소켓으로 받은 데이터 출력합니다 : " + dis.readUTF());
			
			//스트림 종료, 소켓 종료
			pw.close();
			dis.close();
			socket.close();
			System.out.println("연결 해제");
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
