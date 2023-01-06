package oopEx1.packageEx;

public class First {
	
	public String name;
	protected String addr;
	String password;
	
	//이 생성자는 public 이기에 다른 패키지에서도 호출 가능함.
	/*public First() {
		
	}*/
	//이 생성자는 protected 이기에 같은 패키지에서는 호출가능, 다른 패키지에선
	//오로지 자식 클래스만 호출 가능함.
	protected First(String name) {
		this.name = name;
	}
	//이 생성자는 default 이기에, 같은 패키지에서만 호출 가능..다른 패키지에선 호출 불가.
	First(String addr,String password){
		this.addr = addr;
		this.password = password;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	protected void setAddr(String addr) {
		this.addr = addr;
	}
	void setPassword(String password) {
		this.password = password;
	}
	public static void main(String[] args) {
		
		
	}
}
