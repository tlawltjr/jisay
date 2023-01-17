package D20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;




public class MemberDAO {
	
	private MemberDTO memDT;
	private static String id;
	private static String pw;
	private String fName = "C:\\members";
	private File folder = new File(fName);
	private File newFile;
	FileWriter fw = null;
	BufferedWriter bw = null;
	FileReader fr = null;
	BufferedReader br = null;
	
	private static MemberDAO instance = new MemberDAO();
	
	   public static MemberDAO getInstance() {															//34~39 기제가 추가한 영역
		      return  instance;
		      
		   }
	
	public MemberDAO() {
		memDT = new MemberDTO(this);
		
	}
	
	
	public void Crmem() {
		memDT.setEmail(JOptionPane.showInputDialog("Emali을 입력 바랍니다."));
		if(((memDT).getEmail()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			Crmem();
		}
			JOptionPane.showMessageDialog(null, "입력하신 ID : " +  memDT.getID() + "입니다." );
			char idc = memDT.getID().charAt(0);
			Pattern ptt = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])");
			Matcher mtch = ptt.matcher(memDT.getID());
			
			
			
		if(memDT.getID().length() < 8 && memDT.getID().length() > 12 ) {
				JOptionPane.showMessageDialog(null, "ID를 8~12자리로 입력하여 주세요.");
				Crmem();
			}else if(!Character.isUpperCase(idc)) {
				JOptionPane.showMessageDialog(null, "ID를 첫자리를 대문자로 입력하여 주세요.");
				Crmem();
			}else if(!mtch.find()) {
				JOptionPane.showMessageDialog(null, "ID에 반드시 숫자를 넣어 입력하여 주세요.");
				Crmem();
			}
				fileCr();
	}//End of Crmem()
	
	
	public void fileCr() {
		
		
				if(!folder.exists() || !folder.isDirectory()) { 
				//폴더 생성
					folder.mkdir();
				}
				File newFile = new File(folder, memDT.getID() + ".properties");
				if (!newFile.exists()) {	// 파일이 존재하지 않으면 생성
						try {
							if (newFile.createNewFile())
								System.out.println("파일 생성 성공");
							
						} catch (IOException e) {
							e.printStackTrace();
						}
						}else {
							JOptionPane.showMessageDialog(null, "중복된 ID입니다. 다시입력 바랍니다.");
							Crmem();
						}
								
							try {
								fw = new FileWriter(newFile);
								bw = new BufferedWriter(fw);
								fr = new FileReader(newFile);
								br = new BufferedReader(fr);
								Date date_now = new Date(System.currentTimeMillis());
								SimpleDateFormat new_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
								if(br.readLine() == null) {
								
								bw.write("최초 회원 가입일 : " + new_date.format(date_now) + "\n");
								bw.write("ID : " + memDT.getID() + "\n");
								bw.flush();
								}
							}catch (Exception e) {
								System.out.println(e.getMessage());
							}
								CrmeP(newFile);
					}
	public void CrmeP(File newFile) {
		this.newFile = newFile;
		memDT.setPW(JOptionPane.showInputDialog("Password를 입력 하여 주십시요"));
		if(((memDT).getPW()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			CrmeP(newFile);
		 }	
		try {
			fw = new FileWriter(newFile, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(newFile);
			br = new BufferedReader(fr);
			bw.write("Password : " + memDT.getPW() + "\n");
			bw.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("회원가입을 진심으로 축하드립니다!");
		int ques = JOptionPane.showConfirmDialog(null, "로그인을 하시겠습니까?","질문",JOptionPane.YES_NO_CANCEL_OPTION);
		if(ques == JOptionPane.NO_OPTION || ques == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "아쉽군요 다음에 뵙겠습니다.");
		}else {
			JOptionPane.showMessageDialog(null, "로그인 창으로 이동합니다.");
		}
		
	}//End of CrmeP()
		
	public void changePass() {
		
	
		String userPass;
		String newPass;
		try {
		FileReader fr = new FileReader("C:\\members\\" + memDT.getID() + ".properties");
		
		do {
			userPass = JOptionPane.showInputDialog("기존 비밀번호를 입력하세요");
		
		} while (!userPass.equals(memDT.getPW()));		
			
	        File newCFile = new File("C:\\members\\" + memDT.getID() + ".properties");
	        
	        
	        newPass = JOptionPane.showInputDialog("새로운 비밀번호를 입력하세요");
	        
	        
	        
	        fw = new FileWriter(newCFile);
	        
			bw = new BufferedWriter(fw);
			
			Date date_now = new Date(System.currentTimeMillis());
			
			SimpleDateFormat new_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
						
			bw.write("최초 회원 가입일 : " + new_date.format(date_now) + "\n");
			
			bw.write("ID : " + memDT.getID() + "\n");
			
			bw.write("Password : " + newPass + "\n");
			
			bw.close(); 
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}            

		}
	
	
	public static void main(String[] args) {
		new MemberDAO().Crmem();
	}
}


