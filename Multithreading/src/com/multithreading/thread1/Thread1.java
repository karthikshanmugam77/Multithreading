package com.multithreading.thread1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.multithreading.UserPojo;
import com.multithreading.connection.ConnectionClass;

public class Thread1 extends Thread {
	
	UserPojo u ;
	

	public Thread1(UserPojo u)
	{
		this.u = u;
	}

	
	public void run()
	{
		try {
			Connection con = new ConnectionClass().getConnection();
			if(con!=null) {
				System.out.println("connection established for thread 1..."); 
			}
			String sql = "insert into table1 values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setString(2,u.getUserName());
			ps.setString(3, u.getPassword());
			ps.execute();
			System.out.println("Data added to table1...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
