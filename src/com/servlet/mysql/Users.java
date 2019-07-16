package com.servlet.mysql;

import module.lmysql.Mysql;

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

        return res.size() == 1
            ? res.get(0)
            : null;
    }

    static public Map getUserInfo(){
        return null;
    }
}
