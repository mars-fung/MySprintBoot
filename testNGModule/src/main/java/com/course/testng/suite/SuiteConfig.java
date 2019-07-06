package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

/**
 * Created by Administrator on 2019/6/29.
 */

//用于所有测试套件的配置
public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite 运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite 执行了");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest 运行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest 执行了");
    }

}
