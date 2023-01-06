package ioex;

import java.io.File;
import java.io.FileInputStream;

public class FileInputEx {

	public static void main(String[] args) {
		String fileName = "myFirst.dat";
		File f = null;
		FileInputStream fis = null;
		
		try {
			//아래는 위의 코드를 한방코드로 정리한 코드입니다.
			//만약 한번만 읽고, 더이상 사용하지 않을거면 아래 코드로 사용해도됩니다.
			//FileInputStream fi = 
			//new FileInputStream(new File("myFirst.dat"));
			
			f = new File(fileName);
			fis = new FileInputStream(f);
			//여기까지가 파일에 InputStream 연결끝..
			
			//이젠 읽자..(read())..한번 호출때만다 1 byte 씩 읽어온다.
			//만약 파일의 끝(End of File) 에 다다르면, 더이상 읽을게 없기
			//때문에 예외를 발생시키지 않고, -1을 리턴한다.
			//리턴값인 int 를 스트림에서 읽은 byte 를 int 로 리턴한 것이지
			//int 를 읽는것이 아니니, 주의하세요.
			
			
			int data;
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
			
			
			
			//다 읽었으면 닫늕다.
			fis.close();
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
