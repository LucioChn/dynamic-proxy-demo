package com.nobody.staticproxy;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 生成代理对象，并传入被代理对象
        WhileWineCompany proxy = new JDProxy(new Moutai());
        proxy.product();
    }
}
