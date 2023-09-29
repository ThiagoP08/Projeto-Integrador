<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="service.UserService"%>
<%@ page import="check.CheckEmail"%>
<%@ page import="model.User"%>
<%@ page import="hash.Hash"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%
		try {
			CheckEmail check = new CheckEmail();
			User user = new User();
			Hash hash = new Hash();
		
			String email = request.getParameter("email");
			
			user.setNome(request.getParameter("nome"));
			
			user.setUsername(request.getParameter("username"));
			
			String senha = request.getParameter("senha");
			
			String confirmarSenha = request.getParameter("confirmSenha");
			
			if(!senha.equals(confirmarSenha)){
				out.print("As senhas não coincidem");
			} else {
				user.setSenha(hash.HashSenha(senha));
			}
			
			user.setDtNascimento(request.getParameter("dtNascimento"));
			user.setCpf(request.getParameter("cpf"));
			user.setCep(request.getParameter("cep"));
			user.setEndereco(request.getParameter("endereco"));
			user.setStatus_admin(Boolean.parseBoolean(request.getParameter("status")));
			
			if(check.checkEmail(email)) {
				out.print("Email já existente");
			} else {
				user.setEmail(email);
				
				UserService service = new UserService();
				service.incluirUser(user);
				
				response.sendRedirect("index.jsp");
			}
	
		} catch (Exception e) {
			out.print(e);
		}
	%>
</body>

</html>