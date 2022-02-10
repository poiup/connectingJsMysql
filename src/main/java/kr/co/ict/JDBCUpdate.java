package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCUpdate {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1";
		System.out.print("DB아이디 : ");
		String dbid = scan.nextLine();
		System.out.print("DB비밀번호 :");
		String dbpw = scan.nextLine();
		/*
		 UPDATE구문도 처리해보세요
		 UPDATE는 id를 변경하지 않습니다.
		 어떤 아이디의 pw,name,email을 변경할지 조회하기 위해
		 먼저 id를 받고 그다음 pw,name,email을 받아서
		 UPDATE구문에서 조건절에 ID를 넣어 타겟을 정하고
		 나머지 항목만 수정되도록 처리해주세요.
		*/
		
		// update 
		try {
			// db연동
			Class.forName(dbdriver);
			// db로그인
			Connection con = DriverManager.getConnection(dburl, dbid, dbpw);
			// 쿼리전송할 객체생성
			Statement stmt = con.createStatement();
			
			System.out.println("수정될 데이터의 uid");
			String changeUid = scan.next();
			
			System.out.println("수정될 이름");
			String changename = scan.next();
			
			System.out.println("수정될 비밀번호");
			String changepw = scan.next();
			
			System.out.println("수정될 이메일");
			String changeemail = scan.next();
			
			int dbUpdate = stmt.executeUpdate("UPDATE userinfo SET uname = '"+ changename +"', upw = '"+ changepw +"', uemail='"+ changeemail +"' WHERE uid = '" + changeUid+ "'");						
			
							
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
