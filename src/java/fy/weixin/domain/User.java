/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.domain;

/**
 *
 * @author it-liuzd
 */
public class User {

    private int id;
    private String name;//姓名
    private String empid;//员工工号
    private String email;//邮箱地址
    private int depid;//部门编号
    private String weixinid;//微信号
    private String cellnumber;//手机号
    private String extnumber; //分机号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

    public String getWeixinid() {
        return weixinid;
    }

    public void setWeixinid(String weixinid) {
        this.weixinid = weixinid;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public String getExtnumber() {
        return extnumber;
    }

    public void setExtnumber(String extnumber) {
        this.extnumber = extnumber;
    }

}
