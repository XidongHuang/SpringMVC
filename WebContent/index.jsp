<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>





	<a href="helloworld">Hello World</a>
	<br>
	<br>
	<a href="spingmvc/testRequestMapping">Test RequestMapping</a>
	<br>
	<br>
	<a href="spingmvc/testMethod">Test Method</a>
	<br>
	<br>
	<form action="spingmvc/testMethod" method="POST">
		<input type="submit" value="submit" />
	</form>
	<br>
	<br>
	<a href="spingmvc/testParamsAndHeaders?username=tony&age=10">Test
		ParamsAndHeaders</a>
	<br>
	<br>
	<a href="spingmvc/testAntPath/mnxyc/abc">Test testAntPath</a>
	<br>
	<br>
	<a href="spingmvc/testPathVariable/1">Test PathVariable</a>
	<br>
	<br>
	<a href="spingmvc/testRest/1">Test REST Get</a>
	<br>
	<br>
	<form action="spingmvc/testRest" method="post">
		<input type="submit" value="TestRest POST" />
	</form>
	<br>
	<br>
	<form action="spingmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE" /> <input
			type="submit" value="TestRest DELETE" />
	</form>
	<br>
	<br>
	<form action="spingmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT" /> <input
			type="submit" value="TestRest PUT" />
	</form>
	<br>
	<br>
	<a href="spingmvc/testRequestParam?username=tony&age=11">Test
		RequestParam</a>
	<br>
	<br>
	<a href="spingmvc/testRequestHeader">Test testRequestHeader</a>
	<br>
	<br>
	<a href="spingmvc/testCookieValue">Test CookieValue</a>
	<br>
	<br>
	<form action="spingmvc/testPojo" method="post">
		username: <input type="text" name="username" /> <br> password: <input
			type="password" name="password" /> <br> email: <input
			type="text" name="email" /> <br> age: <input type="text"
			name="age" /> <br> city: <input type="text" name="address.city" />
		<br> province: <input type="text" name="address.province" /> <br>
		<input type="submit" value="Submit">

	</form>

</body>
</html>