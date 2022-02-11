package kr.co.ict;

import java.sql.*;
import java.util.Scanner;
public class JDBCpstmtInsert {
	public static void main(String[] args) {
		// Insert 구문을 작성해주세요
		// 변수로 접속 정보를 관리합니다.
		Scanner scan = new Scanner(System.in);
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbid = "root";
		String dbpw = "mysql";
		
		try {
			// DB 정의
			Class.forName(dbdriver);
			// DB 접속
			Connection con = DriverManager.getConnection(dburl, dbid, dbpw);
			// 쿼리문 생성
			String sql = "INSERT INTO userinfo VALUES (?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			// 생성할 유저 정보 입력
			System.out.println("유저의 이름을 입력해주세요");
			String uname = scan.nextLine();
			System.out.println("유저의 아이디를 입력해주세요");
			String uid = scan.nextLine();
			System.out.println("유저의 비밀번호를 입력해주세요");
			String upw = scan.nextLine();
			System.out.println("유저의 이메일을 입력해주세요");
			String uemail = scan.nextLine();
			// ?칸 채우기
			pstmt.setString(1, uname);
			pstmt.setString(2, uid);
			pstmt.setString(3, upw);
			pstmt.setString(4, uemail);
			
			int pstmtIns = pstmt.executeUpdate();
			// 수정이 잘됫는지 확인
			// 조회구문으로 쿼리 수정
			sql = "SELECT * FROM userinfo WHERE uid = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			
			// 출력
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
