package D20;

public class MemberDTO{
	
	private String ID;
	private String PW;
	MemberDAO memDAO;
	ChangePass changePass;
	

	public MemberDTO(MemberDAO memDAO) {
		this.memDAO = memDAO;
	
	
	}
	
	


	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
			
}
