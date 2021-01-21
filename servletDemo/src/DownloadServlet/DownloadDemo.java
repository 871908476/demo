package DownloadServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author shun
 */
@WebServlet("/downloadDemo")
public class DownloadDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1 获取资源路径
        String filename = request.getParameter("filename");
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath("/image/"+ filename);
        // 2 创建输入流
        FileInputStream fis = new FileInputStream(realPath);
        // 3 设置响应头
        // 3.1 根据不同浏览器设置文件名编码，防止中文乱码
        String agent = request.getHeader("user-agent");
        filename = DownloadUtils.getFileName(agent, filename);
        // 3.2 设置响应头，打开方式为附件，MIME类型
        String mimeType = context.getMimeType(filename);
        response.setContentType(mimeType);
        response.setHeader("Content-disposition", "attachment;filename=" + filename);
        // 4 输入流读取都输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[10240];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
