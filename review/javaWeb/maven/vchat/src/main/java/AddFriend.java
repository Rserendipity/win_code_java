import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/addFriend")
public class AddFriend extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int ret = 0;
        Message message = objectMapper.readValue(req.getInputStream(), Message.class);
        try {
            connection = DB.getConnection();
            String sql = "INSERT INTO Relationship (who, toWho)\n" +
                    "SELECT id, (SELECT id FROM User_info WHERE user_name = ?)\n" +
                    "FROM User_info\n" +
                    "WHERE user_name = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, message.getWho());
            statement.setString(2, message.getToWho());
            ret = statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DB.close(connection, statement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        resp.setStatus(200);
        resp.setCharacterEncoding("utf-8");

        objectMapper.writeValue(resp.getWriter(), ret == 1);
    }
}
