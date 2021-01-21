import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器编码方式，防止乱码
        response.setContentType("text/html;charset=utf-8");
        //1 获取字节输出流
        ServletOutputStream os = response.getOutputStream();
        //2 输出字节
        os.write("<h1>你好！hello！</h1>".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

