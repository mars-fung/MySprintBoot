package com.course.controller;

import com.course.module.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "插入用户",httpMethod = "POST")
    @PostMapping("/addUser")
    public int addUser(@RequestBody User user){
        int result =  template.insert("addUser",user);
        return  result;
    }

    @ApiOperation(value = "更新用户",httpMethod = "POST")
    @PostMapping("updateUser")
    public int updateUser(@RequestBody User user){
        int result = template.update("updateUser",user);
        return result;
    }

    @ApiOperation(value = "删除用户",httpMethod = "POST")
    @PostMapping("deleteUser")
    public int deleteUser(@RequestParam Integer id){
        int result = template.delete("deleteUser",id);
        return result;
    }


}
