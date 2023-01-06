package ioex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PstreamExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("message.log");
		FileOutputStream fos = null;
		PrintStream ps = null;
		
		Scanner sc = new Scanner(System.in);
		
		//사용자의 입력 값..
		String input = null;;
		
		
		try {
			//File 에 Append 가 가능하도록 fos 생성..
			fos = new FileOutputStream(f, true);
			//PrintStream 의 메서드를 사용하기 위해 객체 생성
			ps = new PrintStream(fos);
			
			System.out.println("안녕하세요..메세지 입력하시고..끝내려면 q 입력해");
			
			while(true) {
				System.out.print("msg : ");
				input = sc.nextLine();
				if(input.equalsIgnoreCase("q")) {
					System.out.println("좋은 하루..");
					System.exit(0);
					break;
				}
				
				ps.println(input);
				ps.flush();
			}
			
			ps.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("xxxxxx");

	}

}
