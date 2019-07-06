package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */

@Test(groups = "stu")
public class GroupOnClass2 {


    public void stu1(){
        System.out.println("类：GroupOnClass2中的stu1运行");
    }
    public void stu2(){
        System.out.println("类：GroupOnClass2中的stu2运行");
    }

}
