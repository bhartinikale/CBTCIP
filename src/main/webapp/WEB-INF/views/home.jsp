<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
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
<h1 align="center">ADMIN LOGIN</h1>
<fieldset>
		<legend>:::Login to proceed:::</legend>
		<form action="./Login" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
				<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>

<h1 align="center">USER LOGIN</h1>
<fieldset>
		<legend>:::Login to proceed:::</legend>
		<form action="./Login" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td><input type="text" name="username"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
				<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>	
</body>
</html>