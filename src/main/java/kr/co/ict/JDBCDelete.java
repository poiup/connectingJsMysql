package kr.co.ict;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.*;
public class JDBCDelete {
	public static void main(String[] args) {
		
		
		
		/*
		try {
			// 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 접속
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1","root", "mysql");
			
			// 쿼리 전달을위한 객체
			Statement stmt = con.createStatement();
			// 삭제문
			int deleteUser = stmt.executeUpdate("DELETE FROM userinfo WHERE uid = '"+ getUid +"'");
			
			// 조회문
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("uid : " + rs.getString(2));
				System.out.println("pw : " + rs.getString(3));
				System.out.println("email : " + rs.getString(4));
				System.out.println("-----------------------");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		*/
	}
}
