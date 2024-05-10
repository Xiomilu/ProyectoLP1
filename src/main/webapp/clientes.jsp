<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Registro de clientes</title>
</head>
<body>
<div class="container position-absolute top-50 start-50 translate-middle">
    <div class="row">
        <div class="col-4"></div>
        <div class="col-4 shadow bg-body rounded pb-4">
            <h3>Registrar Cliente</h3>
            <form id="formularioRegistro" action="ClienteServlet" method="post" class="needs-validation" novalidate>
                <div class="form-group">
				    <label>Código</label>
					<input type="text" name="txtCodigo" class="form-control" required>
					<div class="invalid-feedback">Ingrese el código</div>
				</div>
                <div class="form-group">
                    <label>Nombre y Apellido</label>
                    <input type="text" name="txtNombre" class="form-control" required>
                    <div class="invalid-feedback">Ingrese el nombre y apellido del cliente</div>
                </div>
                <div class="form-group">
                    <label>Correo Electrónico</label>
                    <input type="email" name="txtCorreo" class="form-control" required>
                    <div class="invalid-feedback">Ingrese el correo electrónico del cliente</div>
                </div>
                <div class="form-group">
                    <label>Teléfono</label>
                    <input type="tel" name="txtTelefono" class="form-control" required>
                    <div class="invalid-feedback">Ingrese el teléfono del cliente</div>
                </div>
                <div class="form-group mb-3">
                    <label>Dirección</label>
                    <input type="text" name="txtDireccion" class="form-control" required>
                    <div class="invalid-feedback">Ingrese la dirección del cliente</div>
                </div>              
                <button class="btn btn-success" name="tipo" value="registrar" onClick="funcion(this.value)" type="submit">Enviar Datos</button>
				<button class="btn btn-primary" name="tipo" id="btnListar" value="listar" onClick="funcion(this.value)" type="submit">Listar Datos</button>             
            </form>
        </div>
        <div class="col-4"></div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
(() => {
	  'use strict'
	  const forms = document.querySelectorAll('.needs-validation')
	  Array.from(forms).forEach(form => {
	    form.addEventListener('submit', event => {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }
	      form.classList.add('was-validated')
	    }, false)
	  })
	})()
</script>
</body>
</html>