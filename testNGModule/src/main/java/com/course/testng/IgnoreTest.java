package com.course.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */
public class IgnoreTest {
    @Test
    public  void Test1(){System.out.println("Test1 执行"); }

    @Ignore
    public  void ignoreTest2(){System.out.println("ignoreTest2 执行"); }


}
