<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>

<body>

	<form action="loginAction.jsp" method="POST"><br/>
		<div>
			<label> Email </label>
			<input type="email" name="email" placeholder="Email" />
		</div><br/>
		<div>
			<label> Senha </label>
			<input type="text" name="senha" placeholder="Senha" />
		</div><br/>
		
		<button type="submit"> Login </button>
	</form>

</body>

</html>