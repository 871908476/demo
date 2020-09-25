package base.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.util.Date;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {

    }

    static void upload() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        InputStream is = serverSocket.accept().getInputStream();
        File file = new File("d:" + File.separator + "upload" + File.separator + new Random().nextInt(9999) + new Date().toString() + ".jpg");
        if (!file.exists()) {
            file.mkdirs();
        }
        OutputStream fos = new FileOutputStream(file);
        byte[] bytes = new byte[10240];
        int len = 0;
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        System.out.println("上传完成！");
        fos.close();
        is.close();
        serverSocket.close();
    }
}
