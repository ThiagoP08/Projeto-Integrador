<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
</head>

<body>

	<form action="cadastroAction.jsp" method="POST"><br/>
		<div>
			<label> Email </label>
			<input type="email" name="email" placeholder="Email" />
		</div><br/>
		<div>
			<label> Nome </label>
			<input type="text" name="nome" placeholder="Nome" />
		</div><br/>
		<div>
			<label> Username </label>
			<input type="text" name="username" placeholder="Username" />
		</div><br/>
		<div>
			<label> Senha </label>
			<input type="text" name="senha" placeholder="Senha" />
		</div><br/>
				<div>
			<label> Confirmar Senha </label>
			<input type="text" name="confirmSenha" placeholder="Confirmar Senha" />
		</div><br/>
		<div>
			<label> Data de Nascimento </label>
			<input type="date" name="dtNascimento" />
		</div><br/>
		<div>
			<label> CPF </label>
			<input type="text" name="cpf" placeholder="CPF" />
		</div><br/>
		<div>
			<label> Endereço </label>
			<input type="text" name="endereco" placeholder="Endereço" />
		</div><br/>
		<div>
			<label> CEP </label>
			<input type="text" name="cep" placeholder="CEP" />
		</div><br/>
		<div>
			<label> Status </label>
			<input type="checkbox" name="status" value=true />
		</div><br/>
		
		<button type="submit"> Cadastrar </button>
	</form>

</body>

</html>