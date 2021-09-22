<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<main>
		<h1>Registro del usuario</h1>
		<form action="/Tienda/SrvRegistroUsuario" method="get">
			<table>
				<tr>
					<td>
						<label>User name:</label>
					</td>
					<td>
						<input required="required" type="text" id="txtUser" name="user">
					</td>
				</tr>
				<tr>
					<td>
						<label>Password:</label>
					</td>
					<td>
						<input required="required" type="password" id="txtPass" name="pass">
					</td>
				</tr>
			</table>
			<input type="submit" value="Submit">
		</form>
		<br><br>
		<a href="RegCliente.jsp">Registro cliente</a>
	</main>
</body>
</html>