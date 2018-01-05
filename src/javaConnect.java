import java.sql.*;
import javax.swing.JOptionPane;

public class javaConnect {
	Connection conn;
	
	public static Connection ConnectionDb(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\NILOY\\Desktop\\JAVA\\Library\\LibraryNew.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful!!");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	

}
