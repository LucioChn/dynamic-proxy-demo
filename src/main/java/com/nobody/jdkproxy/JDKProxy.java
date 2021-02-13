package com.nobody.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description JDK动态代理实现InvocationHandler接口
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class JDKProxy implements InvocationHandler {

    // 被代理的目标对象
    private Object target;

    /**
     * 所有执行代理对象的方法都会被替换成执行invoke方法
     * 
     * @param proxy 代理对象
     * @param method 将要执行的方法信息
     * @param args 执行方法需要的参数
     * @return 方法执行后的返回值
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("京东商城下订单");
        // 通过反射，调用目标对象的方法并传入参数
        Object result = method.invoke(target, args);
        System.out.println("京东商城发快递");
        return result;
    }

    /**
     * 获取代理对象
     * 
     * @param target 被代理的对象
     * @return 代理对象
     */
    public Object getJDKProxy(Object target) {
        this.target = target;
        // loader：ClassLoader对象，定义哪个ClassLoader对象加载生成代理对象
        // interfaces：一个Interface对象的数组，即给代理的对象提供一组接口，代理对象就会实现了这些接口(多态)，这样我们就能调用这些接口中的方法
        // h：:InvocationHandler对象，当动态代理对象在调用方法的时候，会调用InvocationHandler对象的invoke方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }
}
