import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        /*  JDBC 有以下几步
         * 1 初始化源
         * 2 建立连接
         * 3 创建 SQL语句
         * 4 执行 SQL语句
         * 5 释放资源
         */

        // 初始化源
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/learn_mysql_idea?characterEncoding=utf8&useSSL=false");
        // 连接
        Connection connection = dataSource.getConnection("root", "123456");
        // 创建sql语句并初始化
        String sql = "insert into student values (null, 20);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 执行
        System.out.println(preparedStatement.executeUpdate());
        // 释放资源
        preparedStatement.close();
        connection.close();
    }
}
