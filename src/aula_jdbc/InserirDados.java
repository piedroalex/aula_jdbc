package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Pedro Alex
 */
public class InserirDados {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "INSERT INTO clientes (id, nome) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Pedro");
            preparedStatement.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}
