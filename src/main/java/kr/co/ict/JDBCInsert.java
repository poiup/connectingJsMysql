package kr.co.ict;

import java.util.Scanner;
import java.sql.*;
public class JDBCInsert {
	public static void main(String[] args) {
		// scanner로 id,pw,name,email을 입력받아
		// Insert Into 구문을 이용해 DB에 데이터를 적재하도록 만들어보겠습니다.
		Scanner scan = new Scanner(System.in);	
		System.out.println("추가할 유저의 이름를 입력해주세요");
		String createName = scan.nextLine();
		System.out.println("추가할 유저의 비밀번호를 입력해주세요");
		String createPw = scan.nextLine();
		System.out.println("추가할 유저의 아이디를 입력해주세요");
		String createId = scan.nextLine();
		System.out.println("추가할 유저의 이메일을 입력해주세요");
		String createEmail = scan.nextLine();
		
		try {
			// mysql에 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// mysql접속
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1",
															"root", "mysql");	
			
			Statement stmt = con.createStatement();
			// 추가 구문
			int insertRs = stmt.executeUpdate("INSERT INTO userinfo VALUES ('"+createName+"','" +createId+ "','"+createPw+"','" +createEmail+"')");
			
			// 조회 구문
			// executeQurey은 결과를 받아와서 보여주기때문에 ResultSet를 사용하지만
			// executeUpdate는 결과를 보여줄 필요가 없이 값만 받아가기 때문에 ResultSet을 사용하지 않음
			ResultSet selectRs = stmt.executeQuery("SELECT * FROM userinfo");
			while(selectRs.next()) {
				System.out.println(selectRs.getString(1));
				System.out.println(selectRs.getString(2));
				System.out.println(selectRs.getString(3));
				System.out.println(selectRs.getString(4));
				System.out.println("----------------------------");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		// SELECT Q1처럼 작성해주시되
		// SELECT구문을 제외한 나머지 INSERT,DELETE,UPDATE구문은
		// 결과 데이터가 없기 때문에 실행했을때 에러가 나지 않는다면 
		// 우선 실행된것으로 볼수 있고, 실행이 된 다음 워크벤치에서
		// 데이터가 들어갔는지 확인해주시면 됩니다.
		
		// 쿼리문 실행시 SELECT구문은 executeQuery() 를 호출했지만
		// SELECT이외 구문은 executeUpdate()구문을 호출합니다
	}
}
