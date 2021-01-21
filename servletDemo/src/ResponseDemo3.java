import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器编码方式，防止乱码
        //response.setHeader("content-type", "text/html;charset=utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1 获取字符输出流
        PrintWriter pw =response.getWriter();
        //2 输出字符
        pw.write("<h1>你好！hello！</h1>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
