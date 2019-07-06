package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置里拼接URL地址
        String testUrl = this.url + bundle.getString("getCookiesUri");

        //测试逻辑代码
        HttpGet httpGet = new HttpGet(testUrl);

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(httpGet);
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
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {{
        String result;
        //从配置里拼接URL地址
        String testUrl = this.url + bundle.getString("getWithCookiesUri");

        //测试逻辑代码
        HttpGet httpGet = new HttpGet(testUrl);

        DefaultHttpClient httpClient = new DefaultHttpClient();

        //设置cookies信息
        httpClient.setCookieStore(this.store);
        HttpResponse response = httpClient.execute(httpGet);

        //获取状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode: "+statusCode);
        if(statusCode == 200){
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }
        //获取cookies信息
        store = httpClient.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name: " + name + ";   value: " + value);
        }
    }

    }



}
