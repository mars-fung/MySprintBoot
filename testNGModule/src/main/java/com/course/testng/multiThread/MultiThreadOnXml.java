package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MultiThreadOnXml {

    @Test
    public void test1(){
        System.out.printf("test1-Thead ID: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.printf("test2-Thead ID: %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("test3-Thead ID: %s%n",Thread.currentThread().getId());
    }

}
