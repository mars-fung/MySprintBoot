package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/7/3.
 */

@RestController
@Api(value = "/",description = "这是我所有的post方法")
@RequestMapping("/v1")
public class MyPostMethod {

    //这个变量用来装我们的cookies信息
    private static Cookie cookie;

    //用户登录成功获取到cookies，然后再访问其他接口获取列表
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登录成功后获取cookies信息",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam(value = "username",required = true) String username,
                        @RequestParam(value = "password",required = true) String password){
        if(username.equals("fengjm") && password.equals("123456")){
            Cookie cookie = new Cookie("login","true");
            return "恭喜你登录成功";
        }else
            return "登录失败，请重新再试";
    }

    //获取用户列表
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request, @RequestBody User user){
        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for (Cookie cookie:cookies){
            if(cookie.getName().equals("login")
                    && cookie.getValue().equals("true")
                    && user.getUsername().equals("fengjm")
                    && user.getPassword().equals("123456")
                    ){
                user = new User();
                user.setName("test");
                user.setAge("18");
                user.setSex("男");
                return user.toString();
            }
        }
        return "输入非法，请重新再试";
    }

}
