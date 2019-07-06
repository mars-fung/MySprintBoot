package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2019/7/2.
 */


@RestController
@Api(value = "/",description = "这是我所有的get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到token",httpMethod = "GET")  //接口的描述
    public String getCookiesMethod(HttpServletResponse response){
        //给客户端返回cookies
        Cookie cookie =new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功！";
    }

    /*
        要求客户端携带cookies访问
        这个是需要携带cookies才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies才能访问",httpMethod = "GET")  //接口的描述
    public String getWithCookies(HttpServletRequest request){
            Cookie[] cookies = request.getCookies();
            if(Objects.isNull(cookies)){
                 return "必须携带cookies才能访问";
            }
            for (Cookie cookie:cookies){
               if(cookie.getValue().equals("true")&&cookie.getName().equals("login")){
                   return "恭喜你访问get/with/cookies成功";
               }
            }

            return "返回携带cookies才能请求的get请求";
     }

     /*
        开发一个需要携带参数才能访问的get请求
        第一种方式： key-value方式
                   ip:port/get/with/param?start=&&end=
      */
    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求-key-value",httpMethod = "GET")  //接口的描述
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("方便面",1);
        myList.put("衬衫",100);

        return myList;
    }

    /*
        开发一个需要携带参数才能访问的get请求
        第二种方式： ip:port/get/with/param/10/20
      */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求-/get/with/param/{start}/{end}",httpMethod = "GET")  //接口的描述

    public Map<String,Integer> getList2(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("方便面",1);
        myList.put("衬衫",100);

        return myList;
    }


}
