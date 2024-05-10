<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Registro Empleados</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-4"></div>
		<div class="col-4"> 
			<h3>Registrar Empleado</h3>
			<form id="formularioRegistro" action="EmpleadoServlet?type=registrar" method="post" Class="needs-validation" novalidate>
				<div class="form-group mb-3"  >
					<label>Còdigo</label>
					<input type="text" name="txtCodigo" class="form-control" required>
					<div class="invalid-feedback">Ingrese Id</div>
				</div>
				<div class="form-group mb-3" >
					<label>Nombre</label>
					<input type="text" name="txtNombre" class="form-control" required>
					<div class="invalid-feedback">Ingrese Nombre </div>
				</div>
					<div class="form-group mb-3">
					<label>Apellido</label>
					<input type="text" name="txtApellido" class="form-control" required>
					<div class="invalid-feedback">Ingrese Apellido</div>
				</div>
				<div class="form-group mb-3">
					<label>DNI</label>
					<input type="text" name="txtDNI" class="form-control" required>
					<div class="invalid-feedback">Ingrese DNI</div>
				</div>
				<div class="form-group mb-3">
					<label>Rol</label>
					<input type="text" name="txtRol" class="form-control" required>
					<div class="invalid-feedback">Ingrese Rol</div>
				</div>
				<div class="form-group mb-3">
					<label>Email</label>
					<input type="email" name="txtemail" class="form-control" required>
					<div class="invalid-feedback">Ingrese Email vàlido</div>
				</div>
				<div class="form-group mb-3">
					<label>Telèfono</label>
					<input type="text" name="txtTelefono" class="form-control" required>
					<div class="invalid-feedback">Ingrese Telèfono</div>
				</div>
				<button class="btn btn-success" name="btnEnviar" value="registrar" onClick="funcion(this.value)" type="submit">Guardar Datos</button>
				<button class="btn btn-primary" name="btnEnviar" value="listar" onClick="funcion(this.value)" type="submit">Listar Datos</button>
				
				
			</form>
		</div>
		<div class="col-4"></div>
	
	</div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script type="text/javascript">
function funcion(value){
	if(value=="registrar"){
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
		
	}
}
</script>
</body>
</html>