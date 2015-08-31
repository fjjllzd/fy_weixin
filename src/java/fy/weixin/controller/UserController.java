/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import fy.weixin.domain.User;
import fy.weixin.domain.Wxdep;
import fy.weixin.service.impl.UserServiceImpl;
import fy.weixin.utils.GetTreeList;
import fy.weixin.utils.WeixinService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author it-liuzd
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") int id) {
        User u = null;
        try {
            u = userService.getUserById(id);
            //System.out.println(u.getName());
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "报错如下：" + e.getMessage());
        }
        return u;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addNewUser(HttpServletRequest request) {
        String name = request.getParameter("name") != null ? request.getParameter("name") : "";
        String empid = request.getParameter("empid") != null ? request.getParameter("empid") : "";
        String email = request.getParameter("email") != null ? request.getParameter("email") : "";
        User u = new User();
        u.setName(name);
        u.setEmpid(empid);
        u.setEmail(email);
        String result = userService.addNewUser(u);

        return result.equals("success") ? "{success:true,msg:'添加成功！'}" : "{success:false,msg:'添加失败！'}";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String checkUserExist(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name") != null ? request.getParameter("name") : "";
        String empid = request.getParameter("empid") != null ? request.getParameter("empid") : "";
        String email = request.getParameter("email") != null ? request.getParameter("email") : "";
        User u = new User();
        u.setName(name);
        u.setEmpid(empid);
        u.setEmail(email);
        Boolean result = userService.checkUserExist(u);
        if (result) {
            session.setAttribute("user", u);
        }
        return result == true ? "{success:true,msg:'验证成功！'}" : "{success:false,msg:'验证失败，系统内未找到您的工号对应的邮箱，</br>如果您确认输入的信息无误，请联系<a href=\"mailto:zhendong.liu@fuyaogroup.com\">系统管理员</a> ！'}";
    }

    @RequestMapping(value = "/getsession", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getSession(HttpSession session) {
        User user = (User) session.getAttribute("user");
        User u = userService.getUserByObject(user);
        String json = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.writeValueAsString(u);
            //System.out.println(json);
        } catch (Exception e) {
        }
        return "{\"success\" :\"true\" , \"user\":[" + json + "]}";
    }

    @RequestMapping(value = "/getdeptree", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String gettree() {
        String result = "";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator;
//        String depjson = "[{\"id\":1,\"name\":\"福耀集团\",\"parentid\":0,\"order\":200},{\"id\":2,\"name\":\"集团总办\",\"parentid\":1,\"order\":200},{\"id\":4,\"name\":\"人事部\",\"parentid\":2,\"order\":400},{\"id\":5,\"name\":\"财务部\",\"parentid\":2,\"order\":600},{\"id\":6,\"name\":\"行政部\",\"parentid\":2,\"order\":800},{\"id\":40,\"name\":\"会计部\",\"parentid\":2,\"order\":1000},{\"id\":41,\"name\":\"信息部\",\"parentid\":40,\"order\":200},{\"id\":57,\"name\":\"总办管理处\",\"parentid\":2,\"order\":1200},{\"id\":58,\"name\":\"运营部\",\"parentid\":2,\"order\":1400},{\"id\":59,\"name\":\"研究院\",\"parentid\":2,\"order\":1600},{\"id\":60,\"name\":\"系统工程部\",\"parentid\":2,\"order\":1800},{\"id\":61,\"name\":\"技术服务部\",\"parentid\":2,\"order\":2000},{\"id\":62,\"name\":\"供应管理部\",\"parentid\":2,\"order\":2200},{\"id\":63,\"name\":\"质管部\",\"parentid\":2,\"order\":2400},{\"id\":64,\"name\":\"宣传部\",\"parentid\":2,\"order\":2600},{\"id\":65,\"name\":\"国内配件部\",\"parentid\":2,\"order\":2800},{\"id\":66,\"name\":\"统计部\",\"parentid\":2,\"order\":3000},{\"id\":67,\"name\":\"商务部\",\"parentid\":2,\"order\":3200},{\"id\":68,\"name\":\"产品设计部\",\"parentid\":2,\"order\":3400},{\"id\":69,\"name\":\"基建\",\"parentid\":2,\"order\":3600},{\"id\":70,\"name\":\"董事会\",\"parentid\":2,\"order\":3800},{\"id\":52,\"name\":\"福清万达\",\"parentid\":1,\"order\":400},{\"id\":53,\"name\":\"福清巴士\",\"parentid\":1,\"order\":600},{\"id\":54,\"name\":\"广州福耀\",\"parentid\":1,\"order\":800},{\"id\":72,\"name\":\"信息部\",\"parentid\":54,\"order\":200},{\"id\":55,\"name\":\"郑州福耀\",\"parentid\":1,\"order\":1000},{\"id\":71,\"name\":\"信息部\",\"parentid\":55,\"order\":200},{\"id\":73,\"name\":\"总经办\",\"parentid\":55,\"order\":400},{\"id\":74,\"name\":\"人事部\",\"parentid\":55,\"order\":600},{\"id\":75,\"name\":\"采购部\",\"parentid\":55,\"order\":800},{\"id\":76,\"name\":\"工程部\",\"parentid\":55,\"order\":1000},{\"id\":77,\"name\":\"质保部\",\"parentid\":55,\"order\":1200},{\"id\":78,\"name\":\"工艺部\",\"parentid\":55,\"order\":1400},{\"id\":79,\"name\":\"物流部\",\"parentid\":55,\"order\":1600},{\"id\":80,\"name\":\"财务部\",\"parentid\":55,\"order\":1800},{\"id\":81,\"name\":\"销售部\",\"parentid\":55,\"order\":2000},{\"id\":82,\"name\":\"配件销售部\",\"parentid\":55,\"order\":2200},{\"id\":83,\"name\":\"轿车夹层厂\",\"parentid\":55,\"order\":2400},{\"id\":84,\"name\":\"轿车钢化厂\",\"parentid\":55,\"order\":2600},{\"id\":85,\"name\":\"大巴夹层厂\",\"parentid\":55,\"order\":2800},{\"id\":86,\"name\":\"大巴钢化厂\",\"parentid\":55,\"order\":3000},{\"id\":56,\"name\":\"福清浮法\",\"parentid\":1,\"order\":1200}]";
        try {
//            Wxdep[] wxdep = objectMapper.readValue(depjson, Wxdep[].class);
            List<Wxdep> list = new WeixinService().getDepartmenFromWX();
            Wxdep fyjt = list.get(0);
            list.remove(0);
            GetTreeList gtl = new GetTreeList();
            List<Wxdep> resultlist = gtl.TreeList(list, fyjt);
            System.out.println(resultlist);
            fyjt.setChildren(resultlist);
            result = objectMapper.writeValueAsString(fyjt);
            System.out.println(result);
//            Set<String> key = maps.keySet();
//            Iterator<String> iter = key.iterator();
//            while (iter.hasNext()) {
//                String field = iter.next();
//                System.out.println(field + ":" + maps.get(field));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //return "{\"success\":true ,\"children\": [" + result + "]";
        return "{\"success\":true ,\"children\": [" + result + "]}";
    }

}
