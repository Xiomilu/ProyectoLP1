<%@page import="model.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Editar Clientes</title>
</head>
<body>
<% 
                Cliente clienteData = (Cliente)request.getAttribute("clienteData");
%>
<div class="container position-absolute top-50 start-50 translate-middle">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4 shadow bg-body rounded pb-4">
            <h3>Editar Cliente</h3>
            <form id="formularioRegistro" action="ClienteServlet" method="post" class="needs-validation" novalidate>
          
            <div class="form-group">
            <label>Código Cliente</label>
            <input type="text" name="txtCodigo" class="form-control" value="<%= clienteData.getCodigo() %>" readonly required>
            <div class="invalid-feedback">Ingrese el código del cliente</div>
            </div>
    
            <div class="form-group">
            <label>Nombre Cliente</label>
            <input type="text" name="txtNombre" class="form-control" value="<%= clienteData.getNombre() %>" required>
            <div class="invalid-feedback">Ingrese el nombre del cliente</div>
            </div>
    
            <div class="form-group">
            <label>Teléfono Cliente</label>
            <input type="text" name="txtTelefono" class="form-control" value="<%= clienteData.getTelefono() %>" required>
            <div class="invalid-feedback">Ingrese el teléfono del cliente</div>
            </div>
    
            <div class="form-group">
            <label>Dirección Cliente</label>
            <input type="text" name="txtDireccion" class="form-control" value="<%= clienteData.getDireccion() %>" required>
            <div class="invalid-feedback">Ingrese la dirección del cliente</div>
            </div>
    
            <div class="form-group mb-3">
            <label>Correo Electrónico Cliente</label>
            <input type="email" name="txtCorreo" class="form-control" value="<%= clienteData.getCorreo() %>" required>
            <div class="invalid-feedback">Ingrese el correo electrónico del cliente</div>
            </div>
    
            <button class="btn btn-success" name="tipo" value="actualizar" type="submit">Actualizar Cliente</button>
            <a href="./ClienteServlet" class="btn btn-primary">Regresar</a>
</form>

        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
    (() => {
        'use strict'
        // Script para manejar la validación del formulario antes del envío
        const forms = document.querySelectorAll('.needs-validation')
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()  // Previene el envío del formulario si no es válido
                    event.stopPropagation()  // Detiene la propagación del evento
                }
                form.classList.add('was-validated')  // Agrega la clase de validación visual
            }, false)
        })
    })()
</script>
</body>
</html>