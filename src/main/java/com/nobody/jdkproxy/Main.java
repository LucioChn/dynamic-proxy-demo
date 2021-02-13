package com.nobody.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();
        // 获取贵州茅台的代理对象
        WhileWineCompany proxy = (WhileWineCompany) jdkProxy.getJDKProxy(new Moutai());
        // 执行方法
        proxy.product();

        System.out.println("----------------------");

        // 获取酒鬼酒的代理对象
        proxy = (WhileWineCompany) jdkProxy.getJDKProxy(new JiuGuiJiu());
        // 执行方法
        proxy.product();

        byte[] classFile =
                ProxyGenerator.generateProxyClass("$Proxy0", Moutai.class.getInterfaces());
        String path = "D:/$Proxy0.class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] classFile1 =
                ProxyGenerator.generateProxyClass("$Proxy1", JiuGuiJiu.class.getInterfaces());
        String path1 = "D:/$Proxy1.class";
        try (FileOutputStream fos = new FileOutputStream(path1)) {
            fos.write(classFile1);
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
