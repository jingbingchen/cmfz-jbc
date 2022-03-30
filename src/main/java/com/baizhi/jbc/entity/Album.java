package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

public class Album {

    private String id;
    private String title;  //标题
    private String src;   //图片
    private String score;  //评分
    private String author;  //作者
    private String broadcost; //播音
    private Integer count; //集数
    private String content; //内容
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time; //发布时间

    public Album() {
    }

    public Album(String id, String title, String src, String score, String author, String broadcost, Integer count, String content, Date time) {
        this.id = id;
        this.title = title;
        this.src = src;
        this.score = score;
        this.author = author;
        this.broadcost = broadcost;
        this.count = count;
        this.content = content;
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id) &&
                Objects.equals(title, album.title) &&
                Objects.equals(src, album.src) &&
                Objects.equals(score, album.score) &&
                Objects.equals(author, album.author) &&
                Objects.equals(broadcost, album.broadcost) &&
                Objects.equals(count, album.count) &&
                Objects.equals(content, album.content) &&
                Objects.equals(time, album.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, src, score, author, broadcost, count, content, time);
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", src='" + src + '\'' +
                ", score='" + score + '\'' +
                ", author='" + author + '\'' +
                ", broadcost='" + broadcost + '\'' +
                ", count=" + count +
                ", content='" + content + '\'' +
                ", time=" + time +
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

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadcost() {
        return broadcost;
    }

    public void setBroadcost(String broadcost) {
        this.broadcost = broadcost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
