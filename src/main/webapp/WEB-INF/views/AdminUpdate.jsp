<%@page import="com.jspiders.springmvc1.pojo.AdminPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="NavBar.jsp" />
<%
AdminPOJO admin = (AdminPOJO) request.getAttribute("admin");
List<AdminPOJO> admins = (List<AdminPOJO>) request.getAttribute("admins");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Books</title>
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
</style>
</head>
<body>
	<%
	if (admin != null) {
	%>
	<fieldset>
		<legend>:::Update Books</legend>
		<form action="./updateData" method="post">
			<table>
				<tr hidden="true">
					<td>ID</td>
					<td><input type="text" value="<%=admin.getId()%>" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" value="<%=admin.getName()%>"
						name="name"></td>
				</tr>
				<td>Email</td>
				<td><input type="text" value="<%=admin.getEmail()%>"
					name="email"></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><input type="text" value="<%=admin.getUsername()%>"
						name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" value="<%=admin.getPassword()%>"
						name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%
	} else {
	%>
	<fieldset>
		<legend>:::Select Books:::</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Enter ID</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Select"></td>
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
			<th>Username</th>
			<th>Password</th>
		</tr>
		<%
		for (AdminPOJO adminData : admins) {
		%>
		<tr>
			<td><%=adminData.getId()%></td>
			<td><%=adminData.getName()%></td>
			<td><%=adminData.getEmail()%></td>
			<td><%=adminData.getUsername()%></td>
			<td><%=adminData.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	}
	%>
</body>
</html>