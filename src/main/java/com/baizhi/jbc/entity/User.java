package com.baizhi.jbc.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @Excel(name = "注册时间",format = "yyyy年MM月dd日",height = 10,width =30)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time; //注册时间

}
