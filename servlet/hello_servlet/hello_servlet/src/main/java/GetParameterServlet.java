import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-14
 * Time: 14:53
 */
@WebServlet("/getParameter")
public class GetParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //预期浏览器会发一个形如 /getParameter?studentId=10&classId=20 这样的请求
        // 借助req 里的 getParameter方法就能拿到 query string 中的键值对内容
        //getParameter 得到的是 String 类型的结果
        String studentId = req.getParameter("studentId");
        String classId = req.getParameter("classId");
        resp.setContentType("text/html");
        resp.getWriter().write("studentId = " + studentId + " classId = " + classId);
    }
}
