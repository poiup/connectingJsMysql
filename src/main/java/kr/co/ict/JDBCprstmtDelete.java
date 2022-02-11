package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCprstmtDelete {
	public static void main(String[] args) {
		// DELETE 구문을 실행하는 코드를 작성해보세요
		//삭제의 기준은 uid가 일치하는 자료를 삭제합니다.
		
		// 작성 순서
		// 1. 스캐너로 삭제할 회원 uid입력받기
		// 2. DB와 자바 연결
		// 3. 쿼리문에 ?를 포함해 작성한후 PreparedStatement 객체 생성
		// 4. 실행
		// * 접속 정보는 변수로 관리해주세요
		Scanner scan = new Scanner(System.in);
		System.out.println("삭제할 uid를 입력해주세요");
		String uid = scan.nextLine();
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbid = "root";
		String dbpw = "mysql";
		try {
			// DB 정의
			Class.forName(dbdriver);
			// DB연결
			Connection con = DriverManager.getConnection(dburl, dbid, dbpw);
			// 쿼리작성
			String sql = "DELETE FROM userinfo WHERE uid=?";
			// 쿼리 전송을위한 객체 생성
			PreparedStatement pstmt = con.prepareStatement(sql);
			// 쿼리 ?칸채우기
			pstmt.setString(1, uid);
			// 쿼리 실행
			int pstmtDel = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
