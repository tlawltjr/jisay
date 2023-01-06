package D20;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;

import javax.swing.JOptionPane;

public class CheckPassWord {

	String userInput;
	String changePass;
	
	private CheckPassWord() {
		userInput = JOptionPane.showInputDialog("기존 비밀번호를 입력하세요");
		check();
	}

	private void check() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		BufferedOutputStream bos = null;

		try {
			fos = new FileOutputStream("member.dat");

			dos = new DataOutputStream(fos);

			dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("member.dat")));

			dos.writeUTF("tlawltjr23");
			dos.writeUTF("Tlawltjr23");

			dos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream(new File("member.dat")));

			String checkId = dis.readUTF();
			String checkPass = dis.readUTF();
			if(!userInput.equals(checkPass)) {
				JOptionPane.showInputDialog("잘못된 비밀번호입니다.");
			}else if(userInput.equals(checkPass)){
				changePass = JOptionPane.showInputDialog("새로운 비밀번호 입력하세요");
			}

			dis.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("2");
		}
		
		
	}
	
	public static void main(String[] args) {
		CheckPassWord start = new CheckPassWord();

	
	}

}
