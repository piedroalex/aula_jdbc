package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Pedro Alex
 */
public class TratamentoExcecoes {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());
			preparedStatement = connection.prepareStatement(null); //forçando um erro
			preparedStatement.execute();
		} catch (Exception e) {
			System.err.println("Executando o conteudo do bloco catch.");
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
				System.err.println("Executando o conteudo do bloco finally.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
