package cn.dao;

import cn.entity.GoodsInfo;
import module.lmysql.Mysql;

import java.util.List;
import java.util.Map;

public class GoodsInfoDao {
    /**
     * 商品列表
     */
    static public List getGoodsList(){
        Mysql mysql = new Mysql();
        List res = mysql.select("id","goods_pic","goods_name","flag")
                .query("goodsInfo");

        mysql.close();

        return res;
    }

    /**
     * 通过id取商品详情
     */
    static public Map getGoods(int id){
        Mysql mysql = new Mysql();
        List<Map> res = mysql.select()
                        .where("id",id)
                        .query("goodsInfo",1);

        mysql.close();

        return res.get(0);
    }

    /**
     * 新增商品
     */
    static public int addGoods(GoodsInfo obj){
        Mysql mysql = new Mysql();

        int res = mysql.insert(obj).query("goodsInfo");

        mysql.close();

        return res;
    }

    /**
     * 修改商品
     */
    static public int setGoods(GoodsInfo obj, int id){
        Mysql mysql = new Mysql();
        int res = mysql.update(
            obj,
"goods_name",
            "goods_pic",
            "goods_price",
            "goods_description",
            "goods_stock",
            "flag"
        ).where("id",id).query("goodsInfo",1);

        mysql.close();

        return res;
    }

    /**
     * 删除商品
     */
    static public int delGoods(int id){
        Mysql mysql = new Mysql();
        int res = mysql.delete("goodsInfo")
                .where("id",id)
                .query(1);

        mysql.close();

        return res;
    }

}
