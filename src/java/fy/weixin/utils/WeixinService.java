/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import fy.weixin.domain.Wxdata;
import fy.weixin.domain.Wxdep;
import fy.weixin.domain.Wxuser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

/**
 *
 * @author it-liuzd
 */
public class WeixinService {

    public static String corpid = "wxc625758e50b5ced1";
    public static String sercret = "-QjWqj2grOAExOXJG2LVeAEnjtYGW07MQ1iQWyIpGAtMFFwViD3F-p9gX40EKgUh";
    public static String accessToken;

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenFromWX() {
        String access_token = "";
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet hg = new HttpGet("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + sercret + "");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(hg, responseHandler);
            System.out.println("远程获取AccessToken：" + responseBody + "");
            JsonFactory factory = new JsonFactory();
            JsonParser parser = factory.createJsonParser(responseBody);
            access_token = "";
            //System.out.print(parser);

            while (parser.nextToken() != JsonToken.END_OBJECT) {
                //out.println((parser.getCurrentToken() == JsonToken.FIELD_NAME) + "    " + parser.getValueAsString());
                if (parser.getCurrentToken() == JsonToken.VALUE_STRING && parser.getCurrentName().equals("access_token")) {
                    //out.println(parser.getCurrentName().equals("access_token"));
                    access_token = parser.getValueAsString().toString();
                    accessToken = access_token;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return access_token;
    }

    public List<Wxdep> getDepartmenFromWX() {
        String accesstoken = accessToken == null ? this.getAccessTokenFromWX() : accessToken;
        List<Wxdep> list = new ArrayList<>();
//        System.out.println(accesstoken);
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet hg = new HttpGet("https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=" + accesstoken + "");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(hg, responseHandler);
            System.out.println("远程获取Department：" + responseBody + "");
            ObjectMapper objectMapper = new ObjectMapper();
            Wxdata wxdata = objectMapper.readValue(responseBody, Wxdata.class);
            list = wxdata.getDepartment();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public String addNewUserToWX(Wxuser wxuser) {
        String accesstoken = accessToken == null ? this.getAccessTokenFromWX() : accessToken;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost hp = new HttpPost("https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=" + accesstoken);
//        Wxuser wxuser = new Wxuser();
//        wxuser.setUserid("999191");
//        wxuser.setDepartment("[87]");
//        wxuser.setEmail("test@test1.com");
//        wxuser.setGender("1");
//        wxuser.setName("测试");
//        wxuser.setMobile("1399191199");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(wxuser);

            json = json.replace("\"[", "[");
            json = json.replace("]\"", "]");
            System.out.println(json);
            StringEntity se = new StringEntity(json, HTTP.UTF_8);
            se.setContentEncoding("utf-8");
            se.setContentType("application/json");
            hp.setEntity(se);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(hp, responseHandler);

            System.out.println(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String args[]) {
        //new WeixinService().getAccessTokenFromWX();
        Wxuser wxuser = new Wxuser();
        wxuser.setUserid("999211");
        wxuser.setDepartment("[87]");
        wxuser.setEmail("tes1t@test2.com");
        wxuser.setGender("1");
        wxuser.setName("测试1");
        wxuser.setMobile("1399111111"); //test
        System.out.println(new WeixinService().addNewUserToWX(wxuser));
//        System.out.println( WeixinService.getAccessTokenFromWX());

    }

}
