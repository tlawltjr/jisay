package oopEx1.threadEx;


class Pthread1 extends Thread{
	public void run() {
		for(int i =0;i<300;i++) {
			System.out.print("-");
			for(int x =0;x<100000;x++) {
				
			}
		}
	}
}
class Pthread2 extends Thread{
	public void run() {
		for(int i =0;i<300;i++) {
			System.out.print("ㅣ");
			for(int x =0;x<100000;x++) {
				
			}
		}
	}
}
public class ThreadFrior {

	public static void main(String[] args) {
		Pthread1 th1 = new Pthread1();
		Pthread2 th2 = new Pthread2();
		
		//우선순위를 다르게 줍니다
		th2.setPriority(9);
		th1.setPriority(1);
		
		//th1,2 모두 쓰래드 자식 클래스이므로 아래의 메서드를 이용해서
		//이름과 우선순위 값을 출력합니다
		System.out.println(th1.getName() + "쓰래드 우선순위 : " + th1.getPriority());
		System.out.println(th2.getName() + "쓰래드 우선순위 : " + th2.getPriority());
		
		th1.start();
		th2.start();
		
			
	}

}
