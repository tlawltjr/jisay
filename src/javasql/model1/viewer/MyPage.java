package javasql.model1.viewer;


import javax.swing.JOptionPane;

import javasql.model1.daos.ModelDAO;
import javasql.model1.model.MemberDTO;

/*
 * 이 클래스는 마이페이지와 같은 기능을 합니다
 * 
 * DAO의 myPage 메서드를 정의해서 여기서 해당 메서드를 호출하여
 * 지정된 ID에 해당하는 정보를 출력하도록 하세요
 * 당연히 파라미터 정보나, 리턴 정보는 여러분이 생각해서 정의해야합니다
 * 
 *  모든 정보가 다 나열되어야 합니다
 *  sql은 Select * from users where userid = ?
 */
public class MyPage {

	public static void main(String[] args) {
	ModelDAO dao = ModelDAO.getInstance();
	
	String id = JOptionPane.showInputDialog("조회할 ID를 입력하세요");	
	
	MemberDTO dto = dao.getMember(id);
	
	JOptionPane.showMessageDialog(null, "이름 : " + dto.getUserName() + "\n나이 : " + dto.getUserAge() + "\nEmail : " + dto.getUserEmail() + 
			"\nID : " + dto.getUserId() + "\npassword : " + dto.getUserPassword() + "\n가입일 : " + dto.getReg_Date());
	
	
	
	
	}
}
