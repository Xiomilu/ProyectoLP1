<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Iniciar Sesión</title>
<!-- Enlace a Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Agrega tus propios estilos personalizados aquí -->
<style>
body {
	background-color: #f8f9fa;
}

.container {
	margin-top: 100px;
}

.card {
	width: 400px;
	margin: auto;
}

.card-header {
	background-color: #007bff;
	color: #fff;
}

.card-body {
	padding: 20px;
}

.form-group {
	margin-bottom: 20px;
}
</style>
</head>
<body>

	<div class="container">
		<div class="card">
			<div class="card-header text-center">
				<h3 class="mb-0">Iniciar Sesión</h3>
			</div>
			<div class="card-body">
				<%-- Mensaje de error si las credenciales son incorrectas --%>
				<%
				if (request.getAttribute("mensaje") != null) {
				%>
				<div class="alert alert-danger" role="alert">
					<%=request.getAttribute("mensaje")%>
				</div>
				<%
				}
				%>

				<form action="ServletUsuario" method="post">
					<div class="form-group">
						<label for="username">Usuario</label> <input type="text"
							class="form-control" id="username" name="username" required>
					</div>
					<div class="form-group">
						<label for="password">Contraseña</label> <input type="password"
							class="form-control" id="password" name="password" required>
					</div>
					<button type="submit" class="btn btn-primary">Iniciar
						Sesión</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Enlace a Bootstrap JS (opcional, solo si necesitas funcionalidades específicas de Bootstrap) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
