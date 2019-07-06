package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MultiThreadOnAnnotion {

    @Test
    public void test(){
        System.out.println("1");
        System.out.printf("Thead ID: %s%n",Thread.currentThread());
    }

}
