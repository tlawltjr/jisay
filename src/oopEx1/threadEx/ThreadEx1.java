package oopEx1.threadEx;
/*
 * 쓰래드로 생성하는 방법
 * 1. 내 자신이 쓰래드를 상속받는 방법
 * 2. 그냥 쓰래드 객체를 생성해서 run()을 구현하는 방법(익명클래스 정의법)
 * 3. Runnable type으로 생성해서 Thread(Runnable)에 탑재하는 방법
 * 
 * 위 3개 중 뭐가 됐던 반드시 run()을 오버라이드 해야하고, Runnable 상태로 
 * 전이되기 위해서 start()를 호출해야한다
 */
class ThreadEx1_1 extends Thread{ //쓰래드를 상속됐기에 이 클래스 자체가 쓰래드다
	//수행 로직을 run()을 통해 구현한다
	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println("쓰래드 이름 : " + i);
		}
		
	}
	
}
class ThreadEx1_2 extends Thread{ 
	public void run() {
		for(int i = 0;i<5;i++) {
			System.out.println("쓰래드 이름 : " + getName());
		}
		
	}
	
}
class MyThread implements Runnable{
	@Override
	public void run() {
		for(int i = 0;i<5;i++) {
		System.out.println("이건 Runnable 타입의 쓰래드 내용입니다");
		}
	}
}
public class ThreadEx1 {

	
	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + "이 수행시작");
		//쓰래드 객체 생성
		ThreadEx1_1 t1 = new ThreadEx1_1();
		ThreadEx1_2 t2 = new ThreadEx1_2();
		
		//한방코드
		//Thread t3 = new Thread(new MyThread());
		MyThread my = new MyThread();
		Thread t3 =new Thread(my);
		
		//익명클래스를 이용한 쓰래드 생성
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0;i<5;i++) {
					System.out.println("여긴 main()에서 수행된 쓰래드의 내용" + Thread.currentThread().getName());
					
				}
				
			}
			
		});
		t4.setName("t4 쓰래드");
		
		Thread t5 = new Thread() {
			public void run() {
				System.out.println("이건 t5 쓰래드입니다" + getName());
			}
		};
		
		//쓰래드 시작
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		//이 아래는 main 쓰래드의 수행작업내용
		for(int i = 0;i<5;i++) {
			System.out.println("main " + i);
		}
	}

}
