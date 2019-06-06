package com.lbms.util;

import java.sql.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.lbms.interfaces.Dbutil_Interface;


@Component("dbUtil")
@Scope("prototype")
public class Dbutil implements Dbutil_Interface {

	Connection con;
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/springlbms","root","root");
			}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;	
	}
	
	@Override
	public void closeConnection() {
	
		try {
		con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
