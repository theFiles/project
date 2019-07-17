package cn.dao;

import module.lmysql.Mysql;

import java.util.List;

public class GoodsInfoDao {
    /**
     * 商品列表
     */
    static public List getGoodsList(){
        Mysql mysql = new Mysql();
        return mysql.select()
             .query("goodsInfo");
    }

    /**
     * 新增商品
     */
    static public int addGoods(){
        return 0;
    }

}
