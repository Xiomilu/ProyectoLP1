<%@page import="model.Producto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Productos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <h4>Listado de Productos</h4>
            <table  class="table table-striped">
                <thead>
                    <tr>
                        <th>Código Producto</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Stock</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Producto> lista = (List<Producto>)request.getAttribute("listaProductos");
                        for(Producto item : lista){
                    %>
                        <tr>
                            <td><%=item.getCodigoProducto() %></td>
                            <td><%=item.getNombreProducto() %></td>
                            <td><%=item.getDescripcionProducto() %></td>
                            <td><%=item.getStock() %></td>
                            <td><%=item.getPrecio() %></td>
                            <td><a class="btn btn-warning" href="ProductoServlet?tipo=editar&codigoProducto=<%=item.getCodigoProducto() %>" role="button">Editar</a></td>
                            <td><a class="btn btn-danger" href="ProductoServlet?tipo=eliminar&codigoProducto=<%=item.getCodigoProducto() %>" role="button">Eliminar</a></td>
                            
                        </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <div class="col-2"></div>
    </div>
    <div class="row">
        <div class="col-2"></div>
        <div class="col-8">
            <!-- Ajusta el href al servlet o URL que se usará para regresar o navegar -->
            <a class="btn btn-primary" href="registroEscate.jsp" role="button">Regresar</a>
        </div>
        <div class="col-2"></div>
    </div>
</div>
</body>

</html>