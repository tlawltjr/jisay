package D20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class MemberDAO {

	
	private MemberDTO memDT;
	private String id = null;
	private String fName = "C:\\members";
	private File folder = new File(fName);
	private File newFile = null;
	FileWriter fw = null;
	BufferedWriter bw = null;
	FileReader fr = null;
	BufferedReader br = null;


	public MemberDAO() {
		memDT = new MemberDTO(this);
	}
	
	
	public void Crmem() {
		memDT.setID(JOptionPane.showInputDialog("Emali을 입력 바랍니다."));
		if(((memDT).getID()).isEmpty()) {
			JOptionPane.showMessageDialog(null, "공백을 빼고 입력하여 주세요");
			Crmem();
		}
			String sev = ((memDT).getID()).substring(((memDT).getID()).indexOf('@')+1);
			id = ((memDT).getID()).substring(0,((memDT).getID()).indexOf('@'));
			JOptionPane.showMessageDialog(null, "입력하신 ID : " +  id + "입니다.\n" + "입력하신 Email : " + id + "@" + sev + "입니다." );
			char idc = id.charAt(0);
			Pattern ptt = Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])");
			Matcher mtch = ptt.matcher(id);
			
			
			
		if(id.length() < 8 && id.length() > 12 ) {
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
				File newFile = new File(folder, id + ".properties");
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
								bw.write("ID : " + id + "\n");
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
					
			        
				
			
			
	
			
	  
	
	public static void main(String[] args) {
		new MemberDAO().Crmem();
	}
}




