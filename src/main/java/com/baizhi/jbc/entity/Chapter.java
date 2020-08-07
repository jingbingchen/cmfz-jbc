package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.util.Date;
import java.util.Objects;



public class Chapter {

    private String id;
    private String title;  //主题
    private String img;  //音频
    private String duration; //时长
    private String size; //文件大小
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upload_time; //上传时间
    private String album_id;  //专辑id
    private Album album;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", duration='" + duration + '\'' +
                ", size='" + size + '\'' +
                ", upload_time=" + upload_time +
                ", album_id='" + album_id + '\'' +
                ", album=" + album +
                '}';
    }

    public Chapter() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(id, chapter.id) &&
                Objects.equals(title, chapter.title) &&
                Objects.equals(img, chapter.img) &&
                Objects.equals(duration, chapter.duration) &&
                Objects.equals(size, chapter.size) &&
                Objects.equals(upload_time, chapter.upload_time) &&
                Objects.equals(album_id, chapter.album_id) &&
                Objects.equals(album, chapter.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, img, duration, size, upload_time, album_id, album);
    }

    public Chapter(String id, String title, String img, String duration, String size, Date upload_time, String album_id, Album album) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.duration = duration;
        this.size = size;
        this.upload_time = upload_time;
        this.album_id = album_id;
        this.album = album;
    }
}
