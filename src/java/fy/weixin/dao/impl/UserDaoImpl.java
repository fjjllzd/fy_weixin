/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fy.weixin.dao.impl;

import fy.weixin.dao.UserDao;
import fy.weixin.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author it-liuzd
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String addNewUser(User user) {
        String sql = "INSERT INTO \"user\"( name, empid, email, depid, weixinid, cellnumber, extnumber) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = new Object[]{user.getName(), user.getEmpid(), user.getEmail(), user.getDepid(), user.getWeixinid(), user.getCellnumber(), user.getExtnumber()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        int ei = jdbcTemplate.update(sql, params, types);
        return ei > 0 ? "success" : "failed";
    }

    @Override
    public String updateUserById(int id, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUserById(int id) {
        String sql = "select * from \"user\" where id =?";
        Object[] params = new Object[]{id};
        int[] types = new int[]{Types.INTEGER};
        User u = null;
        try {
            u = (User) jdbcTemplate.queryForObject(sql, params, types, userRowMap);
        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "报错如下：" + e.getMessage());
        }

        return u;
    }

    protected RowMapper userRowMap = new RowMapper() {

        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            //System.out.println(i);
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setCellnumber(rs.getString("cellnumber"));
            user.setEmail(rs.getString("email"));
            user.setDepid(rs.getInt("depid"));
            user.setEmpid(rs.getString("empid"));
            user.setExtnumber(rs.getString("extnumber"));
            user.setName(rs.getString("name"));
            user.setWeixinid(rs.getString("weixinid"));
            return user;

        }

    };

    @Override
    public User getUserByObject(User u) {
        User user = null;
        String sql = "select * from \"user\" where name=? and empid=? and email=?";
        Object[] params = new Object[]{u.getName(), u.getEmpid(), u.getEmail()};
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try {
            user = (User) jdbcTemplate.queryForObject(sql, params, types, userRowMap);

        } catch (Exception e) {
            System.out.println(this.getClass().getName() + "报错：" + e.getMessage());
        }
        return user;
    }

}
