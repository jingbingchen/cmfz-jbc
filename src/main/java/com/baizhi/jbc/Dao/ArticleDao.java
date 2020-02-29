package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleDao {

    //文章分页
    public List<Article> page(@Param("page") Integer page, @Param("rows") Integer rows);

    //查询所有总条数
    public Integer totalcount();

    //修改文章状态
    public void update(Article article);


    //修改文章
    public void update1(Article article);

    //添加文章
    public void insert(Article article);

    //删除文章
    public void delete(String id);
}
