package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.Album;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AlbumDao {

    //添加专辑
    public void insert(Album album);

    //删除专辑
    public void delete(String id);

    //修改专辑
    public void update(Album album);

    //修改专辑
    public void update1(Album album);

    //查询所有专辑
    public List<Album> all();

    //专辑分页                //当前页号                //每页展示的条数
    public List<Album> page(@Param("page") Integer page, @Param("rows") Integer rows);

    //查询总条数
    public Integer totalcount();
}
