import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-13
 * Time: 10:02
 */
//下面的注解把当前类和一个HTTP请求的路径关联起来
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        //重写init 插入自己"初始化"相关的逻辑
        System.out.println("init");
    }
    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //这个只是在服务器的控制台打印
        System.out.println("hello world");
        //要想把hello world返回到客户端,需要使用下面的代码
        //getWriter 会得到一个Writer对象
        resp.getWriter().write("hello world");
    }
}
