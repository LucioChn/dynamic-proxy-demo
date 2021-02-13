package com.nobody.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description 动态代理类，实现MethodInterceptor方法拦截器接口
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class CglibProxy implements MethodInterceptor {

    // 被代理的目标对象
    private Object target;

    // 动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例

    /**
     * 动态生成一个新的类
     * 
     * @param target
     * @return
     */
    public Object getProxyObject(Object target) {
        this.target = target;
        // 增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        // 回调方法
        enhancer.setCallback(this);
        // 设置生成代理类的父类类型
        enhancer.setSuperclass(target.getClass());
        // 动态生成字节码并返回代理对象
        return enhancer.create();
    }

    /**
     * 拦截方法
     * 
     * @param o CGLib动态生成的代理类实例
     * @param method 上文中实体类所调用的被代理的方法引用
     * @param objects 方法参数值列表
     * @param methodProxy 生成的代理类对方法的代理引用
     * @return 代理对象
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("京东商城下订单");
        Object result = methodProxy.invoke(target, objects);
        System.out.println("京东商城发快递");
        return result;
    }
}
