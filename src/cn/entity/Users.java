package cn.entity;

import module.ljson.ILJson;

public class Users implements ILJson {
    private int id;
    private String user_name;
    private String user_pwd;
    private int sex;
    private String hobbys;
    private String phone;
    private String email;
    private String address;
    private int flag;

    public Users(){}

    public Users(String user_name, String user_pwd, int sex, String hobbys, String phone, String email, String address, int flag) {
        setUser_name(user_name);
        setUser_pwd(user_pwd);
        setSex(sex);
        setHobbys(hobbys);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
        setFlag(flag);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHobbys() {
        return hobbys;
    }

    public void setHobbys(String hobbys) {
        this.hobbys = hobbys;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
