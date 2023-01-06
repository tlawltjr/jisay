package langEx.exceptionEx;
/*
 * 사용자 정의 예외 : 사용자 정의 예외란 예외 클래스를 프로그래머가 직접 정의해서
 * 던지는 형태를 말합니다.
 * 
 * 이때 사용되는 형태는 대표적으로 알려진 or 실행예외 두개정도를 만들어 쓸 수 있습니다.
 * 
 * 알려진 예외는 Exception 의 자식으로 클래스를 정의 하여서 객체를 만들어 사용하는 형태이고
 * , 실행예외는 Runtime 을 상속받아 필요시 던지는 형태입니다.
 */

//아래의 클래스는 Exception 을 상속받은 알려진예외(Checked) 로 정의 합니다.
//다른건 다 상속받아서 부모의 메서드를 그대로 이용하면 되지만, 예외의 내용은 직접 정의해야 합니다.
//때문에 파라미터 한개의 생성자를 호출 후 예외 내용을 부모에게 전달하도록 합니다.
class AccExcetpion extends Exception{
	String exceptionMsg; 
	public AccExcetpion(String exceptionMsg) {
		super(exceptionMsg);
	}
	
}

//계좌 클래스를 정의 하고, 인출(withdraw()) 시에 잔액이 부족할 경우 예외 던지도록 합니다.

class Accout{
	int balance;
	
	public Accout(int balance) {
		this.balance = balance;
	}
	
	//입금메서드 정의
	public void deposit(int amount) {
		this.balance += amount;
	}
	//출금 메서드 정의
	public int withdraw(int money) throws AccExcetpion {
		//조건절에서 인출 금액이 잔액보다 클 경우 예외를 던집니다.
		if(balance < money) {
			throw new AccExcetpion("잔액 부족 합니다 "  + (money - balance)
					+ " 이 모자랍니다!!");
		}
		return this.balance -= money;
	}
}
public class UserExceptionEx {

	public static void main(String[] args) {
		Accout acc = new Accout(1000);
		
		//예금하는 메서드 호출..잔액을 2000 으로 증가함
		acc.deposit(1000);
		
		System.out.println("현재 잔액 " + acc.balance);
		
		
		try {
			acc.withdraw(3000);
		} catch (AccExcetpion e) {
			String theMsg = e.getMessage();
			System.out.println(theMsg);
		}
		
		
		

	}

}
