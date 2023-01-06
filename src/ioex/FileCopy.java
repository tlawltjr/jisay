package ioex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//D:\full_Stack_Work\myjava\src\basic\Fruit.java
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		String origin = "D:\\full_Stack_Work\\myjava\\src\\basic\\Fruit.java";
		File backup = new File("Fruit.java.back");
		
		
		try {
			fis = new FileInputStream(origin);
			fos = new FileOutputStream(backup);
			
			//읽어온 byte 담는 변수, 또한 쓰기도 합니다.
			int data = 0;
			while((data = fis.read()) != -1){
				fos.write(data);
			}
			
			fis.close();
			fos.close();
			
			System.out.println(backup.getName() + " 이 복사되었습니다.");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
