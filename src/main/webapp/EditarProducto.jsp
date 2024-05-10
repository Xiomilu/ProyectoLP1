
<%@page import="model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <meta charset="ISO-8859-1">
    <title>Editar Producto</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h3>Editar Producto</h3>
            <!-- Extracción del objeto productoData de los atributos de la solicitud -->
            <% 
                Producto productoData = (Producto)request.getAttribute("productoData");
            %>
            <!-- Formulario para enviar los datos actualizados del producto al servidor -->
            <form action="ProductoServlet" method="post" class="needs-validation" novalidate>
                <input type="hidden" name="tipo" value="actualizar">
            
                <!-- Campo de código de producto (no editable para evitar cambios) -->
                <div class="form-group">
                    <label for="codigoProducto">Código Producto</label>
                    <input type="text" id="codigoProducto" name="txtCodigoProducto" class="form-control" value="<%= productoData.getCodigoProducto() %>" readonly required>
                    <div class="invalid-feedback">Ingrese el código del producto</div>
                </div>
                <!-- Campo de nombre de producto -->
                <div class="form-group">
                    <label for="nombreProducto">Nombre Producto</label>
                    <% if (productoData != null) { %>
                    <input type="text" id="nombreProducto" name="txtNombreProducto" class="form-control" value="<%= productoData.getNombreProducto() %>" required>
                    <% } else { %>
                 <!-- Mostrar algún mensaje de error o redirigir -->
                <p>Producto no encontrado.</p>
                 <% } %>
                    
                    <div class="invalid-feedback">Ingrese el nombre del producto</div>
                </div>
                <!-- Campo de descripción de producto -->
                <div class="form-group">
                    <label for="descripcionProducto">Descripción Producto</label>
                    <textarea id="descripcionProducto" name="txtDescripcionProducto" class="form-control" required><%= productoData.getDescripcionProducto() %></textarea>
                    <div class="invalid-feedback">Ingrese la descripción del producto</div>
                </div>
                <!-- Campo de stock de producto -->
                <div class="form-group">
                    <label for="stockProducto">Stock</label>
                    <input type="number" id="stockProducto" name="txtStock" class="form-control" value="<%= productoData.getStock() %>" required>
                    <div class="invalid-feedback">Ingrese el stock del producto</div>
                </div>
                <!-- Campo de precio de producto -->
                <div class="form-group mb-3">
                    <label for="precioProducto">Precio</label>
                    <input type="text" id="precioProducto" name="txtPrecio" class="form-control" value="<%= productoData.getPrecio() %>" required>
                    <div class="invalid-feedback">Ingrese el precio del producto</div>
                </div>
                <!-- Botones para enviar o cancelar la actualización del producto -->
                <button class="btn btn-success" type="submit" name="btnAccion" value="actualizar">Actualizar Producto</button>
                <a href="./ProductoServlet?accion=listar" class="btn btn-primary">Regresar</a>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
<!-- Carga de JavaScript de Bootstrap para manejo de validaciones del formulario -->
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
