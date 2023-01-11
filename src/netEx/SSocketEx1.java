package netEx;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SSocketEx1 {
	
	
	public static void main(String[] args) {
		/*
		 * ServerSocket 구현방법
		 * 1. ServerSocket 생성(port번호주고)
		 * 2. accept() 호출 : 클라이언트의 요청이 올때까지 무한루핑
		 * 3. 요청이 오면 accept()이 invoke(자동호출) 되고 클라이언트로
		 * 1ㄷ1 연결된 Socket 객체 리턴함
		 * 4. Socket이 연결되었으면, in/output Stream연결
		 * 5. 데이터 주고 받기 끝나면 모두 닫기
		 */
		
		ServerSocket serverSocket = null;
		try {
			//40001 포트를 열어두고 클라이언트의 요청 기다린다
			serverSocket = new ServerSocket(40001);
			
			System.out.println("[Server is ready]");
			
			//while을 통해서 accept()가 호출되길 기다린다
			while(true) {
				//요청연결되면 1ㄷ1 Socket 객체 리턴함
				System.out.println(getTime() + "연결요청을 기다립니다");
				Socket socket =  serverSocket.accept();
				//위 accept() 이 호출되면 아래의 내용이 출력
				System.out.println(getTime() + socket.getInetAddress() + "로 부터 연결 요청이 들어왔습니다");
				
				//소켓으로부터 스트림 얻기
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//클라이언트의 메세지 읽기 스트림을 BufferedReader에 한방에 담기
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				System.out.println(getTime() + " 에 클라이언트로부터 받은 메세지입니다");
				System.out.println(br.readLine());
				
				dos.writeUTF("[MSG From Server] 안녕하세요 서버가 응답합니다");
				System.out.println("클라이언트에 데이터 전송 완료");
				
				br.close();
				dos.close();
				socket.close();
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
		return sdf.format(new Date());
	}

}
