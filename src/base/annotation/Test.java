package base.annotation;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 利用注解进行debug框架程序练习
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Cal cal = new Cal();
        Class<? extends Cal> cls = cal.getClass();
        Method[] methods = cls.getMethods();
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                int[] value = method.getAnnotation(Check.class).value();
                try {
                    method.invoke(cal, value[0], value[1]);
                } catch (Exception e) {
                    bw.write("产生异常的位置："+method);
                    bw.newLine();
                    bw.write("引起异常的原因："+e.getCause().toString());
                    bw.newLine();
                    bw.write("---------------------");
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
