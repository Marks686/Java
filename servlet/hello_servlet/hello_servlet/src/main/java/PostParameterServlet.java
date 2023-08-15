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
 * Time: 15:29
 */
@WebServlet("/postParameter")
public class PostParameterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String classId = req.getParameter("classId");
        resp.setContentType("text/html");
        resp.getWriter().write("studentId = " + studentId + " classId = " + classId);
    }
}
