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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/getMessages")
public class SendMessage extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.setCharacterEncoding("utf-8");
        List<Message> lt = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = objectMapper.readValue(req.getInputStream(), User.class);

        try {
            connection = DB.getConnection();
            String sql = "SELECT U1.user_name AS who, U2.user_name AS toWho, UNIX_TIMESTAMP(M.sendTime) AS time, M.msg AS msg, U1.pic_path AS who_pic, U2.pic_path AS toWho_pic FROM Message M JOIN User_info U1 ON M.who = U1.id JOIN User_info U2 ON M.toWho = U2.id WHERE U1.user_name = ? OR U2.user_name = ?;";
            System.out.println(sql);

            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUser_name());
            statement.setString(2, user.getUser_name());
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Message message = new Message();
                message.setWho(resultSet.getString("who"));
                message.setToWho(resultSet.getString("toWho"));
                message.setTime(resultSet.getInt("time"));
                message.setMsg(resultSet.getString("msg"));
                message.setWho_pic(resultSet.getString("who_pic"));
                message.setToWho_pic(resultSet.getString("toWho_pic"));
                lt.add(message);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                DB.close(connection, statement, resultSet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        objectMapper.writeValue(resp.getWriter(), lt);
    }
}
