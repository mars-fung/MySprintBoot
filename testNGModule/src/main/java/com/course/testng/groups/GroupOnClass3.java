package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */

@Test(groups = "teacher")
public class GroupOnClass3 {


    public void teacher1(){
        System.out.println("类：GroupOnClass3中的teacher1运行");
    }
    public void teacher2(){
        System.out.println("类：GroupOnClass3中的teacher2运行");
    }

}
