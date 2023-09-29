<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.EventoService" %>
<%@ page import="service.UserService" %>
<%@ page import="service.AdminService" %>
<%@ page import="service.IngressoService" %>
<%@ page import="model.Evento" %>
<%@ page import="model.User" %>
<%@ page import="model.Admin" %>
<%@ page import="model.Ingresso" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teste</title>
</head>

<body>

	<h1> Listar evento </h1>
	
	<%
		EventoService service = new EventoService();
	
		List<Evento> lista = service.listarEventos();
		
		out.println("<table style='margin-bottom: 2rem; border: solid 2px'>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Titulo </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Data do Evento </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Hora </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Bairro </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Estado </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Rua </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Descrição </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Política </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Min. Lot. </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Max. Lot. </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Status </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Min. Idade </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID da Categoria </th>");
		out.println("<th style='width: 10%; border-bottom: solid 1px'> ID do Admin </th>");

	for(Evento evento: lista) {
		out.println("<tr>");
			out.println("<td>" + evento.getId() + "</td>");
			out.println("<td>" + evento.getTitulo() + "</td>");
			out.println("<td>" + evento.getData_evento() + "</td>");
			out.println("<td>" + evento.getHora() + "</td>");
			out.println("<td>" + evento.getBairro() + "</td>");
			out.println("<td>" + evento.getEstado() + "</td>");
			out.println("<td>" + evento.getRua() + "</td>");
			out.println("<td>" + evento.getDescricao() + "</td>");
			out.println("<td>" + evento.getPolitica() + "</td>");
			out.println("<td>" + evento.getMin_lotacao() + "</td>");
			out.println("<td>" + evento.getMax_lotacao() + "</td>");
			out.println("<td>" + evento.getStatus() + "</td>");
			out.println("<td>" + evento.getMin_idade() + "</td>");
			out.println("<td>" + evento.getCategoria_id() + "</td>");
			out.println("<td>" + evento.getAdmin_id() + "</td>");
		out.println("</tr>");
	}
	
	out.println("</table>");
	%>
	
	<h1> Listar Users </h1>
	
	<%
		UserService service2 = new UserService();
	
		List<User> lista2 = service2.listarUsers();
	
		out.println("<table style='margin-bottom: 2rem; border: solid 2px'>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Email </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Senha </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Nome </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Username </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Data de Nasc. </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> CPF </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Endereço </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> CEP </th>");
		out.println("<th style='width: 10%; border-bottom: solid 1px'> Admin? </th>");

		for(User user: lista2) {
			out.println("<tr>");
				out.println("<td>" + user.getId() + "</td>");
				out.println("<td>" + user.getEmail() + "</td>");
				out.println("<td>" + user.getSenha() + "</td>");
				out.println("<td>" + user.getNome() + "</td>");
				out.println("<td>" + user.getUsername() + "</td>");
				out.println("<td>" + user.getDtNascimento() + "</td>");
				out.println("<td>" + user.getCpf() + "</td>");
				out.println("<td>" + user.getEndereco() + "</td>");
				out.println("<td>" + user.getCep() + "</td>");
				out.println("<td>" + user.getStatus_admin() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
	%>
	
		<h1> Listar Admins </h1>
	
	<%
		AdminService service3 = new AdminService();
	
		List<Admin> lista3 = service3.listarAdmins();
	
		out.println("<table style='margin-bottom: 2rem; border: solid 2px'>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Status </th>");
		out.println("<th style='width: 10%; border-bottom: solid 1px'> ID do Usuário </th>");

		for(Admin admin: lista3) {
			out.println("<tr>");
				out.println("<td>" + admin.getId() + "</td>");
				out.println("<td>" + admin.getStatus() + "</td>");
				out.println("<td>" + admin.getUser_id() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
	%>
	
			<h1> Listar Ingressos </h1>
	
	<%
		IngressoService service4 = new IngressoService();
	
		List<Ingresso> lista4 = service4.listar();
	
		out.println("<table style='margin-bottom: 2rem; border: solid 2px'>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Valor </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Quantidade </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> Descrição </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> QR Code </th>");
		out.println("<th style='width: 10%; border-right: solid 1px; border-bottom: solid 1px'> ID do Usuário </th>");
		out.println("<th style='width: 10%; border-bottom: solid 1px'> ID do Evento </th>");

		for(Ingresso ingresso: lista4) {
			out.println("<tr>");
				out.println("<td>" + ingresso.getId() + "</td>");
				out.println("<td>" + ingresso.getValor() + "</td>");
				out.println("<td>" + ingresso.getQuantidade() + "</td>");
				out.println("<td>" + ingresso.getDescricao() + "</td>");
				out.println("<td>" + ingresso.getQrcode() + "</td>");
				out.println("<td>" + ingresso.getUser_id() + "</td>");
				out.println("<td>" + ingresso.getEvento_id() + "</td>");
			out.println("</tr>");
		}

		out.println("</table>");
	%><br/><br/>
	
	<a href="cadastro.jsp"> Cadastro </a><br/>
	<a href="login.jsp"> Login </a>

</body>

</html>