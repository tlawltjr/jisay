package javasql.model1.viewer;

import java.util.Scanner;

import javasql.model1.daos.ModelDAO;
import javasql.model1.model.MemberDTO;

/*
 * 사용자의 가입 정보를 입력 받아서 DTO에 세팅 후, DAO를 이용해서
 * 가입완료를 시킵니다
 */
public class Reg_Member {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사용할 ID를 입력해 주세요 : ");
		String id = sc.nextLine();
		//ID 검증 로직 메서드를 호출해서 validation 결과를 리턴합니다
		//중복 ID가 있는지도 검사(DAO메서드를 이용합니다)
		//위 validation이 ok시에만 다음 입력값을 받도록 합니다
		
		System.out.println("사용할 암호를 입력해 주세요 : ");
		String password = sc.nextLine();
		
		System.out.println("Email을 입력해주세요 : ");
		//필요하다면 email도 validation합니다. 즉, 이메일 형식 검사도 하지만 
		//중복되는 email이 있는지도 검사하면 좋겠네요(DAO메서드를 이용합니다)
		String email = sc.nextLine();
		
		System.out.println("나이 입력해주세요 : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.println("이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		MemberDTO member = new MemberDTO();
		member.setUserAge(age);
		member.setUserEmail(email);
		member.setUserId(id);
		member.setUserName(name);
		member.setUserPassword(password);
		
		//DTO셋업 완료. 다음은 DAO의 메서드 호출해서 Insert 하면 됩니다
		int result = ModelDAO.getInstance().regMember(member);
		
		if(result != 0) {
			System.out.println(member.getUserName() + "님 회원 가입이 완료되었습니다");
		}else {
			System.out.println("화원 가입에 서버문제가 발생함");
		}
	}

}
