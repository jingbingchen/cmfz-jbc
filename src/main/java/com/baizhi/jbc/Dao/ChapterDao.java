package com.baizhi.jbc.Dao;


import com.baizhi.jbc.entity.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ChapterDao {

    //添加章节
    public void insert(Chapter chapter);

    //删除章节
    public void delete(String id);

    //修改章节
    public void update(Chapter chapter);

    //修改章节
    public void update1(Chapter chapter);

    //查询所有章节
    public List<Chapter> selectall(String id);

    //章节分页                     //当前页号                //每页展示的条数
    public List<Chapter> page(@Param("page") Integer page, @Param("rows") Integer rows,@Param("id") String id);

    //查询所有总条数
    public Integer totalcount();
}
