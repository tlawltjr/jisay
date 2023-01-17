package javasql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * DAO 는 Data Access Object 라는 개념으로, 모든 외부객체들은 DB 와의 접속 및
 * 정보 조회(Select), 삽입(Insert), 갱신(update), 삭제(Delete) 를
 * 반드시 이 객체만을 통해 하도록 하는 개념의 객체입니다.
 * 
 * 따라서 오직 이 클래스만이 DB와 컨넥션 정보와 함께 위 작업을 하도록 구현 하겠다는 말입니다.
 */
public class DJDao {
	
	private static DJDao dao = new DJDao();
	//count 멤버필드선언.
	int instanceCount = 0;
	//컨넥션을 내부에서 하나만 생성하고 외부에는 메서드를 이용해서 Connection 만 주도록 합니다.
	private static Connection conn;
	static {//Static 초기화 구문. 클래스로드시 무조건 제일 일순위임.
		try {
			//1.Driver 클래스를 로딩합니다.
			Class.forName("oracle.jdbc.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##js", "0000");
			
			System.out.println("컨넥션 ok 정보 --> " + conn);
			/*
			if(conn != null) {
				conn.close();
			}
			*/
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버를 찾을 수 없습니다." + e.getMessage());
		}catch (SQLException e) {
			System.out.println("컨넥션 정보가 틀립니다" + e.getMessage());
		}
	}//End of Static Statement
	
	//컨넥션 정보는 많은 리소스를 차지하기 때문에 보통 하나만 생성해서 사용합니다.
	//DAO 는 Singleton 으로 생성해서 해당 인스턴스가 생성 될시에
	//컨넥션을 얻어내고 필요한 객체에게 메서드를 통해 전달하거나, 아니면
	//아예 자체적으로 컨넥션을 감추고, 외부에는 메서드만 통해서 Data에 대한
	//정보만 얻고 DB 입출력은 자신이 하는 방법도 있습니다.
	//이 클래스에서는 첫번째 방법을 이용하고, 추후엔 2번째 방법으로 변경예정입니다.
	private DJDao() {
	//	++instanceCount;
	}	
	
	public static DJDao getInstance() {
		return dao;
	}
	//외부에 Connection 을 전달하는 Interface 메서드.
	public static Connection getConnection() {
		return conn;
	}


	}