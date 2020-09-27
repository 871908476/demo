package base.tcp;

import java.io.*;
import java.net.Socket;
/*
客户端
* */
public class Client {
    public static void main(String[] args) throws IOException {
        String file="\\pic.jpg";
        upload(file);
    }

    //定义上传方法
    public static void upload(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        Socket socket = new Socket("127.0.0.1", 8000);
        OutputStream out = socket.getOutputStream();
        byte[] bytes = new byte[10240];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            out.write(bytes, 0, len);
        }
        socket.shutdownOutput();
        InputStream in = socket.getInputStream();
        while ((len = in.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
        out.close();
        in.close();
        socket.close();
    }
}
