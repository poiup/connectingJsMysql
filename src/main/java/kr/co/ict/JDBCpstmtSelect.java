package kr.co.ict;

import java.sql.*;
import java.util.Scanner;

public class JDBCpstmtSelect {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 uid를 적어주세요");
		String uId = scan.nextLine();
		String dbdriver = "com.mysql.cj.jdbc.Driver";
		String dburl = "jdbc:mysql://localhost:3306/jdbcprac1";
		String dbid = "root";
		String dbpw = "mysql";
		try {
			// DB타입지정
			Class.forName(dbdriver);
			// DB연결
			Connection con = DriverManager.getConnection(dburl,dbid,dbpw);
			// preparedStatement구문은 먼저 SQL쿼리문을 만들어 놓고 적용합니다.
			// 중간에 사용자 입력 정보를 받는 부분을 전부 ?로만 치환해서 처리합니다.
			// ?는 2이상도 쓸수 있습니다.
			String sql = "SELECT * FROM userinfo WHERE uid=?";
			// pstmt변수를 만들어 세팅합니다.
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?에 들어갈 자료를 정의해줍니다.
			pstmt.setString(1,uId);// 1번 ?자리에 uId를 넣어주겠다는 의미
			// setString으로 처리하면 자동으로 uId안에 ''가 붙습니다.
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
