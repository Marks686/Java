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

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-15
 * Time: 14:22
 */
class Message {
    public String from;
    public String to;
    public String message;
}
@WebServlet("/message")
public class MessageServlet extends HttpServlet {
    //使用这个 List 变量保存所有消息
    //private List<Message> messageList = new ArrayList<>();

    private ObjectMapper objectMapper = new ObjectMapper();
    //向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把 body 中的内容读取出来了, 解析成了个Message对象
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        // 保存
        //messageList.add(message);
        save(message);
        //设定状态码,不设置默认也是200
        resp.setStatus(200);
    }
    //从服务器获取数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显式告诉浏览器 数据是json格式 字符集是utf8的
        resp.setContentType("application/json; charset=utf8");
        //objectMapper.writeValue(resp.getWriter(),messageList);
        List<Message> messageList = load();
        String jsonResp = objectMapper.writeValueAsString(messageList);
        System.out.println("jsonResp: " + jsonResp);
        resp.getWriter().write(jsonResp);
    }
    // 提供一对方法
    // 往数据库中寸一条消息
    private void save(Message message){
        //JDBC 操作
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // 1.建立连接
            connection = DBUtil.getConnection();
            // 2.构造 SQL 语句
            String sql = "insert into message values(?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,message.from);
            statement.setString(2,message.to);
            statement.setString(3,message.message);
            // 3.执行sql
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭连接
            DBUtil.close(connection,statement,null);
        }
    }
    // 从数据库取所有消息
    private List<Message> load(){
        List<Message> messageList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1.和数据库建立连接
            connection = DBUtil.getConnection();
            // 2.构造sql
            String sql = "select * from message";
            statement = connection.prepareStatement(sql);
            // 3.执行 sql
            resultSet = statement.executeQuery();
            // 4.遍历结果集合
            while (resultSet.next()){
                Message message = new Message();
                message.from = resultSet.getString("from");
                message.to = resultSet.getString("to");
                message.message = resultSet.getString("message");
                messageList.add(message);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            // 5. 释放资源 断开连接
            DBUtil.close(connection,statement,resultSet);
        }
        return messageList;
    }
}
