<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Cadastro de Produto</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<h1 class="display-4">Cadastro de Usuários</h1>
			<div class="principal">
				<p>Preencha os campos com os dados necessários</p>
				<hr class="linha">
				<div class="formulario">

					<form action="cadastroUsuario" method="post">
						<label for="nome"> Nome:</label> 
						<input class="textoInput" type="text" name="nome" required><br> 
						<label for="email"> Email:</label>
						<input type="email" id="email" name="email" pattern=".+@gmail.com" size="30" required><br>

						<input class="btn btn-primary" type="submit" value="Salvar">
						<a href="index.jsp" class="btn btn-primary">Voltar</a>
					</form>
				</div>
			</div>
		</div>
		<div>
			<c:if test="${not empty mensagem1}">
				<div class="alert alert-danger" role="alert">${mensagem1}</div>
			</c:if>
			<c:if test="${not empty mensagem2}">
				<div class="alert alert-success" role="alert">${mensagem2}</div>
			</c:if>
		</div>
	</div>




	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>