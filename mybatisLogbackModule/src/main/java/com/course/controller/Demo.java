package com.course.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2019/7/4.
 */


@Log4j
@RestController
@RequestMapping(value = "/v1")
@Api(value = "/v1",description = "第一个mybatis版本的demo")
public class Demo {

    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    public int getUserCount(){
        //这个（）里的是输入mapper文件里的id
        int result = template.selectOne("getUserCount");

        return result;
    }


}
