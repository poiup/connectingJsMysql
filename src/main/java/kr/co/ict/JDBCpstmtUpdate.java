package kr.co.ict;

import java.util.Scanner;
import java.sql.*;

public class JDBCpstmtUpdate {
	public static void main(String[] args) {
		// UPDATE 구문을 Scanner 로 입력받은 자료를 토대로 실행하는 로직을 작성해주세요.
		// 변수로 접속정보를 관리합니다.
		Scanner scan = new Scanner(System.in);
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbid = "root";
		String dbpw = "mysql";
		
		try {			
			// DB정의
			Class.forName(dbdriver);
			// DB접속
			Connection con = DriverManager.getConnection(dburl,dbid,dbpw);
			
			// UPDATE 구문 받기
			String update = "UPDATE userinfo SET uname=?,upw = ?, uemail = ? WHERE uid = ?";
			PreparedStatement pstmt = con.prepareStatement(update);
			
			// 수정할 데이터 받기
			// uid
			System.out.println("수정하고싶은 유저의 아이디를 적어주세요");
			String uid = scan.nextLine();
			pstmt.setString(4,uid);
			
			// uname
			System.out.println("이름 수정");
			String uname = scan.nextLine();
			pstmt.setString(1,uname);
			
			// upw
			System.out.println("비밀번호 수정");
			String upw = scan.nextLine();
			pstmt.setString(2,upw);
			
			// uemail
			System.out.println("이메일 수정");
			String uemail = scan.nextLine();
			pstmt.setString(3,uemail);

			int pstmtUpdate = pstmt.executeUpdate();
			// 수정이 잘됫는지 확인
			// 조회구문으로 쿼리 수정
			String sql = "SELECT * FROM userinfo WHERE uid = ? ";
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
			// .close() 로 열린 자료 닫기
			// 일반 자바코드는 어차피 코드실행이 끝나면 프로그램이 종료되지만
			// 서버의 경우 코드실행이 끝나도 서버가 계속 돌아가 자원회수를 안해주면 시스템에 부하가 걸릴수있음
			// 이를막기위해 .close()로 자원을 회수해줘야됨
			con.close();
			pstmt.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
