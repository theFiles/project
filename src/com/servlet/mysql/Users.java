package com.servlet.mysql;

import module.lmysql.Mysql;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Users {

    /**
     * 用户登录
     * @param user      账号
     * @param pwd       密码
     * @return          用户信息
     */
    static public Map login(String user,String pwd){
        Mysql mysql = new Mysql();
        List<Map> res = mysql.select("id","user_name")
                .where("user_name", user)
                .where("user_pwd", pwd)
                .where("flag", 1,false)
                .query("Users",1);

        // 断开连接
        mysql.close();

        return res.size() == 1
            ? res.get(0)
            : null;
    }

    /**
     * 创建用户
     */
    static public int addUser(Map<String,String> info){

        Mysql mysql = new Mysql();
        int res = mysql.insert(info)
                .query("users");

        if(res > 0){
            // 成功后取最新的id
            List<Map<String,String>> id = mysql.query("SELECT LAST_INSERT_ID()");
            // 返回id
            res = Integer.parseInt(id.get(0).get("LAST_INSERT_ID()"));
        }

        // 断开连接
        mysql.close();

        return res;
    }

    static public Map getUserInfo(){
        return null;
    }
}
