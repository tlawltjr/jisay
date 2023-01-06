package returnBasic;

//부모 클래스가 될 기본 클래스 정의 해봅니다.
class Parent extends Object{
	
	private String myName;//이름멤버변수
	private int age;//나이멤버변수
	
	public Parent(String myName, int age) {
		super();//Object 의 기본 생성자 호출..
		this.age = age;
		this.myName = myName;
	}
	
	protected void myJob() {
		System.out.println("Parent 클래스의 직업은 어부");
	}
	
	
}
class Son extends Parent{
	private String myJob;
	
	public Son() {
		super(null,0);//Parent 기본생성자 호출..
	}
	
	public void myJob() {
		System.out.println("Son 클래스의 직업은 자바프로그래머");
	}
}

class UserEmail{
	
	private String email;
	 
	public UserEmail() {
		// TODO Auto-generated constructor stub
	}
	
	public UserEmail(String email) {
		this.email = email;
	}
	
	//email 값을 리턴하는 getter 만들기.
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
public class ConstructorExam {

	UserEmail email;
	
	public static void main(String[] args) {
		
		Son son = new Son();//Son 기본 인스턴스 생성
		Object object = son;//Ref 를 복사해서 넘겨준다.
		Parent parent =(Parent)object;//Object Ref 하는 참조값을 parent 에게 넘겨준다.
		Parent p2 = new Son();
		
		/*
		parent = null;
		son = null;
		object = null;
		p2 = null;
		*/
		System.out.println(object.equals(son));
		System.out.println(parent.equals(p2));
		
		((Parent)object).myJob();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		


	}

}
