<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String uId = (String)session.getAttribute("login_pass");
	
	if(uId == null) {
		response.sendRedirect("login_form.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#login_box {
		width : 300px;
		padding : 10px;
		border : solid #000 1px;
		border-radius : 10px;
		text-align : center;
		margin: 0 auto;
	}
	h1{
		font-size : 20px;
	}
	button {
		width : 100px;
	}
	button > a {
		display : block;
		height : 100%;
		width: 100%;
		text-decoration : none;
		color : #000;
		font-weight: bold;
		
	}
</style>
</head>
<body>
	<div id="login_box">
		<h1><%= uId %>님 로그인을 환영합니다!</h1>
		<button><a href="logout.jsp">로그아웃</a></button>
	</div>
</body>
</html>