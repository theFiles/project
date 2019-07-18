package cn.entity;

import module.ljson.ILJson;

public class GoodsInfo implements ILJson {
    private int id;
    private String goods_name;
    private String goods_pic;
    private double goods_price;
    private String goods_description;
    private int goods_stock;
    private int flag;

    public GoodsInfo(){}

    public GoodsInfo(int id, String goods_name, String goods_pic, double goods_price, String goods_description, int goods_stock, int flag) {
        setId(id);
        setGoods_name(goods_name);
        setGoods_pic(goods_pic);
        setGoods_price(goods_price);
        setGoods_description(goods_description);
        setGoods_stock(goods_stock);
        setFlag(flag);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_pic() {
        return goods_pic;
    }

    public void setGoods_pic(String goods_pic) {
        this.goods_pic = goods_pic;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_description() {
        return goods_description;
    }

    public void setGoods_description(String goods_description) {
        this.goods_description = goods_description;
    }

    public int getGoods_stock() {
        return goods_stock;
    }

    public void setGoods_stock(int goods_stock) {
        this.goods_stock = goods_stock;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
