package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.Banner;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BannerDao {

    //分页                          //当前页号          //每页展示的条数
    public List<Banner> page(@Param("page") Integer page, @Param("rows") Integer rows);

    //总条数
    public Integer totalcount();


    //查询所有轮播图
    public List<Banner> all();

    //添加轮播图
    public void insert(Banner banner);

    //删除轮播图
    public void delete(String id);

    //修改轮播图
    public void update(Banner banner);

    //修改轮播图
    public void update1(Banner banner);



}
