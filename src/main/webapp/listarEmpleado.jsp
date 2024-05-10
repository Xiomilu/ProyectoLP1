<%@page import="model.Empleado"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Empleados</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

<div class="container">
	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
			<h3>
			<%
				String titulo = "Listar Empleados";
			%>
			<%=titulo %>
			<span class="badge text-bg-secondary">Nuevo</span>
			</h3>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Còdigo</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">DNI</th>
		      <th scope="col">Rol</th>
		      <th scope="col">Email</th>
		      <th scope="col">Celular</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider"	>
			<%
			List<Empleado> lista=(List<Empleado>)request.getAttribute("lista");
			for(Empleado item : lista){
				//imprimiendo en java
				//out.println("<tr><td>"+item.getCodigo()+"</td></tr>");
			%>
				<tr>
					<td><%=item.getCodigo()%></td>
					<td><%=item.getNombre()%></td>
					<td><%=item.getApellido()%></td>
					<td><%=item.getDni()%></td>
					<td><%=item.getRol()%></td>
					<td><%=item.getEmail()%></td>
					<td><%=item.getTelefono()%></td>
					<td>
				      <a class="btn btn-success" href="EmpleadoServlet?tipo=editar&codigoEmpleado=<%=item.getCodigo() %>" role="button">Editar</a>
				      <a class="btn btn-danger" href="EmpleadoServlet?tipo=eliminar&codigoEmpleado=<%=item.getCodigo() %>"  role="button">Eliminar</a>
		      		</td>
	
				</tr>
			<%
			}
		%>
	
		  </tbody>
		</table>
		</div>
		<div class="col-1"></div>
	</div>
		<div class="row">
		<div class="col-1"></div>
		<div class="col-8">
			<a class="btn btn-primary" href="../ProyectoTiendaCuartoCiclo" role="button">Regresar</a>
		</div>
		<div class="col-3"></div>
	</div>
</div>

</body>
</html>