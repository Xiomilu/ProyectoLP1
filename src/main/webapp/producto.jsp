<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Examen Escate</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-4"></div>
		<div class="col-md-4">
			<h3>Registrar Producto</h3>
			<form action="ProductoServlet" method="post" class="needs-validation" novalidate>
			               
			
				<div class="form-group">
					<label for="codigoProducto">Código Producto</label>
					<input type="text" id="codigoProducto" name="txtCodigoProducto" class="form-control" required>
					<div class="invalid-feedback">Ingrese el código del producto</div>
				</div>
				<div class="form-group">
					<label for="nombreProducto">Nombre Producto</label>
					<input type="text" id="nombreProducto" name="txtNombreProducto" class="form-control" required>
					<div class="invalid-feedback">Ingrese el nombre del producto</div>
				</div>
				<div class="form-group">
					<label for="descripcionProducto">Descripción Producto</label>
					<textarea id="descripcionProducto" name="txtDescripcionProducto" class="form-control" required></textarea>
					<div class="invalid-feedback">Ingrese la descripción del producto</div>
				</div>
				<div class="form-group">
					<label for="stockProducto">Stock</label>
					<input type="number" id="stockProducto" name="txtStock" class="form-control" required>
					<div class="invalid-feedback">Ingrese el stock del producto</div>
				</div>
				<div class="form-group mb-3">
					<label for="precioProducto">Precio</label>
					<input type="text" id="precioProducto" name="txtPrecio" class="form-control" required>
					<div class="invalid-feedback">Ingrese el precio del producto</div>
				</div>
				<button class="btn btn-success" type="submit" name="tipo" value="registrar">Registrar Producto</button>
<button class="btn btn-info" type="submit" name="tipo" value="listar">Listar Productos</button>

			</form>
		</div>
		<div class="col-md-4"></div>
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