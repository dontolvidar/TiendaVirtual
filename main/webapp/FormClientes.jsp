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
		<h1>Registro del cliente</h1>
		<form action="/Tienda/SrvRegistroClientes" method="get">
			<label for="txtCedula">Cedula:</label>
			<input type="number" id="txtCedula" name="cedula">
			<br> <br>
			<label for="txtNombre">Nombre Completo:</label>
			<input type="text" id="txtNombre" name="nombre">
			<br> <br>
			<label for="txtDireccion">Direccion:</label>
			<input type="text" id="txtDirec" name="direccion">
			<br> <br>
			<label for="txtTelefono">Telefono:</label>
			<input type="number" id="txtTel" name="telefono">
			<br> <br>
			<label for="txtEmail">Email:</label>
			<input type="email" id="txtEmail" name="email">
			<br> <br>
			<input type="submit" value="Crear cliente">
		</form>
	</main>
</body>
</html>