package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.Objects;



public class Banner {
    private String id;
    private String src;
    private String des;//描述
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner banner = (Banner) o;
        return Objects.equals(id, banner.id) &&
                Objects.equals(src, banner.src) &&
                Objects.equals(des, banner.des) &&
                Objects.equals(status, banner.status) &&
                Objects.equals(time, banner.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, src, des, status, time);
    }

    @Override
    public String toString() {
        return "Banner{" +
                "id='" + id + '\'' +
                ", src='" + src + '\'' +
                ", des='" + des + '\'' +
                ", status='" + status + '\'' +
                ", time=" + time +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Banner() {
    }

    public Banner(String id, String src, String des, String status, Date time) {
        this.id = id;
        this.src = src;
        this.des = des;
        this.status = status;
        this.time = time;
    }
}
