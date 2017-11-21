package jdbc.connection;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SpeedTest;


public class MySQLTestConn {
	
	public MySQLTestConn() throws Exception {
		
		String scr = new File(getClass().getResource("/sql/script.sql").getFile()).getPath();
		System.out.println("Script: "+scr);
		
		//org.h2.tools.RunScript.execute("jdbc:h2:c:/aaaa/Data/Data","ark","arek", scr, null, false);
		
		SpeedTest.start();
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arka","arek", "arek");
				
		Statement st =  conn.createStatement();
		ResultSet rs = st.executeQuery("select * from test");
		
//		rs.next();
//		System.out.println("Id="+rs.getInt("id")+",\tname: "+rs.getString("name"));
//		rs.next();
//		System.out.println("Id="+rs.getInt("id")+",\tname: "+rs.getString("name"));
		while (rs.next()) {
            System.out.println("Id="+rs.getInt("id")+",\tname: "+rs.getString("name"));
        }
		
		rs.close();
        st.close();
		conn.close();
		SpeedTest.end();
	}
	
	public static void main(String[] args)  throws Exception {
		new MySQLTestConn();
	}

	
}
//http://www.h2database.com/html/tutorial.html

//java org.h2.tools.Script -url jdbc:h2:~/test -user sa -script test.zip -options compression zip
//java org.h2.tools.RunScript -url jdbc:h2:~/test -user sa -script test.zip -options compression zip

//The Backup tool (org.h2.tools.Backup) can not be used to create a online backup; the database must not be in use while running this program.
