package session;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/sessionDemo")
public class sessionDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        //设置共享的数据
        HttpSession session = request.getSession();
        session.setAttribute("msg", "hello session");
//        Cookie cookie = new Cookie("JSESSIONID", session.getId());
//        cookie.setMaxAge(60*60);
        //在不同请求中可以获取到数据
        //Object msg = session.getAttribute("msg");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        this.doPost(request, response);
    }
}
