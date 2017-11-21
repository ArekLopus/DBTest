package jdbc.insert;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import util.SpeedTest;
import jpa.User;
import util.Util;


public class InsertIntoMSSQL {
	
	public InsertIntoMSSQL() throws Exception {
		
		SpeedTest.start();
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=arka;user=arek;password=arek");
		
		Statement st =  conn.createStatement();
		//st.execute("create table user2 (id int, name varchar(255), surname varchar(255));");
		
		//addToDB(conn);
		
		//ResultSet rs = st.executeQuery("select count(*) from user2");
		ResultSet rs = st.executeQuery("select count(*) from user2 where name='Arek';");
		
		rs.next();
		System.out.println("Counter: "+rs.getInt(1));		
		
		rs.close();
        st.close();
        conn.close();
        SpeedTest.end();
	}
	
	
	private void addToDB(Connection conn) throws Exception {
		for(int i=1; i<=1000000; i++) {
			User u = Util.getRandomUser();
			String sql = "insert into user2 values (?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, u.getName());
			preparedStatement.setString(3, u.getSurname());
			preparedStatement.executeUpdate();
		}
		System.out.println("Finished Adding");
	}
	
	public static void main(String[] args)  throws Exception {
		new InsertIntoMSSQL();
	}

	
}
