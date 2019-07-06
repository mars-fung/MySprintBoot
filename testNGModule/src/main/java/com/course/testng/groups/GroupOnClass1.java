package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */
@Test(groups = "stu")
public class GroupOnClass1 {

    public void stu1(){
        System.out.println("类：GroupOnClass1中的stu1运行");
    }
    public void stu2(){
        System.out.println("类：GroupOnClass1中的stu2运行");
    }

}
