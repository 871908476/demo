package base;

import java.io.*;
import java.util.Date;

/*
IO流演示文件
 */

public class IODemo {
    public static void main(String[] args) throws IOException {
        String file = "C:" + File.separator + "pic.jpg";
        String target = "C:" + File.separator + "pic_copy.jpg";

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target));
        byte[] bytes = new byte[1024];
        int len;
        long start = new Date().getTime();
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.close();
        bis.close();
        long end = new Date().getTime();
        System.out.println("BufferedInputStream耗时：" + (end - start));
        System.out.println("---------------------------------");

        start = new Date().getTime();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(target);
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        fis.close();
        fos.close();
        end = new Date().getTime();
        System.out.println("FileInputStream耗时：" + (end - start));
        System.out.println("---------------------------------");
    }
}
