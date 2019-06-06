package com.lbms.main;

import java.sql.*;

import com.lbms.interfaces.AdminUserLogin;
import com.lbms.util.*;
import java.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		//Object of Scanner class
		Scanner scan=new Scanner(System.in);
		
		System.out.println("Please select 1 option: 1. Admin  2. Student");
		
		int response=scan.nextInt();
		
		
		//Scanning Email and password for verification
		
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");

		AdminUserLogin login=context.getBean("loginDao",AdminUserLogin.class);
		
		if(response==1) {
			System.out.println("Please Enter email:");
			String email=scan.next();
			
			
			System.out.println("Please Enter the password");
			String password=scan.next();
			
			
			
			if(login.loginAdmin(email,password)) {
				System.out.println("Welcome Sir,");
				System.out.println("What you want to do?");
				System.out.println("1. Add Book 2. Show Books 3.Delete Books 4. Update Books");
				
				int number=scan.nextInt();
				
				if(number==1) {
					System.out.println("Will do Something");
				}
				else if(number==2) {
					
				}
				else if(number==3) {
					
				}
				else if(number==4) {
					
				}
			}
			else {
				System.out.println("Wrong Email or password");
			}
			
			
			context.close();
		}
		
		
		
		
		
		
		
		

	}

}
