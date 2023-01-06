package basic;
class Parent{
	private String fName;
	private String jobName;
	public Parent(String fName) {
		this.fName = fName;
		this.jobName = "내 직업은 택시 드라이버";
	}	
	public void doJob(){
		System.out.println(jobName);
	}
}
class Son extends Parent{
	String name;
	int age;
	public String jobName;
	public Son(String name, int age) {
		super("미국Ja");
		this.name = name;
		this.age = age;
		this.jobName = "프로그래머";
	}
	@Override
	public void doJob() {
		System.out.println("Son 의 직업은 " + this.jobName);
	}
}
public class IntroMyFam {

	public static void main(String[] args) {
		
		//한국인타입으로 나를 생성한 케이스 입니다..의미를 생각해보세요.
		Parent p = new Son("노재현", 30);
		p.doJob();
	}
}
