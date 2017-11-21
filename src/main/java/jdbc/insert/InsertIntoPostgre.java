package jdbc.insert;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SpeedTest;


public class InsertIntoPostgre {
	
	public InsertIntoPostgre() throws Exception {
		
		String scr = new File(getClass().getResource("/sql/script.sql").getFile()).getPath();
		System.out.println("Script: "+scr);
		
		//org.h2.tools.RunScript.execute("jdbc:h2:d:/aaaa/Data/Data","ark","arek", scr, null, false);
		
		SpeedTest.start();
		//Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5430/postgres","postgres", "arek");
		
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
		new InsertIntoPostgre();
	}

	
}
