import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
	Conn(){
	
	  try {
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  c=DriverManager.getConnection("jdbc:mysql://localHost:3306/hotelmanagementsystem","root","Incapp@12");
	  s=c.createStatement();
	  
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
}
