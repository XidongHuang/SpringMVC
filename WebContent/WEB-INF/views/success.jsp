<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Success Page</h4>
	time:${requestScope.time }
	<br>
	<br>
	names: ${requestScope.names }
	<br>
	<br>
	Request User: ${requestScope.user }
	<br>
	<br>
	Session User: ${sessionScope.user }
	<br>
	<br>
	Request School: ${requestScope.school }
	<br>
	<br>
	Session School: ${sessionScope.school }
</body>
</html>