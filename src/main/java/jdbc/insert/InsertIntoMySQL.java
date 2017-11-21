package jdbc.insert;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.SpeedTest;
import jpa.User;
import util.Util;


public class InsertIntoMySQL {
	
	public InsertIntoMySQL() throws Exception {
		
		SpeedTest.start();
		
		createTable();
		
		SpeedTest.end();
	}
	
	private void createTable() throws Exception {
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arka","arek", "arek");
		
		Statement st =  conn.createStatement();
		//st.execute("create table if not exists user (id int, name varchar(255), surname varchar(255)); ");
		
		//addToDB(conn);
		
		//ResultSet rs = st.executeQuery("select count(*) from user");
		ResultSet rs = st.executeQuery("select count(*) from user where name='Arek';");
		
		rs.next();
		System.out.println("Counter: "+rs.getInt(1));		
		
		rs.close();
        st.close();
        conn.close();
	}
	
	private void addToDB(Connection conn) throws Exception {
		for(int i=1; i<=1000000; i++) {
			User u = Util.getRandomUser();
			String sql = "insert into user values (?, ?, ?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);

			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, u.getName());
			preparedStatement.setString(3, u.getSurname());
			preparedStatement.executeUpdate();
		}
		System.out.println("Finished Adding");
	}
	
	public static void main(String[] args)  throws Exception {
		new InsertIntoMySQL();
	}

	
}
