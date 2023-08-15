import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Date: 2023-08-14
 * Time: 14:23
 */

@WebServlet("/showRequest")
public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置响应的 content-type 告诉浏览器 响应的body里的格式是啥样的
        resp.setContentType("text/html");
        //搞个 StringBuilder 把这些api的结果拼起来,统一写回到响应中
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(req.getProtocol());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getMethod());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getRequestURI());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getContextPath());
        stringBuilder.append("<br>");
        stringBuilder.append(req.getQueryString());
        stringBuilder.append("<br>");


        //获取到 header 中所有的键值对
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            stringBuilder.append(headerName + ": " + req.getHeader(headerName));
            stringBuilder.append("<br>");
        }

        resp.getWriter().write(stringBuilder.toString());
    }
}
