<%@page import="java.util.List"%>
<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de Clientes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
   <div class="row">
       <div class="col-1"></div>
       <div class="col-10">
           <h4>Listado de clientes</h4>
           <table class="table table-striped">
              <thead>
                 <tr>
                   <th>Código</th>   
                   <th>Nombre</th>                 
                   <th>Telefono</th>
                   <th>Direccion</th>
                   <th>Correo</th>                 
                 </tr>                 
              </thead>
              <tbody>
                  <%
                        List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
                        for(Cliente item : lista){
                  %>
                        <tr>
                           <td><%=item.getCodigo() %></td>
                           <td><%=item.getNombre() %></td>
                           <td><%=item.getTelefono() %></td>
                           <td><%=item.getDireccion() %></td>
                           <td><%=item.getCorreo() %></td>
                           <td><a class="btn btn-warning" href="ClienteServlet?tipo=editar&codigoCliente=<%=item.getCodigo() %>" role="button">Editar</a></td>
						   <td><a class="btn btn-danger" href="ClienteServlet?tipo=eliminar&codigoCliente=<%=item.getCodigo() %>" role="button">Eliminar</a></td>
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
       <div class="col-10">
               <a class="btn btn-primary" href="../proyectoClientes/clientes.jsp" role="button">Regresar</a> 
       </div>
       <div class="col-1"></div>
   </div>
</div>
</body>
</html>
