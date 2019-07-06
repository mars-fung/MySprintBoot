package com.course.testng;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */

//异常测试
public class ExpectedException {

    /***
     * 什么时候会用到异常测试？？
     * 在我们期望结果为某一个异常的时候
     * 比如我们传入了某些不合法的参数，程序抛出了异常
     * 也就是我们的预期结果是这个异常。
     *
     */

    //这个是测试结果是失败的异常测试   -- 失败的例子
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpceptionFailed(){
        System.out.println("这是一个运行失败的测试");
    }

    //这个是测试结果是成功的
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExpceptionSuccess(){
        System.out.println("这是一个运行成功的测试");
        throw new RuntimeException();
    }

}
