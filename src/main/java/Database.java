import java.sql.*;
import java.sql.Statement;

public class Database {
	Connection conn=null;
	Statement stm=null;
	public Database(String url,String username,String pass) {
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,username,pass);
		stm = conn.createStatement();
		 }
		 catch(Exception e) {
			 
		 }
	}
	boolean insert(String name, String email, String password,String file_url) {
		try {
		PreparedStatement pstm = conn.prepareStatement("insert into jspdata(name,email,password,file_url) values(?,?,?,?)");
		pstm.setString(1, name);
		pstm.setString(2, email);
		pstm.setString(3, password);
		pstm.setString(4, file_url);
		return pstm.execute();
	}
		catch(Exception e) {
			return false;
		}

	}
}
