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


public class InsertIntoOracle {
	
	public InsertIntoOracle() throws Exception {
		
		SpeedTest.start();
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orctest","arek","arek");
		
		Statement st =  conn.createStatement();
		//st.execute("create table users (id int, name varchar2(255), surname varchar2(255));");
		
		addToDB();
		
		ResultSet rs = st.executeQuery("select count(*) from user2");
		//ResultSet rs = st.executeQuery("select count(*) from users where name='Arek';");
		
		rs.next();
		System.out.println("Counter: "+rs.getInt(1));		
		
		rs.close();
        st.close();
        conn.close();
        SpeedTest.end();
	}
	
	
	private void addToDB() throws Exception {
		for(int i=1; i<=1000000; i++) {
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orctest","arek","arek");
			User u = Util.getRandomUser();
			String sql = "insert into users values (?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, u.getName());
			preparedStatement.setString(3, u.getSurname());
			preparedStatement.executeUpdate();
			
			conn.close();
			
		}
		System.out.println("Finished Adding");
	}
	
	
	public static void main(String[] args)  throws Exception {
		new InsertIntoOracle();
	}

	
}
