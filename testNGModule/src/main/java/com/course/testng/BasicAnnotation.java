package com.course.testng;

import org.testng.annotations.*;

/**
 * Created by Administrator on 2019/6/29.
 */
public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("这是测试用例1");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public void beforeCase(){
        System.out.println("这是在测试[方法]之前执行的");
    }
    @AfterMethod
    public void afterCase(){
        System.out.println("这是在测试[方法]之后执行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在测试[类]之前执行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是在测试[类]之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是在[测试集]之前执行的");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("这是在[测试集]之后执行的");
    }


}
