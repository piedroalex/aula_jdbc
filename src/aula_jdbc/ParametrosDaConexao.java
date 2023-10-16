package aula_jdbc;

/**
 * @author Pedro Alex
 */
public class ParametrosDaConexao {
	private static String jdbcURL = "jdbc:mysql://localhost:3306/nome_do_banco_de_dados";
	private static String user = "usuario_do_banco_de_dados";
	private static String password = "senha_do_banco_de_dados";
	
	public static String getJdbcURL() {
		return jdbcURL;
	}
	public static String getUser() {
		return user;
	}
	public static String getPassword() {
		return password;
	}
	
}
