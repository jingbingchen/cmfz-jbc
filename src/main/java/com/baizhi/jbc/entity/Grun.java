package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;


public class Grun {

    private String id;
    private String name; //名字
    private String src; //图片
    private String username;  //用户名
    private String password;  //密码
    private String salt; //盐

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;  //时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grun grun = (Grun) o;
        return Objects.equals(id, grun.id) &&
                Objects.equals(name, grun.name) &&
                Objects.equals(src, grun.src) &&
                Objects.equals(username, grun.username) &&
                Objects.equals(password, grun.password) &&
                Objects.equals(salt, grun.salt) &&
                Objects.equals(time, grun.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, src, username, password, salt, time);
    }

    public Grun() {
    }

    public Grun(String id, String name, String src, String username, String password, String salt, Date time) {
        this.id = id;
        this.name = name;
        this.src = src;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.time = time;
    }
}
