//package netEx;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.Socket;
//import java.util.Scanner;
//
////송신쓰래드, 수신쓰래드 구현합니다
///*
// * 송수신 쓰래드는 사용자의 ID를 먼저 보내는것 외에는 이전 것과 다름이 없습니다
// */
//class ClientSender extends Thread{
//
//	Socket socket;
//	DataOutputStream out;
//	String name;
//	
//	public ClientSender(Socket socket, String name) {
//		//서버와 소캣 연결과 동시에 서버의 name(id)를 전송한다
//		this.socket = socket;
//		try {
//			out = new DataOutputStream(socket.getOutputStream());
//			this.name = name;
//		}catch (Exception e) {
//			System.out.println("클라이언트 소켓 생성 예외 : " + e.getMessage());
//		}
//	}
//	@Override
//	public void run() {
//		Scanner sc = new Scanner(System.in);
//		try {
//			if(out != null) {
//				out.writeUTF(name);
//			}
//			while(out != null) {
//				out.writeUTF("[" + name + "] : " + sc.nextLine());
//			}
//		}catch (Exception e) {
//			
//		}
//	}
//}// e o clientSender
//
//class ClientReciever extends Thread{
//	Socket socket;
//	DataInputStream in;
//	
//	public ClientReciever(Socket socket) {
//		this.socket = socket;
//		try {
//			in = new DataInputStream(socket.getInputStream());
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
//	@Override
//	public void run() {
//		while(in != null) {
//			try {
//				System.out.println(in.readUTF());
//			}catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
//public class MultiChatClient {
//
//	public static void main(String[] args) {
//		//클라이언트 시작시에 배열의 값을 사용자의 아이디로 이용합니다
//		if(args.length != 1) {
//			System.out.println("ID를 반드시 넣고 시작하세요");
//			System.exit(0);
//		}
//		
//		String serverIp = "14.42.124.254";//
//		int port = 40001;
//		
//		try {
//			Socket socket= new Socket(serverIp, port);
//			System.out.println("서버에 연결됨");
//			//서버에 연결되었으니 제일 먼저 ID를 보내줍니다
//			//당연히 쓰래드를 이용해야겠지요
//			
//			Thread sender = new Thread(new ClientSender(socket, args[0]));
//			Thread reciever = new Thread(new ClientReciever(socket));
//			
//			sender.start();
//			reciever.start();
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
//
//}
//package netEx;
///*
// * 송신쓰레드, 수신 쓰레드 구현
// * 송수신 쓰레드는 사용자의 id를 먼저 보내는 것 외에는 이전 것과 다름없다.
// */
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.net.Socket;
//import java.util.Scanner;
//
//class ClientSender extends Thread {
//   Socket socket;
//   DataOutputStream out;
//   String name;
//   
//   public ClientSender(Socket socket, String name) {
//      //서버와 소켓 연결과 동시에 서버에 name(id)를 전송한다.
//      this.socket = socket;
//      try {
//         out = new DataOutputStream(socket.getOutputStream());
//         this.name = name;
//      } catch (Exception e) {
//         System.out.println("클라이언트 소켓 생성 예외 : " + e.getMessage());
//      }
//   }
//   @Override
//   public void run() {
//      Scanner sc = new Scanner(System.in);
//      try {
//         if(out != null) {
//            out. writeUTF(name);
//         }
//      } catch (Exception e) {
//         // TODO: handle exception
//      }
//   }
//} // End of ClientSender Thread
//
//class ClientReceiver extends Thread {
//   Socket socket;
//   DataInputStream in;
//   
//   public ClientReceiver(Socket socket) {
//      this.socket = socket;
//      try {
//         in = new DataInputStream(socket.getInputStream());
//      }catch (Exception e) {
//         // TODO: handle exception
//      }
//   }
//   @Override
//   public void run() {
//      while(in != null) {
//         try {
//            System.out.println(in.readUTF());
//         } catch (Exception e) {
//            // TODO: handle exception
//         }
//      }
//   }
//}
//public class MultiChatClient {
//   public static void main(String[] args) {
//      //클라이언트 시작 시에 배열의 값을 사용자의 아이디로 이용한다.
//      if(args.length != 1) {
//         System.out.println("ID를 반드시 넣고 시작하세요.");
//         System.exit(0);
//      }
//      String serverIp = "14.42.124.103";
//      int port = 40001;
//      try {
//         Socket socket = new Socket(serverIp, port);
//         System.out.println("서버에 연결됨");
//         //서버에 연결 완료. 제일먼저 id를 보여주자 Thread이용
//         
//         Thread sender = new Thread(new ClientSender(socket, args[0]));
//         Thread receiver = new Thread(new ClientReceiver(socket));
//         
//         sender.start();
//         receiver.start();
//      }catch (Exception e) {
//         // TODO: handle exception
//      }
//   }
//}
package netEx;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
 * 송신쓰래드, 수신쓰래드 구현합니다.
 * 
 * 송수신 쓰래드는 사용자의 ID 를 먼저 보내는것 외에는 이전것과 다름이 없습니다.
 */
class ClientSender extends Thread{
   
   Socket socket;
   DataOutputStream out;
   String name;
   
   public ClientSender(Socket socket, String name) {
      //서버와 소켓 연결과 동시에 서버에 name(id)를 전송한다.
      this.socket = socket;
      try {
         out = new DataOutputStream(socket.getOutputStream());
         this.name = name;
      } catch (Exception e) {
         System.out.println("클라이언트 소켓 생성 예외 : " + e.getMessage());
      }
   }
   @Override
   public void run() {
      Scanner sc = new Scanner(System.in);
      try {
         if(out != null) {
            out.writeUTF(name);
         }
         while(out != null) {
            out.writeUTF("[" + name + "] : " + sc.nextLine());
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
   }
}
class ClientReciever extends Thread{
   Socket socket;
   DataInputStream in;
   
   public ClientReciever(Socket socket) {
      this.socket = socket;
      try {
         in = new DataInputStream(socket.getInputStream());
      } catch (Exception e) {
       System.out.println(e.getMessage());
      }
   }
   @Override
   public void run() {
      while(in != null) {
         try {
            System.out.println(in.readUTF());
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
      }
   }
}
public class MultiChatClient {

   public static void main(String[] args) {
         //클라이언트 시작시에 배열의 값을 사용자의 아이디로 이용합니다.
         if(args.length != 1) {
            System.out.println("ID 를 반드시 넣고 시작하세요.");
            System.exit(0);
         }
         String serverIp = "14.42.124.103";//모두 통일 하세요...선생님 IP 입니다. 테스트 이후 조단위로 해볼게요.
         int port = 40001;
         try {
            Socket socket = new Socket(serverIp, port);
            System.out.println("서버에 연결됨..");
            //서버에 연결되었으니 제일먼저 ID를 보내줍니다.
            //당연히 쓰래드를 이용해야겠지요..
            
            Thread sender = new Thread(new ClientSender(socket, args[0]));
            Thread reciever = new Thread(new ClientReciever(socket));
            
            sender.start();
            reciever.start();
         } catch (Exception e) {
            // TODO: handle exception
         }
      }
}

