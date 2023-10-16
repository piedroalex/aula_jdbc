package aula_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Pedro Alex
 */
public class ListarDados {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
        	connection = DriverManager.getConnection(ParametrosDaConexao.getJdbcURL(), ParametrosDaConexao.getUser(), ParametrosDaConexao.getPassword());        	
            String sql = "SELECT * FROM clientes";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
            	Integer id = resultSet.getInt("id"); 
                String nome = resultSet.getString("nome");
                System.out.println("Id: " + id + ", Nome: " + nome);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(resultSet != null) {
            		resultSet.close();
				}
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
