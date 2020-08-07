package com.baizhi.jbc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;
import java.util.Objects;

public class User {

    @Excel(name = "ID")
    private String id;

    @Excel(name = "密码")
    private String password; //密码

    @Excel(name = "手机号")
    private String phone; //手机号

    @Excel(name = "盐")
    private String salt; //盐

    @Excel(name = "状态")
    private String status; //状态

    @Excel(name = "头像")
    private String img; //图片

    @Excel(name = "姓名")
    private String name; //姓名

    @Excel(name = "法名")
    private String legal_name; //法名

    @Excel(name = "性别")
    private String sex;  //性别

    @Excel(name = "地址")
    private String city;  //地址

    @Excel(name = "签名")
    private String sign; //签名

    @Excel(name = "注册时间", format = "yyyy年MM月dd日", height = 10, width = 30)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time; //注册时间

    public User(String id, String password, String phone, String salt, String status, String img, String name, String legal_name, String sex, String city, String sign, Date time) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.salt = salt;
        this.status = status;
        this.img = img;
        this.name = name;
        this.legal_name = legal_name;
        this.sex = sex;
        this.city = city;
        this.sign = sign;
        this.time = time;

    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", salt='" + salt + '\'' +
                ", status='" + status + '\'' +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", legal_name='" + legal_name + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", sign='" + sign + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(status, user.status) &&
                Objects.equals(img, user.img) &&
                Objects.equals(name, user.name) &&
                Objects.equals(legal_name, user.legal_name) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(city, user.city) &&
                Objects.equals(sign, user.sign) &&
                Objects.equals(time, user.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, password, phone, salt, status, img, name, legal_name, sex, city, sign, time);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
