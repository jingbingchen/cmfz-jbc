package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Article {

    private String id;
    private String title;  //标题


    private String status; //状态
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;  //时间
    private String gurn_name;  //上师名
    private String content;  //内容

    public Article() {
    }

    public Article(String id, String title, String status, Date time, String gurn_name, String content) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.time = time;
        this.gurn_name = gurn_name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", time=" + time +
                ", gurn_name='" + gurn_name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getGurn_name() {
        return gurn_name;
    }

    public void setGurn_name(String gurn_name) {
        this.gurn_name = gurn_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(title, article.title) &&
                Objects.equals(status, article.status) &&
                Objects.equals(time, article.time) &&
                Objects.equals(gurn_name, article.gurn_name) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, status, time, gurn_name, content);
    }
}
