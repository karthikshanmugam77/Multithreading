package com.multithreading.thread2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.multithreading.UserPojo;
import com.multithreading.connection.ConnectionClass;

public class Thread2 extends Thread {
	
	UserPojo u ;
	

	public Thread2(UserPojo u)
	{
		this.u = u;
	}

	
	public void run()
	{
		try {
			Connection con = new ConnectionClass().getConnection();
			if(con!=null) {
				System.out.println("connection established for thread 2..."); 
			}
			String sql = "insert into table2 values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, u.getUserId());
			ps.setString(2,u.getUserName());
			ps.setString(3, u.getPassword());
			ps.execute();
			System.out.println("Data added to table-2...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}



}
