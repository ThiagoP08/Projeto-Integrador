<%@page import="check.CheckLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<%
		try {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			CheckLogin check = new CheckLogin();
			
			if(check.checkLogin(email, senha)) {
				out.print("Logou");
			} else {
				out.print("Email ou Senha incorretos.");
			}
			
		} catch(Exception e) {
			out.print("Erro: " + e);
		}
	%>
</body>

</html>