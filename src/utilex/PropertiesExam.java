package utilex;

import java.io.IOException;
import java.util.Properties;

public class PropertiesExam {

	public static void main(String[] args) throws IOException {
		/*
		 * 1.Properties 기본 객체 생성한다.
		 * 2.Properties 파일을 스트림(Stream) 을 통해 접근(Access) 한다.
		 * 3.getProperty(key) 를 통해 키 정보를 주면 Value 를 리턴한다.
		 */
		Properties prop = new Properties();
		//prop.load(Properties.class.getResourceAsStream("db.properties"));
		//위 방법이 안되면 ClassLoader 를 통해 프로퍼티스 파일에 대한 스트림을 생성한다.
		prop.load(ClassLoader.getSystemResourceAsStream("db.properties"));
		/*
		 * url:oracle:thin:@localhost:1521:orcl
			driver:oracle.jdbc.driver.OracleDriver
			username:jason
			password:1111
			admin:administrator
		 */
		
		String url = prop.getProperty("url");
		String driver = prop.getProperty("driver");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String admin = prop.getProperty("admin");
		
		
		System.out.println(url);
		

	}

}
