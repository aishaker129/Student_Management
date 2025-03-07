package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			
			// jdbc code....
			
			Connection con = CP.createC();
			String q = "insert into student(sname,sphone,scity) values(?,?,?)";
			
			// PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// set the value of parameter
			pstmt.setString(1, st.getSname());
			pstmt.setString(2, st.getSphone());
			pstmt.setString(3, st.getScity());
			
			// execute...
			pstmt.executeUpdate();
			f = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f = false;
		try {
			
			// jdbc code....
			
			Connection con = CP.createC();
			String q = "delete from student where sid=?";
			
			// PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			// set the value of parameter
			pstmt.setInt(1, userId);
			
			// execute...
			pstmt.executeUpdate();
			f = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAlldata() {
		try {
			
			// jdbc code....
			
			Connection con = CP.createC();
			String q = "select * from student";
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				System.out.println(".......................................");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public static boolean modify(Student st) {
		boolean f = false;
		try {
			Connection con = CP.createC();
			String q = "update student set  sname = ? ,sphone = ? ,scity = ? where sid = ?";
			PreparedStatement ptmt = con.prepareStatement(q);
			
			ptmt.setString(1, st.getSname());
			ptmt.setString(2, st.getSphone());
			ptmt.setString(3, st.getScity());
			ptmt.setInt(4, st.getSid());
			
			ptmt.executeUpdate();
			f = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

}
