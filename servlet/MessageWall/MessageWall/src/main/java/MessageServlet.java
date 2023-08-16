import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private List<Message> messageList = new ArrayList<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    //向服务器提交数据
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 把 body 中的内容读取出来了, 解析成了个Message对象
        Message message = objectMapper.readValue(req.getInputStream(),Message.class);
        // 保存
        messageList.add(message);
        //设定状态码,不设置默认也是200
        resp.setStatus(200);
    }

    //从服务器获取数据
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 显式告诉浏览器 数据是json格式 字符集是utf8的
        resp.setContentType("application/json; charset=utf8");
        objectMapper.writeValue(resp.getWriter(),messageList);
    }
}
