package javasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * 이 클래스는 JDBC Driver 설정이 제대로 되었는지 확인하는 클래스입니다.
 * 기본적으로 Connection 객체가 Java 와 DB(Oracle) 간의 통신을 하도록 하는 객체인데,
 * 이 객체제 Null 로 떨어지지마 않으면 정상적으로 연결되어진겁니다.
 * 위 Connection 이 연결된것만 확인 후 SQL을 처리하는 부분을 이어서 설명할게요.
 * 
 * JDBC 연결 순서입니다. 위 Connection 객체를 얻기 위한 순서이며,
 * 이 순서는 불변입니다.. 즉 외우지말고 그냥 가져다 쓰는거에요.
 * 단, DB에 따라서 연결값은 틀릴 수 있으나, 순서는 같습니다.
 * 
 * 1.Class Class 를 이용해서 JDBC 드라이버를 로딩 해야합니다.
 * 이 때 사용하는 메서드가 forName("JDBC DriverName") 입니다.
 * 제대로 build path 가 설정되면 JDBC 드라이버가 로딩되어집니다.
 * 참고로 오라클의 드라이버 이름은 oracle.jdbc.OracleDriver 입니다.(대소문자 주의)
 * 
 * 2.위에서 JDBC 드라이버가 제대로 로딩되었다면, 다음은 DriverManager 인터페이스를
 * 이용해서 Connection 을 맺습니다. 이때 제대로 연결 값이 설정되었다면, 위 메니저는
 * 연결 정보(즉 유저 스키마 정보) 를 담고 있는 Connection 객체를 리턴합니다.
 * 연결 정보값은 DB마다 틀린데, 오라클은 아래와 같습니다(이 또한 불변입니다. 만 11g
 * 하위는 조금씩 틀릴 수 있습니다. 현재 우리가 사용하는 Oracle 은 21C 입니다.)
 * 2.1 드라이버 매니저에 들어갈 연결정보는 아래와 같음
 * 2.1.1 Oracle 서버의 정보(즉 jdbc:oracle:thin:@ip or 도메인이름:port/xe(우리가
 * 사용하는 DB는 xe라서 처음 인스톨시 SID 를 주게 되어있는데, default 가 xe 입니다.
 * 만약 다른 Edition(Oracle EnterPrise Server or Standard etc) 등을 사용하게 되면
 * 보통은 orcl(변경하지 않을시) 이 기본값입니다.
 * 
 * 2.1.2 두번째 파라미터로는 접근할 Scheme(스키마) 정보입니다. 계정 ID
 * 2.1.3 세번째 파라미터로는 위 계정의 암호값 입니다.
 * 
 * 3. 위 정보가 모두 올바르면 Connection 이 맺어지고 해당 객체를 리턴합니다.
 * 
 * 4.리턴된 Connection 을 받은후부터는 SQL 을 날려서 DML(데이터 조작), DDL(데이터 정의) 등을 할 수 있게 됩니다.
 */
public class ConnectionTestEx {

	public static void main(String[] args) {
		
		Connection conn;
		
	try {
		//1.Driver 클래스를 로딩합니다.
		Class.forName("oracle.jdbc.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##js", "0000");
		
		System.out.println("컨넥션 ok 정보 --> " + conn);
		
		if(conn != null) {
			conn.close();
		}
		
	} catch (ClassNotFoundException e) {
		System.out.println("오라클 드라이버를 찾을 수 없습니다." + e.getMessage());
	}catch (SQLException e) {
		System.out.println("컨넥션 정보가 틀립니다" + e.getMessage());
	}
	}
}