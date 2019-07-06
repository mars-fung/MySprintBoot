package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Administrator on 2019/6/30.
 */
public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        //存放结果
        String result;
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        //下面这个是用来执行get方式
        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse response = client.execute(httpGet);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);


    }
}
