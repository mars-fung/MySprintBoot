package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2019/6/29.
 */
public class GroupOnMethon1 {

    @Test(groups = "server")
    public void groupServerTest1(){
        System.out.println("这是服务组的测试方法1");
    }

    @Test(groups = "server")
    public void groupServerTest2(){
        System.out.println("这是服务组的测试方法2");
    }

    @Test(groups = "client")
    public void groupClientTest1(){
        System.out.println("这是客户组的测试方法1");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("beforeGroupsOnServer--服务组before方法");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("afterGroupsOnServer--服务组after方法");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("beforeGroupsOnClient--客户组before方法");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("afterGroupsOnClient--客户组after方法");
    }

}
