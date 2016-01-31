package info;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SuperDao {
	public String database = "server";
	public String user_name = "root";
	public String password = "onlyroot"; // 서버의 비밀번호와 아피주소 변경
	// String server = "218.147.80.197:3306";
	public String server = "localhost:3306";

	public Connection conn = null ;
	
	public void closeConnection() {		
		try {
			if(conn != null){ conn.close() ;}
		} catch (SQLException e) {

			e.printStackTrace();
		} 
	}
	
	public SuperDao() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = getConnection(); //단계 2 : 접속 객체 구하기
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
	}
	//커넥션 구하기
	private Connection getConnection() {		
		try {
			return DriverManager.getConnection("jdbc:mysql://" + server + "/"
					+ database, user_name, password);
		} catch (SQLException e) {			
			e.printStackTrace();
			return null ;
		}
	}

}
