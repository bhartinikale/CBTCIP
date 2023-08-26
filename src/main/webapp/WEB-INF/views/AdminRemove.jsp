<%@page import="com.jspiders.springmvc1.pojo.AdminPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="NavBar.jsp" />
   <%
List<AdminPOJO> admins = (List<AdminPOJO>) request.getAttribute("admins");
String msg = (String) request.getAttribute("msg");
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Remove Books</title>
<style type="text/css">
form {
	margin-top: 10px;
}
form table {
	margin: auto;
	width: 100%;
}
tr {
	text-align: center;
}
fieldset table {
	margin: auto;
	text-align: left;
}
fieldset {
	margin: 15px 520px;
	text-align: center;
}
legend {
	color: white;
	background-color: #333;
}
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}
#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
<fieldset>
		<legend>:::Remove Books:::</legend>
		<form action="./remove" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Remove"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	if (msg != null) {
	%>
	<h3 align="center">
		<%=msg%>
	</h3>
	<%
	}
	%>
	<%
	if (admins != null) {
	%>
	<table id="data">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Contact</th>
			<th>City</th>
			<th>Username</th>
			<th>Password</th>
		</tr>
		<%
		for (AdminPOJO admin : admins) {
		%>
		<tr>
			<td><%=admin.getId()%></td>
			<td><%=admin.getName()%></td>
			<td><%=admin.getEmail()%></td>
			<td><%=admin.getUsername()%></td>
			<td><%=admin.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>

</body>
</html>