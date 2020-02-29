package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.ArticleDao;
import com.baizhi.jbc.entity.Article;
import com.baizhi.jbc.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    //分页
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Article> page(Integer page, Integer rows) {
        List<Article> page1 = articleDao.page(page, rows);
        return page1;
    }

    //查询所有总条数
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer totalcount() {
        Integer totalcount = articleDao.totalcount();
        return totalcount;
    }

    //修改用户状态
    @Override
    public void update(Article article) {
        articleDao.update(article);
    }

    //修改文章
    @Override
    public void update1(Article article) {
        articleDao.update1(article);

    }

    //添加文章
    @Override
    public void insert(Article article) {
        String uuid = UUIDUtil.getUUID();
        article.setId(uuid);
        article.setTime(new Date());
        article.setStatus("1");
        articleDao.insert(article);
    }

    //删除文章
    @Override
    public void delete(String id) {
        articleDao.delete(id);
    }
}
