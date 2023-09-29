package hash;

public class Hash {
	
	public String HashSenha(String senha) {
		
		String senhaOriginal = senha;
		
		String hash = "$2a$12$FN7exnLVO3fxespC9L2KI.";
		
		String hashSenha = BCrypt.hashpw(senhaOriginal, hash);
		
		return hashSenha;
	}
}
