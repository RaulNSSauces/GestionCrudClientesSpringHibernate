<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
<title>Alta Cliente</title>
</head>
<body>
	<h1>Dar de alta a un cliente</h1>
	<form:form action="insertarCliente" modelAttribute="cliente" method="POST">
		<form:hidden path="id"/>
			<table border="1">
				<tr>
					<td class="tablaClientes">Nombre: </td>
					<td class="tablaClientes"><form:input path="nombre"/></td>
				</tr>
				<tr>
					<td class="tablaClientes">Apellido: </td>
					<td class="tablaClientes"><form:input path="apellido"/></td>
				</tr>
				<tr>
					<td class="tablaClientes">Email: </td>
					<td class="tablaClientes"><form:input path="email"/></td>
				</tr>
				<tr>
					<td class="tablaClientes" colspan="2"><input type="submit" value="Alta/Modificar"><input type="button" value="Página anterior" onClick="history.go(-1);"></td>
				</tr>
			</table>
	</form:form>
</body>
</html>