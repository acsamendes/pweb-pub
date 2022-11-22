<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/estilos.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>UC Mensageria</title>
</head>

<body>
	<div class="container">
		<div class="jumbotron">
			<div>
				<h1>Serviço de Mensageria</h1>
				<hr class="linha">
				<p>Formulário para envio de E-mails</p>
			</div>


			<form action="mensageria" method="post">
				<label for="usuarios">E-mail</label> 
				<select name=email id="usuarios" required>
					<c:forEach items="${listaUsuarios}" var="usu">
						<option value="${usu.email}">${usu.email}</option>
					</c:forEach>

				</select><br>

				<div>
					<input type="radio" id="formal" name="envio" value="formal">
					<label for="formal">Cumprimento Formal</label> 
					<input type="radio" id="horario" name="envio" value="horario"> 
					<label for="horario">Cumprimento conforme horário</label><br>
				</div>

				<input type="checkbox" id="automatico" name="automatico" value="automatico">
				<label for="automatico">Incluir aviso de "E-mail automático"</label> <br>
				
				
				<br> 
				<label for="texto">Título:</label> 
				<input type="text" id="titulo" name="titulo" required> <br> 
				<label for="texto">Texto:</label><br>
				<textarea class="w-100" name="texto" required></textarea>

				<br>
				<input type="submit" class="btn btn-primary" value="Enviar">
				
				
				<a href="index.jsp" class="btn btn-primary">Voltar</a>
			</form>



		</div>
	</div>


</body>

</html>