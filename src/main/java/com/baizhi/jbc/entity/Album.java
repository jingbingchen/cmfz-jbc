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

}
