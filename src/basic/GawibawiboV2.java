package basic;

public class GawibawiboV2 {

	MemberDTO member;
	private void start() {
		play();
	}
	
	private void play() {
		//여기서 사용자의 이메일 입력받는 객체를 생성하고, 입력받는 메서드도 호출 하겠습니다.
		member = new MemberDTO();
	}
	public static void main(String[] args) {
		new GawibawiboV2().start();
		
		/*
		 * 작성된 가위 바위 보 게임을 아래와 같은 설계로 재 구현 해보세요.
		 * 
		 * 1. 게임 시작은 여기서 합니다.
		 * 2. 게임 시작시 GawibawiboV2 클래스의 start() 메서드를 호출 하여야 합니다.
		 * 3. 각 클래스를 아래처럼 정의 합니다.
		 * 3.1 GawibawiboV2 클래스는 play() 에서 객체를 만들어 호출되어야합니다.
		 * 3.2.play() 에서 호출된 객체는 사용자로부터 email 을 입력 받아서 
		 * 필드로 저장을 해야 합니다.
		 * 3.3.필요에 따라서 사용자의 ID 가 뭔지를 리턴 받을 수 있는 getter() 를 구현하세요
		 * 3.4.이 클래스 <-- 여기까지가 클래스1 
		 * 3.5 여기서부터 클래스2 --> 내부에는 사용자 이름을 입력 받고 난후 실제 게임을 진행 하는 
		 * 클래스의 객체를 생성합니다. 이때 객체 생성 후 특정 메서드를 호출 하지 않아도
		 * 내부적으로 호출하여 사용자에게 게임 하겠는지 물어봅니다.
		 * 사용자가 싫다고 하기 전까지 게임은 계속 되어야 합니다.
		 * 사용자가 첫 게임을 실행후엔 메뉴에는 아래처럼 나와야 합니다.
		 * 1.뉴게임 2.전적보기 3.게임종료
		 * 
		 * 사용자가 1을 누르면 게임은 계속 되어집니다.
		 * 
		 * 2를 입력하면 전적보기가 출력 되어야 하는데, 이 내용을 출력하는 클래스3을 정의해서
		 * 이 객체를 이용, 전적을 보여주세요.(당연히 메서드와 생성자 등을 필요에 따라 적절히
		 * 연동해야 합니다. 전적은 지금 까지 전적은 몇승 : 몇무 : 몇패 이렇게 출력됩니다.)
		 * 
		 * 3.전적을 보여주고나면 게임은 자동으로 끝납니다.
		 * 
		 * 사용자가 3을 입력하면, 게임은 자동 종료 됩니다.
		 * 
		 * 
		 * 이처럼 정의 하려면 최소 4개의 클래스가 정의 되어야 합니다.
		 * 어떤 클래스는 객체 초기화가 필요할 수 있고, 메서드에서는 파라미터가 전달
		 * 되어야 할수 있으면, 어떤 메서드는 리턴을 해야 합니다.
		 * 
		 * 
		 * 위 조건을 잘 헤아려서 정의  해보세요.
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
	}

}
