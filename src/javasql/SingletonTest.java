package javasql;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.sql.Connection;
import java.sql.Statement;

public class SingletonTest {
	
	DJDao dao;
	
	public static void main(String[] args) {
		
		SingletonTest s = new SingletonTest();
		s.dao = DJDao.getInstance();
		//컨넥션 정보를 얻어냅니다.
		Connection con = DJDao.getConnection();
		System.out.println(con);
		
		//SQL 을 작업하는데만 집중하면 됨.. 즉 불필요한 코드가 없음.
		//SQL 을 날리는 작업을 할건데, 이것도 pattern 이 정해져있음.
		//2개의 객체(interface) 를 주로 사용하는데, Statement, PreparedStatement임.
		//위 2개의 객체는 Connection 객체의 메서드를 호출하면 자동 리턴됨. 찾아보세요.
		try {
			Statement stmt = con.createStatement ();
			//Insert 쿼리를 생성합니다.
			//기본쿼리 문법 Insert into 테이블명 [(column1,2,3,4)]
			//Values (컬럼의 순서대로 값1,값2,값3...);
			/*USERID
			USERNAME
			USERPASSWORD
			USERAGE
			USEREMAIL
			*/
			String sql = " Insert into Users (USERID,USERNAME,USERPASSWORD," + "USERAGE,USEREMAIL)"
					+ "values ('Ssam','노재현','1111',30,'text@text.com')";
			int affectRows = stmt.executeUpdate(sql);
			System.out.println(affectRows == 0? " Insert 안됨 " : " Insert 완료 ");
			
			//DB 이용을 다 했으면, Open 된 역순으로 닫습니다.
			stmt.close();
			con.close();
			
		}catch (Exception e) {
			System.out.println("생성 오류 : " + e.getMessage());
		}
//		DJDao d1 = DJDao.getInstance();
//		DJDao d2 = DJDao.getInstance();
//		DJDao d3 = DJDao.getInstance();
//		DJDao d4 = DJDao.getInstance();
//		DJDao d5 = DJDao.getInstance();
//		
//		System.out.println(d4 + " : " + d5);
//		System.out.println(d4.equals(d5));
//		System.out.println(d4 == d5);
	}
}