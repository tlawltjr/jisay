package ioex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

public class FileReaderEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//D:\full_Stack_Work\myjava\src\basic\ArrayExam.java
		
		//PrintWirter 이용해서 파일을 복사해서 ArrayExam.java.back 이라는 파일 생성
		//하세요.
		
		File file = 
		new File("D:\\full_Stack_Work\\myjava\\src\\basic\\ArrayExam.java");
		
		FileReader fr = null;
		BufferedReader br = null;
		LineNumberReader lr = null;
		String msg = null;
		int readData;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			lr = new LineNumberReader(br);
			
			String msg2;// = null;
			
			while((msg2 = lr.readLine()) !=  null){
				System.out.print(lr.getLineNumber() + " ");
				System.out.println(msg2);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		/*
		try {
			fr = new FileReader(file);
			
			//순수하게 read() 만 이용해서 읽기.
			while((readData = fr.read()) != -1) {
				System.out.print((char)readData);
			}
			
			fr.close();
		}catch (Exception e) {
			// TODO: handle exception
		}*/
		
	
		
		
		

	}

}
