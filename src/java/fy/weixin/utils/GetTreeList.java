/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.utils;

import fy.weixin.domain.Wxdep;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fjjll
 */
public class GetTreeList {

    public List<Wxdep> TreeList(List list, Wxdep node) {
        List<Wxdep> childrenList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Wxdep w = (Wxdep) list.get(i);
            if (w.getParentid() == node.getId()) {
                childrenList.add(w);
                this.TreeList(list, w);
            }
        }
        node.setChildren(childrenList);
        return childrenList;
    }
}
