<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Estoque</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Editar produto</h1>
	<form name="formProduto" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="idEdit" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="descricao" class="descricao"
					value="<%out.print(request.getAttribute("descricao"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="preco" class="numero"
					value="<%out.print(request.getAttribute("preco"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="estoque" class="numero"
					value="<%out.print(request.getAttribute("estoque"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="botao" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>