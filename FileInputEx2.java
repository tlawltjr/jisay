package ioex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputEx2 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("myFirst.dat");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				char c = (char)fis.read();
				System.out.print(c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
