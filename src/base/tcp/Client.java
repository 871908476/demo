package base.tcp;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void upload(String file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        Socket socket = new Socket("127.0.0.1", 8000);
        OutputStream os = socket.getOutputStream();
        byte[] bytes = new byte[10240];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            os.write(bytes, 0, len);
        }
        os.close();
        fis.close();
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.print(new String(bytes, 0, len));
        }
        is.close();
        socket.close();
    }
}
