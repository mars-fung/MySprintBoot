package com.testng.extentReports;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/30.
 */
public class ReportDemo {
    @Test
    public  void test_OK(){
        Assert.assertEquals(1,1);
    }

    @Test
    public  void test_fail(){
        Assert.assertEquals(1,2);
    }

    @Test
    public  void test_ok_2(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我们写的日志");
        throw new RuntimeException("这是运行时的异常");
    }

}
