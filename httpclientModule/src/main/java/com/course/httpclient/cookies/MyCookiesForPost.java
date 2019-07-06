package com.course.httpclient.cookies;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultClientConnection;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testPostCookies() throws IOException {
        String result;
        //从配置里拼接URL地址
        String testUrl = this.url + bundle.getString("postCookiesUri");

        //测试逻辑代码
        HttpPost httpPost= new HttpPost(testUrl);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpPost);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookies信息
        store = httpClient.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name: " + name + ";   value: " + value);
        }
    }


    //这个请求是需要带cookies才能正常访问的
    @Test(dependsOnMethods = {"testPostCookies"})
    public void testPostMethod() throws IOException {
            String testUrl = this.url+bundle.getString("postWithCookiesUri");

        //声明一个client对象
        DefaultHttpClient httpClient = new DefaultHttpClient();

        //声明一个方法，这个方法是post方法
        HttpPost httpPost = new HttpPost(testUrl);

        //设置header信息
        httpPost.setHeader("content-type","application/json");
        //添加请求参数
        JSONObject parm = new JSONObject();
        parm.put("name","fengjm");
        parm.put("age","30");
        //把参数信息添加到方法中
        StringEntity entity = new StringEntity(parm.toString(),"utf-8");
        httpPost.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        httpClient.setCookieStore(this.store);
        //执行post请求方法
        HttpResponse response = httpClient.execute(httpPost);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity());
        //处理结果，就是判断返回结果是否符合预期
        //将返回的响应结果字符串转换为json对象
        JSONObject resultJson = JSON.parseObject(result);
        //具体判断逻辑结果

        //获取到结果集
        String successResult = resultJson.get("fengjm").toString();
        String statusCode = resultJson.getString("status");
        Assert.assertEquals(successResult,"success");
        Assert.assertEquals(statusCode,"1");

        }


}
