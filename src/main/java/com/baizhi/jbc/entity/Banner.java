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
public class Banner {
    private String id;
    private String src;
    private String des;//描述
    private String status;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date time;


}
