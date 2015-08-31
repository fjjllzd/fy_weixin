/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.domain;

import java.util.List;

/**
 *
 * @author it-liuzd
 */
public class Wxdata {

    private int errcode;
    private String errmsg;
    private List<Wxdep> department;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<Wxdep> getDepartment() {
        return department;
    }

    public void setDepartment(List<Wxdep> department) {
        this.department = department;
    }

}
