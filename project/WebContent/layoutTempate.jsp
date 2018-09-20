<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String inc_page = 
	(String)request.getAttribute("inc_page");
	if(inc_page == null){
		inc_page = "basic.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		width : 800px;
		margin : auto;
		border : 1px solid orange;
	}
	header{
		height : 150px;
		background: orange;
	}
	#main{
		height : 500px;
	}
	#main_left{
		height : 500px;
		width : 200px;
		float : left;
		background: skyblue;
	}
	#main_right{
		height : 500px;
		width : 600px;
		float : left;
		background: green;
	}
	#bottom{
		height : 150px;
	}
</style>
</head>
<body>
	<section id = "wrap">
		<header>
			<h1>위</h1>
		</header>
		<section id = "main">
			<aside id = "main_left">
			<h1>메뉴</h1>
			</aside>
			<section id = "main_right">
			<jsp:include page="<%=inc_page %>"></jsp:include>
			</section>
		</section>
		<footer id = "bottom">
			<h1>아래</h1>
		</footer>
	</section>
</body>
</html>






