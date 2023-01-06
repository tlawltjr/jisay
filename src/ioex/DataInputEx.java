package ioex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * DataInputStream 을 이용해서 Data 를 읽을때 주의할점!!!!!
 * 
 * 1. 반드시 쓰인 순서 그대로 읽어야함..즉 int,double,float 으로 썼으면, 읽을때도 같은순으로
 * 읽는다.
 * 
 * 2. read.....(); 을 루프등을 이용해서 사용할 때, 데이터의 끝은 -1 이 아니라
 * EOFException 을 발생시켜 끝을 나타낸다..따라서 예외를 사용하여 적절히 읽는 일의 
 * 끝을 처리해야한다.
 */
public class DataInputEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			/*
			DataInputStream dis = new 
					DataInputStream(new FileInputStream(
							new File("sample.dat")));
			
			
			//쓰여진 순서 그대로 읽어온다.
			
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readBoolean());
			
			dis.close();
			*/
			
			//EofException 을 이용한 DataInput 의 예외 처리..
			try {
				int[] score = {100,85,63,95,86,58};
				
				DataOutputStream dos = new DataOutputStream
						(new FileOutputStream(new File("sample.dat")));
				
				for(int i = 0; i<score.length; i++) {
					dos.writeInt(score[i]);
				}
				
				dos.close();
			}catch (Exception e) {
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		

	}

}
