package D20;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.swing.JOptionPane;

public class CheckPassWord {

	String userInput;
	String changePass;
	
	private CheckPassWord() throws Exception {
		
		userInput = JOptionPane.showInputDialog("기존 비밀번호를 입력하세요");
		check();
	}

	private void check() throws Exception {
		FileReader file = new FileReader("db.properties");
		BufferedReader br = new BufferedReader(file);
		Properties prop = new Properties();
		prop.load(br);
		
		
	}
	public static void main(String[] args) throws Exception {
		CheckPassWord start = new CheckPassWord();

	
	}

}
