package javasql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * PreparedStatement 객체 : 자바 SQL 을 사용하는 대표적 객체.
 * 이 객체는 Statement 와는 틀리게 위치폴더(?<--얘)를 사용하는게 특징입니다.
 * Statement 는 SQL 작업시 단점이 한번에 SQL 구문을 다 작성해야 하고,
 * 무엇보다 ''처리가 매우 귀찮습니다.
 * 이 대안으로 Prepared....가 나온겁니다.
 * 
 * 이 객체는 기본 쿼리는 먼저 수행하고, 나중에 위치폴더(?) 를 이용값을 세팅하고
 * SQL 을 실행하도록 합니다. 매우 편함.
 */
public class PreparedEx2 {

	static Connection conn;
	//update를 실행하는 메서드를 정의합니다
	public static void Update(Connection con) {
		conn = con;
		
		//데이터를 수정하는 update구문입니다
		/*
		 * update TableName
		 * Set 업데이트 컬럼명 = value,
		 * 업데이트 컬럼명 = value,
		 * 업데이트 컬럼명 = value,
		 * 업데이트 컬럼명 = value,
		 * 아래는 조건절.. 나중에 봅니다
		 * [where 조건식]
		 */
		String sql = "Update From users SET userpassword = ?" + "where id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"0000");
			pstmt.setString(2, "js");
			System.out.println(pstmt.executeUpdate() + " 개의 행이 변경 되었습니다");
			
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void select(Connection con) {
		conn = con;
		String sql = "Select * from users";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//Select시에는 executeQuery()를 이용합니다
			ResultSet rs = pstmt.executeQuery();
			//while을 이용, ReultSet의 마지막 row까지 이동하여 정보 get
			while(rs.next()) {
				System.out.println("--------------------");
				//getter를 이용해서 정보를 얻어낸다
				String id = rs.getString("userid");
				String pass = rs.getString("userpassword");
				String email = rs.getString("useremail");
				String name = rs.getString("username");
				int age = rs.getInt("useragg");
				
				System.out.println(id + " : " + name + " : " + pass + " : " + email + " : " + age);
				System.out.println("----------------");
						
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//	public static int userDelete(Connection con, String id) {
//		String sql = "Delete From Users Where userid = ?";
//		conn = con;
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.close();
//			conn.close();
//			return pstmt.executeUpdate();
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return 0;
//	}
	public static void main(String[] args) {
		
		Connection conn = null;
		conn = DJDao.getConnection();
		select(conn);
//		String id = "Ssam";
//		int result = userDelete(conn, id);
//		if (result == 1) {
//			System.out.println("축하합니다" + id + "님의 회원탈퇴가 완료됨.");
//		}else {
//			System.out.println(id + "님은 우리 회원이 아니네요");
//		}
//		
//		
//		
		
		
		
		
		
//		update
//		String sql = " Insert into Users (USERID,USERNAME,USERPASSWORD," + "USERAGE,USEREMAIL)"
//				+ "values" + "(?,?,?,?,?)";
//		try {
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			
//			//위치폴더의 값을 세팅합니다. 단, 컬럼타입과 같은 setter 를 호출 해야합니다.
//			//예를 들면 컬럼 타입(값 타입)이 문자열인 경우 setString(,),
//			//정수인 경우 setInt(), 기타 등등..
//			
//			pstmt.setString(1, "hong");
//			pstmt.setString(2, "홍길동");
//			pstmt.setString(3, "0512");
//			pstmt.setInt(4, 22);
//			pstmt.setString(5, "gildong2@naver.com");
//			
//			//Select 를 제외한 DML 은 executeUpdate() 를 이용해서 수행합니다.
//			//리턴값은 DB에 적용된 Rows 를 리턴합니다.
//			if(pstmt.executeUpdate() == 1) {
//				System.out.println("새로운 데이터가 입력 완료됨.");
//			}
//			pstmt.close();
//		}catch (Exception e) {
//			System.out.println("생성오류 : " + e.getMessage());
//		}
	}
}