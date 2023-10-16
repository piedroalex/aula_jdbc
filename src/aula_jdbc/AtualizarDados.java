package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Pedro Alex
 */
public class AtualizarDados {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "UPDATE clientes SET nome = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "Pedro Alex");
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
            System.out.println("Cliente atualizado com sucesso!");
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
