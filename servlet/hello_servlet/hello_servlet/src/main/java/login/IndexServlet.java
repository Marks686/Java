package login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-17
 * Time: 14:10
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    // 通过重定向 浏览器发起的是 GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先判定用户登录状态
        // 如果用户还没登录就要求先登录
        // 如果已经登录了则根据会话中的用户 来显示到页面上

        //此操作不会触发会话创建
        HttpSession session = req.getSession(false);
        if (session == null){
            //未登录
            System.out.println("用户未登录");
            resp.sendRedirect("login.html");
        }
        //已经登录
        String username = (String) session.getAttribute("username");
        //构造页面
        resp.setContentType("text/html;charset=utf8");
        resp.getWriter().write("欢迎 " + username + "回来!");
    }
}
