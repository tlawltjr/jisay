package D20;

public class MemberDTO{
	
	private String ID;
	private String PW;
	private String email;
	private MemberDAO memDAO;

	public MemberDTO(MemberDAO memDAO) {
		this.memDAO = memDAO;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getID() {
		return this.email.substring(0,this.email.indexOf('@'));
	}

	public void setID(String iD) {
		ID = iD;
	}
	
}
