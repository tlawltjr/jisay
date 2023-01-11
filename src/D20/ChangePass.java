package D20;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

public class ChangePass {
		MemberDTO dto; 
		String userPass;
	
	private ChangePass() {
		checkPass(dto);
	}
	
	private void checkPass(MemberDTO dto)  {
		this.dto = dto;
		System.out.println(dto.getID());
		try {
			
			FileInputStream fi = new FileInputStream("C:\\members" + dto.getID() + ".properties");
			BufferedInputStream br = new BufferedInputStream(fi);
			
			
			
			
		}catch (Exception e) {
			System.out.println("error");
		}
		
		
	
		
	}
	
	public static void main(String[] args) {
		ChangePass cp = new ChangePass();
		
	}

}
