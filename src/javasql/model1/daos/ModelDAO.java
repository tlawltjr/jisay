package javasql.model1.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javasql.model1.model.MemberDTO;

public class ModelDAO {
/*
 * 외부에 Instance를 제공하는 메서드와 기타, SQL을 처리하는 메서드만 
 * 제외하고는 모두 private으로 처리한다
 */
	//asd
	private static Connection conn;
//	private static final String acount;//지울 곳
//	private static final String accPass;
//	private static final String dbSchema;
//	
//	static {
//		acount = "c##js";
//		accPass = "0000";
//		dbSchema = "jdbc:oracle:thin:@localhost:1521/xe";
//	}
	private static ModelDAO dao = new ModelDAO();
	
	private ModelDAO() {
	}
	/*
	 *  이 메서드는 DAO인스턴스 생성시에 필요한 초기화 작업을 모두 처리합니다
	 *  현재는 Connection만 맺도록 하는 작업만 처리합니다
	 */
	
	public static ModelDAO getInstance() {
		return dao;
	}
	/*
	 * 모든 사용자 정보를 리턴하는 메서드 정의합니다
	 * 이 메서드는 모든 사용자 정보이기 때문에 따로 파라미터는 받지 않고 
	 * Select * from Users;로 조회 SQL을 날립니다
	 * 이때 리턴되어지는 모든 Row는 각 1:1로 MemberDTO에 담고
	 * 이 담겨진 DTO객체들은 ArrayList에 담아서 전달을 하게됩니다
	 * 이걸 받은 ShowAllMember 클래스는 받은 정보를 모두 출력하게 됩니다
	 * 연결고리를 잘파악하세요
	 */
	
	public List<MemberDTO> getAllMember(){
		List<MemberDTO> members = Collections.EMPTY_LIST;
		MemberDTO dto = null;
		String sql = "Select * from Users";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			//데이터가 존재한다면
			if(rs.next()) {//if절로 커서를 Data 테이블로 내리고
				//DTO가 담겨질 AllaList를 생성합니다
				members = new ArrayList<MemberDTO>();
				do {
					//여기서부터 첫번째 Row 데이터를 get합니다
					//하나의 row는 하나의 DTO에 Mapping되기에 여기서
					//DTO객체를 생성해서 setter를 호출하여 DTO를 완성시킵니다
					dto = new MemberDTO();
					dto.setReg_Date(rs.getDate("reg_date"));
					dto.setUserAge(rs.getInt("userage"));
					dto.setUserEmail(rs.getString("useremail"));
					dto.setUserId(rs.getString("userid"));
					dto.setUserName(rs.getString("username"));
					dto.setUserPassword(rs.getString("userpassword"));
					
					//dto의 값이 모두 완료되면 members에 담습니다
					members.add(dto);
					
				}while(rs.next());
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return members;
	}
	
	
	//ID가 존재여부에 대한 validation 메서드 정의
	public int isMember(String id) {
		int result = 0;
		//조건절 조회 where userid = ? --> userid 컬럼값 중에 파라미터로 
		//넘어온 id가 존재하는지 조건절 select 입니다
		//아래의 sql증 count()함수는 파라미터인 컬럼을 기준으로 
		//id가 존재한다면 그 개수(count)를 리턴하는 oracle함수입니다
		//즉 id가 존재한다면. 1이 리턴할겁니다. 이유는 ID는 PK(Primary key)로 
		//제약(Constraints)를 줬기 때문에 무조건 중복 불가입니다.(DB시간에 더 배움)
		String sql = "Select count(userid) from Users Where userid = ?";
		try{
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			//조회(Select)는 executeQuery(sql)을 실행해야 합니다
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
			return result;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	public boolean checkPassword(String id, String password) {
		String sql = "Select userpassword from Users where userid = ?";
		boolean result = false;
		
		Connection conn = getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					String dbPass = rs.getString("userPassword");
					//사용자가 입력한 값과 비교합니다
					if(dbPass.equals(password)) {
						return result = true;
					}
				}while(rs.next());
			}
		}catch (Exception e) {
			// TODO: handle exception
		}return result = false;
	}
	
	
	private void closer(Connection conn) {
		if(this.conn != null) {
			try {
				conn.close();
			}catch (Exception e) {
				System.out.println("DB close시 예외 발생함" + e.getMessage());
			}
		}
	}
	//내부에서 사용한 Connection 리턴 메서드 정의
	private static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "c##js", "0000");
			
			System.out.println("컨넥션 ok 정보 --> " + conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Connection 생성시 예외 발생함");
			System.out.println("예외 내용 : " + e.getMessage());
		}
		return conn;
	}
	//회원가입이나 게시판의 새글등이 DB에 쓰여지도록(insert)메서드를 구현합니다
	//일단 회원가입이라 생각하고 모든 정보는 DTO에 담겨져서 받도록 합니다
	//이 DTO를 DB에 Insert만 하도록 정의합니다
	
	
	public int regMember(MemberDTO dto) {
		int result = 0;//만약 가입이 안될 경우의 리턴값 초기화
		String sql = "Insert into Users (USERID,USERNAME,USERPASSWORD," + "USERAGE,USEREMAIL,REG_DATE) Values(?,?,?,?,?,sysdate)";
		//오라클에서 시스템의 현재 시간을 Date로 리턴하는 함수 sysdate를 사용해서 
		//사용자의 가입날짜를 세팅합니다
		
		//Connection 얻도록 합니다
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, dto.getUserPassword());
			pstmt.setInt(4, dto.getUserAge());
			pstmt.setString(5, dto.getUserEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null)
				try {
					pstmt.close();
					//closer();//Connection Close메서드 호출
				}catch (Exception e2) {
					// TODO: handle exception
				}
		}
		return result;
	}
	public int deleteMember(String id) {

		String sql = "Delete from users where userid = ?";
		Connection conn = getConnection();
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public MemberDTO getMember(String id) {
		MemberDTO dto = null;
		String sql = "Select * from users where userid = ?";
		PreparedStatement pstmt = null;
		Connection conn = getConnection();
		
		
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {//if절로 커서를 Data 테이블로 내리고
			//DTO가 담겨질 AllaList를 생성합니다
			
			do {
				//여기서부터 첫번째 Row 데이터를 get합니다
				//하나의 row는 하나의 DTO에 Mapping되기에 여기서
				//DTO객체를 생성해서 setter를 호출하여 DTO를 완성시킵니다
				dto = new MemberDTO();
				dto.setReg_Date(rs.getDate("reg_date"));
				dto.setUserAge(rs.getInt("userage"));
				dto.setUserEmail(rs.getString("useremail"));
				dto.setUserId(rs.getString("userid"));
				dto.setUserName(rs.getString("username"));
				dto.setUserPassword(rs.getString("userpassword"));
				
				//dto의 값이 모두 완료되면 members에 담습니다
			
				
			}while(rs.next());
			pstmt.close();
			conn.close();
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
		return dto;
	}
		
	

}
