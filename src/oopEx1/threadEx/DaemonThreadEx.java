package oopEx1.threadEx;

public class DaemonThreadEx implements Runnable{
	//run()이 구현할 저장 내용을 5초 마다 확인할 flag 선언
	static boolean autoSave = false;
	
	public static void main(String[] args) {
		Thread t = new Thread(new DaemonThreadEx());
		
		//데몬쓰래드로 설정합니다
		t.setDaemon(true);
		t.start();
		
		//main 쓰래드가 할일 정의함 즉 부모쓰래드가 할일임
		for(int i = 0;i<=20;i++) {
			try {
				Thread.sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(i);
			
			//5초마다 저장 쓰래드가 flag확인하여 저장 기능을 수행합니다
			if(i%5==0)
				autoSave = true;
		}
		System.out.println("메인 종료됨(부모쓰래드 종료)");
	}
	//아래의 run()은 무한루프를 돌면서 5초마다 자동 저장됨이라는 메세지를
	//출력하도록 정의
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(2*1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
			if(autoSave == true)
				autoSave();
		}
		
	}

	private void autoSave() {
		System.out.println("작업 내용이 자동 저장되었습니다.");
	}
}
