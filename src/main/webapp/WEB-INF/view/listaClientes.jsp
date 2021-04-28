<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilos.css"/>
<title>Lista de Clientes</title>
</head>
<body>
	<h1>Gestión de Clientes</h1>
	<input class="boton" type="button" value="Alta Cliente" onclick="window.location.href='altaCliente'; return false"/>
		<table border="1">
			<tr>
				<th class="tablaClientes">Nombre</th>
				<th class="tablaClientes">Apellido</th>
				<th class="tablaClientes">Email</th>
				<th class="tablaClientes">Update</th>
				<th class="tablaClientes">Delete</th>
			</tr>
			<c:forEach var="cliente" items="${clientes}">
				<!-- Link para actualizar -->
				<c:url var="linkUpdate" value="/cliente/actualizarCliente">
					<c:param name="idCliente" value="${cliente.id}"/>
				</c:url>
				<!-- Link para eliminar -->
				<c:url var="linkDelete" value="/cliente/eliminarCliente">
					<c:param name="idCliente" value="${cliente.id}"/>
				</c:url>
				<tr>
					<td class="tablaClientes2">${cliente.nombre}</td>
					<td class="tablaClientes2">${cliente.apellido}</td>
					<td class="tablaClientes2">${cliente.email}</td>
					<td class="tablaClientes2"><a href="${linkUpdate}"><input type="button" value="Modificar"></a></td>
					<td class="tablaClientes2"><a href="${linkDelete}"><input type="button" value="Eliminar" 
					onclick="if(!(confirm('¿Estás seguro de que quieres eliminar este registro?'))) return false"></a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>