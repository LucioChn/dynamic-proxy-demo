package com.nobody.cglib;

/**
 * @Description
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // 目标对象
        Moutai moutai = new Moutai();
        // 代理对象
        Moutai proxy = (Moutai) new CglibProxy().getProxyObject(moutai);
        // 执行代理对象的方法
        proxy.product();
    }
}
