package base.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Random;

public class Server {
    private static ServerSocket serverSocket;
    static {
        try {
            serverSocket = new ServerSocket(8000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(() -> upload(socket)).start();
        }
    }

    //定于上传方法
    static void upload(Socket socket) {
        try {
            InputStream in = socket.getInputStream();
            File file = new File("c:" + File.separator + "upload");
            if (!file.exists()) {
                file.mkdirs();
            }
            OutputStream fos = new FileOutputStream(file+ File.separator + new Random().nextInt(9999) + new Date().getTime() + ".jpg");
            byte[] bytes = new byte[10240];
            int len = 0;
            while ((len = in.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
            OutputStream out = socket.getOutputStream();
            out.write("上传完成！".getBytes());
            fos.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
