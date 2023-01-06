package ioex;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataOutputEx {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		BufferedOutputStream bos = null;//이건 예제 끝나면 여러분이 적용해보세요
		
		try {
			fos = new FileOutputStream("sample.dat");
			//dos 는 생성자 파라미터로 OutputStream 을 받는다.
			dos = new DataOutputStream(fos);
			
			dos = new DataOutputStream(new BufferedOutputStream
					(new FileOutputStream("sample.dat")));
			
			//아래에서 사용되는 메서드는 자바 데이터를 그대로 쓰기 때문에
			//쓰여진(생성된) 파일의 크기를 확인 해보면 이해할수 있다.
			
			dos.writeInt(10);
			dos.writeFloat(20.0F);
			dos.writeBoolean(true);
			dos.writeUTF("Hello");
			
			dos.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
