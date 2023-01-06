package oopEx1.threadEx;
/*
 * 공유 객체 내부에 동기화 매서드와 블럭이 여러개면 쓰래드가 이중 하나를 점유(실행)을 하면
 * 다른 쓰래드는 해당 매서드와 다른 동기화 블럭 매서드 또한 접근이 차단됩니다(객체에 lock걸림)
 * 
 * 하지만 일반 매서드는 수행 가능합니다
 * 
 * 쓰래드가 동기화 매서드를 실행하는 즉시 객체엔 Lock, 수행 후엔 Lock해제, 이때 대기중인
 * 쓰래드는 잘못하면 데드락(Death lock) 상태에 빠질 수 있으며 이땐 벽돌상태가 됩니다
 * 
 * 만약 여러분이 매서드 전체에 동기화를 걸지 않고 일부만 사용하고 싶을때 동기화 블럭을 사용합니다
 * 형식은 -->void someMethod(){synchronized(공유객체){동기화 적용 로직}}
 */

//아래의 클래스는 잔액을 계산하는 기능을 가진 클래스입니다
//각각의 매서드를 통해 하나는 금액을 set, 하나는 get 하도록 합니다
//이때 이 객체를 다중의 쓰래드가 접근하면서 각기 다른 매서드를 호출하면 오류된 값이 나오는데
//이를 동기화 매서드와 블럭을 이용해서 적절히 제어합니다

class Calculator{
	private int money;
	
	public int getMoney() {
		return money;
	}
	public/* synchronized */void setMoney(int money) {
		this.money = money;
		
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.money);
	}
	//동기화 블럭을 적용한 예
	public void setMoney2(int money) {
	//	synchronized (this) {//자신이 공유객체임을 선언함
			this.money = money;
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(Thread.currentThread().getName() + " : " + this.money);
	//	}
	} // e o setMoney2
}

//아래는 공유객체인 Calculator를 이용하는 쓰래드 정의
class User1Thread extends Thread{
	private Calculator calculator;
	
	public User1Thread() {
		setName("User1Thread");
	}
	public void setCalculator(Calculator cal) {
		this.calculator = cal;
	}
	@Override
	public void run() {
		calculator.setMoney(50);
	}
}
class User2Thread extends Thread{
	private Calculator calculator;
	
	public User2Thread() {
		setName("User2Thread");
	}
	public void setCalculator(Calculator cal) {
		this.calculator = cal;
	}
	@Override
	public void run() {
		calculator.setMoney2(50);
	}
}
public class SynchExam2 {

	public static void main(String[] args) {
		//공유객체 생성
		Calculator cal = new Calculator();
		//cal 객체를 각각의 쓰래드에 넘기면 공유가 됩니다
		//이유는 Ref 같기 때문
		
		User1Thread u1 = new User1Thread();
		u1.setCalculator(cal);
		u1.start();
		
		User2Thread u2 = new User2Thread();
		u2.setCalculator(cal);
		u2.start();

	}

}
