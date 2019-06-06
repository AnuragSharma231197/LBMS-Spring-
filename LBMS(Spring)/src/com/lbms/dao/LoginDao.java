package com.lbms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.lbms.bean.LoginBean;
import com.lbms.interfaces.AdminUserLogin;
import com.lbms.interfaces.Dbutil_Interface;
import java.sql.*;

@Component("loginDao")
public class LoginDao implements AdminUserLogin{

	
	Dbutil_Interface dbutil;
	
	@Autowired
	public LoginDao(Dbutil_Interface dbutil) {
		this.dbutil=dbutil;
	}
	
	
	@Override
	public boolean loginAdmin(String email, String password) {
		boolean result=false;
		
		Connection con=dbutil.getConnection();
		
		try {
		PreparedStatement pst=con.prepareStatement("select * from login where email=? and password=?");
		pst.setString(1, email);
		pst.setString(2, password);
		ResultSet rs=pst.executeQuery();
		
		if(rs.next()) {
			result=true;
		}
		else {
			result=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
