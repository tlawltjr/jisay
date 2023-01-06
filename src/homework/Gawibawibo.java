package homework;

import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Gawibawibo {

	// 사용할 객체 타입 필드 선언.
	static private Checker checker;
	static private Gamer gamer;
	static private PlayerInfo user;

	static private String input; // 사용자의 입력값 변수. 상황에 따라 계속 사용해야 하기 때문에 필드로 선언.
	public static String strValues[] = { "가위", "바위", "보" };
	private static int com;

	// 메세지 출력 배열 생성.
	public static String[] messages = { "게임을 시작 합니다.(Y/N)", "가위바위보 중 하나 입력하세요.", "입력이 틀렸습니다. 다시 입력해주세요.",
			"게임을 다시 하시겠습니까?(Y/N)" };
	public static String[] messages2 = { "1.ID 생성하기(회원가입)", "2.로그인 하기.", "3.랭킹보기." };
	

	public static void main(String[] args) {
		// 사용자에게 메세지출력 및 선택값 입력 받도록 한다.
		startMessage();

		// 사용자의 입력값을 가지고 초기화 한다. 이후 값을 검증해서 목적에 따라 분기 시킨다..해당 클래스 분석 해볼것.
		checker = new Checker(input);
		while (true) {

			// 값 검증할것.
			if (checker.check()) {// 올바른 값을 사용자가 넣었으니 게임 플레이..
				// gamer 생성자에 사용자 값 넣어주고 초기화...이후 생성자-->초기화메서드-->플레이메서드 의 호출 관계를 통해 자동으로 게임이
				// 실행된다.
				gamer = new Gamer(input);

				// 승패 결과 get..
				int result = gamer.getGameResult();
				// 컴퓨터의 값 get..
				com = gamer.getCom();

				if (user == null) {// 처음 게임플레이라면 객체 초기화 해주고..첫 게임이기에 객체 생성을 한것으로,
					// 게임 실행시마다 객체를 실행하면 누적 값을 유지 하기 어렵다. 해서 이후 게임부터는 Ref 변수를 이용해서 전적을 누적시킨다. 눈여겨
					// 본다.
					// 객체가 할당되지 않을시엔 null 이 리턴된다.(꼭 기억할것)
					user = new PlayerInfo();
					// 승패 전적을 자동으로 setting 하는 메서드 호출하여 전적 set.
					user.autoSet(result);
					// 결과 메세지 화면에 뿌려준다. 파라미터의 정보는 해당 메서드에 정의 했으니 꼭 이해 한다.
					showMessage(result, user, com);
					// 게임을 계속 할 지 여부를 확인한다.
					// 아래 문자열중 \"Cancel\" 는 자바의 escape 문자로 역슬래쉬 옆에 t(tab), "(쌍따옴표) 등을 표기해줄때 사용한다.
					input = JOptionPane.showInputDialog(
							"게임을 계속 하실려면 " + Arrays.toString(strValues) + " 중 하나를, 끝내려면 \"Cancel\" 누르세요.");
					// 사용자가 새로운 값을 넣었으니 다시 체크..오류 값도 체크를 해야한다.
					checker.setInput(input);
					// 만약 사용자가 cancel 을 누르면 null 이 리턴되므로 프로그램 종료시킨다.
					if (input == null) {
						programExit();
					}
				} else {// 그렇지 않다면 기존 사용자가 계속 게임을 하는 것이므로 setter 를 이용해서 정보만 누적한다.
					user.autoSet(result);
					showMessage(result, user, com);
					input = JOptionPane.showInputDialog(
							"게임을 계속 하실려면 " + Arrays.toString(strValues) + " 중 하나를, 끝내려면 \"Cancel\" 누르세요.");
					checker.setInput(input);
					if (input == null) {
						programExit();
					}
				}
			} else {// 가위바위보 가 아닌 이상한 값 넣었을떄..
				input = JOptionPane.showInputDialog(messages[1]);
				// 사용자의 다른값을 checker 에 세팅한다...다시 루프로..
				checker.setInput(input);
			}
		}
	}

	private static void programExit() {
		JOptionPane.showMessageDialog(null, "프로그램을 종료 합니다.", "프로그램 종료", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}

	// 처음 시작시 초기 메세지를 보여주고 사용자의 선택을 받는다.
	// y 또는 Y 일때만 다음으로 실행되고, 나머진 프로그램 종료
	private static void startMessage() {
		input = JOptionPane.showInputDialog(Arrays.toString(messages2));
		//input = JOptionPane.showInputDialog(Arrays.toString(messages));
		System.out.println(input);
		MemberDAO memberCreate;
		IDChecker checker;
		Member member;
		String email, passwd = null;
		/*
		 * 0 : @ 없음 1 : 길이 틀리 2 : 대문자 없음 3 : 소문자 없음 4 : 정상 ID(Email)
		 */
		int idResult = 0;//

		try {
			switch (Integer.parseInt(input)) {
			case 1:
				email = JOptionPane.showInputDialog("Email 을 입력하여 주세요");
				checker = new IDChecker(email);
				idResult = checker.checkId();
				if (idResult == 4) {// Email 형식 Check OK...
					// IDChecker 에서 수정 및 검증 된 ID 가 최종 ID 이기 때문에 getter 를 통해 다시 얻어온다.
					email = checker.getEmail();
					// Password 입력 받기.
					passwd = JOptionPane.showInputDialog("암호를 입력하여 주세요");
					checker.setPasswd(passwd);
					// 멤버정보를 세팅합니다.
					member = new Member(System.currentTimeMillis(), email, passwd);
					// 파일 생성 Go
					int newMember = new MemberDAO(member).doWork();
					if (newMember == 1) {
						int firLogin = JOptionPane.showConfirmDialog(null, "회원가입이 완료 되었습니다. 로그인 하시겠습니까?");
						if (firLogin == 0) {// ok 시 0 리턴..
							// Login 시키기..새로 추가함..
							logIn();
						} else {
							// Yes 가 아닌 다른 경우는 일단 종료 시키는 로직으로 했으나 여러분이 다른걸로 바꿔보세요~
							JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
							System.exit(0);
						}
					}
				}
			case 2:
				int result = logIn();
				if(result == 2) {
					break;
				}
				else {
					//여기는 여러분이 구현해 보세요...-1 인경우 회원아님, 0 인 경우 암호 틀림 
				}
			case 3:

				break;

			default:
				break;
			}
		} catch (Exception e) {
			// 사용자가 입력 오류시 그냥 끝내도록 했는데, 여러분이 알맞게 구현해 보세요~~
			// TODO: handle exception
			JOptionPane.showConfirmDialog(null, "입력값이 틀립니다..프로그램 종료 합니다.");
			System.exit(0);
		}

		input = JOptionPane.showInputDialog(Arrays.toString(strValues) + messages[0]);
		// 첫 시작시 cancel 이벤트시 예외 처리함.
		try {
			// 대소문자 구분없이 문자열 값이 같은지 비교 메 서드 사용.equals() 는 대소문자 구분함.
			if (input.equalsIgnoreCase("y")) {
				// 가위바위보 중 하나 넣으라고 했으나 다른값을 넣어도 검증하도록 설계했다. 분석 해보도록..
				input = JOptionPane.showInputDialog(messages[1]);
				return;
			}
		} catch (Exception e) {
			int res = JOptionPane.showConfirmDialog(null, "종료 하시겠습니까?");
			if (res == 0 || res == 2) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				System.exit(0);
			}
			input = JOptionPane.showInputDialog(messages[1]);
			// 한번더 cancel 시 프로그램 강제 종료
			if (input == null) {
				JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
				System.exit(0);
			}
		}
		if (input.equalsIgnoreCase("n")) {
			// 메세지 박스만 출력하는 GUI 호출.
			JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
			// 아래 코드는 명시적으로 현재 실행중인 자바 프로그램을 종료하는 코드이다.
			System.exit(0);
		} else {// Y/N 아닌 다른 값 들어올 경우 처리..
			JOptionPane.showMessageDialog(null, "실행할 수 없는 명령어 입니다. 프로그램 종료합니다");
			System.exit(0);
		}

	}
	//로그인 메서드 추가함..
	private static int logIn() {
		int result = -1;
		//로그인시에 로그인 시간 Setting 및 최종 경과 시간을 가져옵니다.
		//루프 제거하고 작업합니다...루프 작업은 여러분이 구현 해보세요..
		String input = JOptionPane.showInputDialog("ID와 Pass 정보를 \',\' 를 넣어서 입력 바랍니다");
		System.out.println(input);
		StringTokenizer st = new StringTokenizer(input,",");//이 객체는 문자열의 Delimeter 를 기준으로 문자열을 분리 시켜 리턴 해주는 객체입니다. "," 를 기준으로 분리해서 id,pass 세팅합니다.
		String id=null, passwd = null;
		Member member = null;
		while(st.hasMoreElements()) {
			member = new Member(System.currentTimeMillis(), st.nextToken(), st.nextToken());
		}
		System.out.println(member.getEmail());
		result = new MemberDAO().logIn(member);
		
		//System.exit(0);
		
		return result;
	}

	/*
	 * 게임 결과 보여주는 메서드.. 전적 정보는 사용자객체(PlayerInfo) 에 있기 때문에 파라미터로 받고, idx 는 승패에 대한
	 * index, comValue 는 컴퓨터의 값.
	 */
	public static void showMessage(int idx, PlayerInfo user, int comValue) {
		if (idx == 0) {
			String msg = "비겼군요!! --> 사용자(" + input + ") : 컴퓨터(" + strValues[comValue] + ")\n" + "전적 --> "
					+ user.getTotal() + " : " + user.getWin() + "승 " + user.getDraw() + "무 " + user.getLose() + "패\n"
					+ "승률 --> " + user.getWin_Rate() + "%";

			// JOptionPane.showMessageDialog 는 msg 의 내용을 팝업으로 뿌려준다.
			JOptionPane.showMessageDialog(null, msg);
		} else if (idx == 1) {
			String msg = "이겼군요!! --> 사용자(" + input + ") : 컴퓨터(" + strValues[comValue] + ")\n" + "전적 --> "
					+ user.getTotal() + " : " + user.getWin() + "승 " + user.getDraw() + "무 " + user.getLose() + "패\n"
					+ "승률 --> " + user.getWin_Rate() + "%";

			JOptionPane.showMessageDialog(null, msg);
		} else if (idx == 2) {
			String msg = "졌군요!! --> 사용자(" + input + ") : 컴퓨터(" + strValues[comValue] + ")\n" + "전적 --> "
					+ user.getTotal() + " : " + user.getWin() + "승 " + user.getDraw() + "무 " + user.getLose() + "패\n"
					+ "승률 --> " + user.getWin_Rate() + "%";

			JOptionPane.showMessageDialog(null, msg);
		}
	}
}
