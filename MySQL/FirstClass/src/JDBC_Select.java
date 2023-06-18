import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Select {
    public static void main(String[] args) throws SQLException {
        // 初始化源
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/learn_mysql_idea?characterEncoding=utf8&useSSL=false");
        // 连接
        Connection connection = dataSource.getConnection("root", "123456");
        // 创建sql语句并初始化
        String sql = "select * from learn_mysql_idea.student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            int math = resultSet.getInt(2);
            System.out.println(id + " " + math);
        }

        // 释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
