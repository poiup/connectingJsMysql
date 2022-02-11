package kr.co.ict;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/*
	choice번호 입력후 nextLine()을 사용하면 엔터가 남아서 스킵되는걸로 보임 
	next()를 이용하면 해당 현상이	사라지는것을 확인
*/
public class JDBCIDSControl {
	public static void main(String[] args) {
		Scanner scan  =  new Scanner(System.in);
		// 번호 선택에 따른 데이터베이스 관리 코드
		try {
			// 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 접속
			System.out.println("데이터에 접속합니다 계정과 비밀번호를 적어주세요");
			System.out.println("계정");
			String DBId = scan.nextLine();
			System.out.println("비밀번호");
			String DBPw = scan.nextLine();
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcprac1",DBId, DBPw);
			// 쿼리 전달을위한 객체
			Statement stmt = con.createStatement();	
			while(true) {
				// 조작 방법 설명
				System.out.println("프로그램 종료 : 0 / 데이터 삭제 : 1 /  데이터 추가 : 2 / 데이터 조회 : 3");
				int choice = scan.nextInt();	
				if(choice == 0) {					
					break;
				} else if(choice == 1) {
					System.out.println("삭제하고싶은 유저아이디를 적어주세요");
					String getUid = scan.next();
					// 삭제문
					int deleteUser = stmt.executeUpdate("DELETE FROM userinfo WHERE uid = '"+ getUid +"'");
				} else if(choice == 2) {
					System.out.println("추가할 유저의 이름를 입력해주세요");
					String createName = scan.next();
					System.out.println("추가할 유저의 비밀번호를 입력해주세요");
					String createPw = scan.next();
					System.out.println("추가할 유저의 아이디를 입력해주세요");
					String createId = scan.next();
					System.out.println("추가할 유저의 이메일을 입력해주세요");
					String createEmail = scan.next();
					// 추가문
					int insertRs = stmt.executeUpdate("INSERT INTO userinfo VALUES ('"+createName+"','" +createId+ "','"+createPw+"','" +createEmail+"')");
				} else if(choice == 3) {
					// 조회문
					ResultSet rs = stmt.executeQuery("SELECT * FROM userinfo");
					while(rs.next()) {
						System.out.println("이름 : " + rs.getString(1));
						System.out.println("uid : " + rs.getString(2));
						System.out.println("pw : " + rs.getString(3));
						System.out.println("email : " + rs.getString(4));
						System.out.println("-----------------------");
					}
					rs.close();
				} 
			}
			System.out.println("종료합니다.");
			con.close();
			stmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("프로그램이 종료됩니다");
		}
	}
}
