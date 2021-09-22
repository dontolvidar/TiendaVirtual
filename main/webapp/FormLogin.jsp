<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function enviarDatos() {
		var valido = validar();
		if (valido) {
			alert("Los datos son validos");
			var usuario = document.getElementById("txtUser").value.trim();
			var password = document.getElementById("txtPass").value.trim();

			var mensajero = new XMLHttpRequest();
			var url = '/Tienda/SrvRegistroUsuario';
			var params = "user=" + usuario + "&" + "pass=" + password;
			mensajero.open('POST', url, true);

			//Send the proper header information along with the request
			mensajero.setRequestHeader('Content-type',
					'application/x-www-form-urlencoded');

			mensajero.onreadystatechange = function() {//Call a function when the state changes.
				if (mensajero.readyState == 4 && mensajero.status == 200) {
					//alert("datos enviados mensaje desde el server");
					//alert(mensajero.responseText);
					var myDiv = document.getElementById("dvTabla");
					myDiv.innerHTML = "<b>"+"Mensaje "+mensajero.responseText+"</b>";
				}
			}
			mensajero.send(params);
		} else {
			alert("Los datos NO son validos");
		}
	}
	function validar() {
		txtU = document.getElementById("txtUser");
		txtP = document.getElementById("txtPass");

		if (txtU.value.trim().length == 0) {
			alert("No puede estar vacio usuario.");
			return false;
		} else if (txtP.value.trim().length == 0) {
			alert("Se pudo validar");
			return false;
		} else {
			return true;
		}

	}
</script>
</head>
<body>
	<main>
		<h1>Registro del usuario</h1>
		<table>
			<tr>
				<td><label>User name:</label></td>
				<td><input required="required" type="text" id="txtUser"
					name="user"></td>
			</tr>
			<tr>
				<td><label>Password:</label></td>
				<td><input required="required" type="password" id="txtPass"
					name="pass"></td>
			</tr>
		</table>
		<br>
		<br>
		<button onclick="enviarDatos()">Registrar login</button>
		<br>
		<br>
		<%--  --%>
		<a href="FormClientes.jsp">Registro cliente</a>
		<br>
		<br>
		<div id="dvTabla"></div>
	</main>
</body>
</html>