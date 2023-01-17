package javasql.model1.viewer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import javasql.model1.daos.ModelDAO;

public class DeleteMember {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("회원 탈퇴하려면 ID입력 해 : ");
		String id = sc.nextLine();
		String password = null;
		if(ModelDAO.getInstance().isMember(id)==0) {
			System.out.println("존재하지 않는 ID입니다");
		}else {
			System.out.println("암호 입력해 : ");
			password = sc.nextLine();
			//암호 검증
			if(ModelDAO.getInstance().checkPassword(id, password)) {
				//암호까지 맞다면, 삭제 로직 구현함
				if(ModelDAO.getInstance().deleteMember(id) == 1) {
					System.out.println(id + "님 회원탈퇴 ㅅㄱ");
				}
			}else {
				System.out.println("비밀번호가 틀립니다");
			}
		}
	}
}
