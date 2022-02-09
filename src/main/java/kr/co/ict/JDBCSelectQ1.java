package kr.co.ict;

import java.sql.*;
import java.util.Scanner;

public class JDBCSelectQ1 {
	// Scanner를 이용해 uid를 입력받은 다음
	// 방금한 SELECT구문을 응용해서 
	// Where uid = 입력받은 아이디
	// 형식으로 내가 조회한 아이디의 정보만
	// 콘솔에 찍히도록 로직을 작성해주세요
	
	// where uid = '아이디명' 이므로
	// 아이디명 앞뒤로 작은따옴표가 들어갈수 있도록
	// 전달쿼리문을 신경써서 작성해주세요
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("찾으실 uid를 입력해주세요 : " );
		String serchId = scan.nextLine();
		
		try {
			// mysql에 연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			// mysql 로그인 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1?serverTimezone=UTC",
											"root","mysql");
			// 쿼리문 실행을 위한 Statement객체 생성
			Statement stmt = con.createStatement();
			// 실행할 쿼리문을 ResultSet에 담아보냄
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo WHERE uid='" + serchId + "'");
			while(rs.next()) {
				System.out.println("이름 : " + rs.getString(1));
				System.out.println("uid : " + rs.getString(2));
				System.out.println("pw : " + rs.getString(3));
				System.out.println("email : " + rs.getString(4));
			}
			
			// Statement 객체 종료
			// 데이터베이스와 Connection 객체 종료
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
