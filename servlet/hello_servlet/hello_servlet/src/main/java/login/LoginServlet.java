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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 验证用户名密码是否正确 此处直接写死
        // 约定用户名合法是 zhangsan 和 lisi
        // 密码合法的都是 123
//        if(username.equals("zhangsan") || username.equals("lisi")){
//            if(password.equals("123")){
//                //登录成功
//            } else{
//                //登录失败
//            }
//        } else {
//            //登录失败
//
//        }
        if (!username.equals("zhangsan") && !username.equals("lisi")){
            //登录失败
            //重定向到 登录页面
            System.out.println("登录失败 用户名错误!");
            resp.sendRedirect("login.html");
            return;
        }
        if (!password.equals("123")){
            //登录失败
            System.out.println("登录失败 密码错误");
            resp.sendRedirect("login.html");
            return;
        }
        //登录成功
        // 1.创建一个会话
        HttpSession session = req.getSession(true);
        // 2.把当前的用户名保存到会话中
        session.setAttribute("username",username);
        // 3.重定向到主页
        resp.sendRedirect("index");
    }
}
