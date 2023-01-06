package oopEx1.threadEx;
/*
 * 자바 동기화(synchronized) : 하나 이상의 쓰래드가 하나의 공유 객체에 접근해서
 * 						공유된 멤버필드를 사용할 때 동기화가 되어지지 않으면, 
 * 						올바른 값이 도출되지 않을 수 있다. 해서 자바에서는
 * 						동기화란 개념을 통해 하나의 쓰래드가 공유 객체를 점유하는
 * 						순간 해당 객체에 lock을 걸어서 다른 쓰래드가 접근을 
 * 						할 수 없도록 한다. 점유한 쓰래드가 작업을 다 마칠때까지
 * 						다른 쓰래드는 대기 영역에 머물고 lock을 해제하면
 * 						객체에 접근 하여 run()을 수행한다
 * 
 * 이렇게 동기화를 적용하는 방법은 두가지인데, 하나는 멤필의 값을 조작하는 메서드 전체에 
 * 동기화 선언을 하는 방법이고, 다른 하나는 특정 매서드에서 동기화가 필요한 로직에
 * 동기화 블럭을 선언 하는 방법이다
 * 
 *  첫번째 방법에는 매서드 return type 선언 전에 synchronized 라는 키워드를 선언하면 되고
 *  두번째는 synchronized(공유객체명){동기화가 필요한 로직 구현}으로 한다
 */

//계좌 클래스 정의합니다. 속성으로는 잔액을 가지게 합니다.

class Account{
	int balance = 1000;//잔액
	
	public synchronized void withdraw(int money) {//인출 매서드
		if(this.balance >= money) {
			try {
				Thread.sleep(1000);
				this.balance -= money;
			}catch (Exception e) {
				// TODO: handle exception
			}//너무 빠르지않게 약간의 딜레이를 줌
		}
	}
}

class ConThread implements Runnable{
	//이 쓰래드가 위의 Account 객체 하나를 공유하도록 하기위해
	//필드로 Account 객체를 생성합니다
	Account myAcc = new Account();
	
	@Override
	public void run() {
		while(myAcc.balance > 0) {
			int money = (int)(Math.random()*3 + 1)*100;
			myAcc.withdraw(money);
			System.out.println("현재 잔액 : " + myAcc.balance);
		}
	}
}
public class SynchExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConThread shared = new ConThread();
		Thread th1 = new Thread(shared);
		Thread th2 = new Thread(shared);
		
		th1.start();
		th2.start();
		
	}

}
