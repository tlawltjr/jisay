package javasql.model1.model;

import java.util.Date;

/*
 * 멤버의 정보를 간직하는 DTO객체
 */
public class MemberDTO {

	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
	//가입날짜 필드 추가
	private Date reg_Date;


	public MemberDTO() {
		
	}
	
	public Date getReg_Date() {
		return reg_Date;
	}

	public void setReg_Date(Date reg_Date) {
		this.reg_Date = reg_Date;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
