import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    private static DataSource dataSource = new MysqlDataSource();

    static {
        ((MysqlDataSource)dataSource).setUrl("jdbc:mysql://localhost:3306/Chat?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("123456");
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }



    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        if (connection != null) {
            connection.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (resultSet != null) {
            resultSet.close();
        }
    }
}
