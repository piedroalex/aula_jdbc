package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Pedro Alex
 */
public class ConexaoComBancoDeDados {
	public static void main(String[] args) {
		Connection connection = null;
		try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());
        	System.out.println("Conexao estabelecida com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
