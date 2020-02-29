package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.Grun;

import java.util.List;

public interface GrunService {

    //上师分页
    public List<Grun> page(Integer page,Integer rows);

    //查询所有总条数
    public Integer totalcount();
}
