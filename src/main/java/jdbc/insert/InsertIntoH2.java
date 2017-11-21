package jdbc.insert;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;

import util.SpeedTest;
import jpa.User;
import util.Util;


public class InsertIntoH2 {
	
	public InsertIntoH2() throws Exception {
		
		Server server = Server.createTcpServer().start();
		SpeedTest.start();
		
		Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/d:/aaaa/Data/Data", "ark", "arek");
		
		Statement st =  conn.createStatement();
		st.execute("create table if not exists user (id int, name varchar_ignorecase(255), surname varchar_ignorecase(255)); ");
		
		//addToDB(conn);
		
		ResultSet rs = st.executeQuery("select count(*) from user");
		
		rs.next();
		System.out.println("Counter: "+rs.getInt(1));		
		
		rs.close();
        st.close();
		conn.close();
		SpeedTest.end();
		server.stop();
	}
	
	
	private void addToDB(Connection conn) throws Exception {
		for(int i=1; i<=10000000; i++) {
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
		new InsertIntoH2();
	}

	
}
//http://www.h2database.com/html/tutorial.html

//java org.h2.tools.Script -url jdbc:h2:~/test -user sa -script test.zip -options compression zip
//java org.h2.tools.RunScript -url jdbc:h2:~/test -user sa -script test.zip -options compression zip

//The Backup tool (org.h2.tools.Backup) can not be used to create a online backup; the database must not be in use while running this program.
