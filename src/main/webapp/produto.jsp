<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>


<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Cadastro de produtos</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<h1>Cadastro de Produtos</h1>
	<a href="novo.html" class="botao">Novo Produto</a>
	<a href="report" class="botao">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Descrição</th>
				<th>Preço</th>
				<th>Estoque</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getDescricao()%></td>
				<td><%=lista.get(i).getPreco()%></td>
				<td><%=lista.get(i).getEstoque()%></td>
				<td><a href="edit?id=<%=lista.get(i).getId()%>"
					class="botaoEditar">Editar</a> <a
					href="javascript: confirmaExclusao(<%=lista.get(i).getId()%>)"
					class="botaoExcluir">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
