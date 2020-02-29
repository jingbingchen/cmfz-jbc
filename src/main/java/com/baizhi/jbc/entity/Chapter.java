package com.baizhi.jbc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

}
