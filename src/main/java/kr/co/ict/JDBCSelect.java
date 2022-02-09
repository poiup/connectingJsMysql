package kr.co.ict;
// SQL 관련된 요소는 java.sql.*을 임포트하면 대부분이 다 로드됩니다.
import java.sql.*;

public class JDBCSelect {

	public static void main(String[] args) {
		// JDBC연결 여부 확인
		
		// MYSQL을 연동할것임을 알리기위해 forName 내부에 MySQL용 연동구문을 적습니다.
		// SQL연동은 try~catch블럭 내부에 넣도록 강제됨.
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 커넥션 객체는 연결 여부를 확인합니다.
			// 입력 요소는 접속주소, mysql계정명, mysql비밀번호 순으로 입력합니다.
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1", // 접속url
														"root", //mysql아이디
														"mysql"); // mysql비밀번호
			
			// 쿼리문을 연결된 mysql에 날려주기위해 쿼리문을 준비합니다.
			// 쿼리문은 Statement라는 변수에 저장해 날려줍니다.
			
			Statement stmt = con.createStatement();
			
			// executeQuery("")안에 실행할 쿼리문을 적어줍니다.
			// SELECT문을 실행한 결과 자료는 ResultSet이란 자료로 받을수 있습니다.
			ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");
			
			// stmt.exeuteUpdate()는 SELECT이외의 구문, INSERT와 DELETE와 UPDATE를 실행할때 씁니다.
			
			// ResultSet은 기본적으로 row개수만큼 내부에 데이터를 저장합니다. col의 개수만큼의 배열을 만들어 저장합니다
			// ResultSet은 특정 번호를 집어서 조회하는 경우보다는 순차적으로
			// 조회해서 쓰는경우가 많습니다.
			// 맨 처음 ResultSet은 -1번이라는 임시번호를 타겟으로 잡습니더.
			// 이 번호를 옮기기 위해 .next()를 호출하면 다음번호로 넘어갑니다.
			// rs.next(); // 다음 번호가 조회되면 true, 없으면 false
			// get자료형(인덱스번호) or get자료형(컬럼명)을 쓰면
			// 해당 컬럼의 자료를 반환합니다
			// System.out.println(rs.getString(1));
			// System.out.println(rs.getString(2));
			// System.out.println(rs.getString(3));
			// System.out.println(rs.getString(4));
			
			// while문을 이용해서 select구문의 전체 결과를
			// 콘솔에 찍어주세요
			// 1,4번 컬럼은 컬럼명으로 2,3번 컬럼은 인덱스로 출력
			boolean DBcheck = rs.next();
			while(DBcheck) {
				// DB내용 출력
				System.out.println(rs.getString("uname"));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString("uemail"));
				System.out.println("----"+DBcheck+"-------");
				// rs다음으로 넘기고 다음데이터 있는지 확인
				DBcheck = rs.next();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
