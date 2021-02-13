package com.nobody.staticproxy;

/**
 * @Description 代理类，京东代理商
 * @Author Mr.nobody
 * @Date 2021/2/12
 * @Version 1.0
 */
public class JDProxy implements WhileWineCompany {

    // 被代理的贵州茅台公司
    private Moutai moutai;

    public JDProxy(Moutai moutai) {
        this.moutai = moutai;
    }

    public void product() {
        System.out.println("京东商城下订单购买白酒");
        // 实际调用目标对象的方法
        moutai.product();
        System.out.println("京东商城发快递");
    }
}
