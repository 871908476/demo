package base.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用反射创建框架类练习
 */
public class MyFrame {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        Properties pro=new Properties();
        ClassLoader classLoader = MyFrame.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("base/reflect/pro.properties");
        //2.加载配置文件
        pro.load(is);
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //3.加载类
        Class cl = Class.forName(className);
        //4.创建实例并调用方法
        Object o = cl.getConstructor().newInstance();
        Method method = cl.getMethod(methodName);
        method.invoke(o);
    }
}
