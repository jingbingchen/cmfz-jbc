package com.baizhi.jbc.Action;


import com.baizhi.jbc.Service.ArticleService;
import com.baizhi.jbc.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/Article")

public class ArticleAction {

    @Autowired
    private ArticleService articleService;

    //分页
    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> page(Integer page, Integer rows) throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<Article> page1 = articleService.page(page, rows);
        map.put("rows", page1);
        map.put("page", page);

        Integer totalcount = articleService.totalcount();
        map.put("records", totalcount);
        //设置总页数
        Integer pagecount = 0;
        if (totalcount % rows == 0) {
            pagecount = totalcount / rows;
        } else {
            pagecount = totalcount / rows + 1;
        }
        map.put("total", pagecount);
        return map;
    }

    //修改用户状态
    @RequestMapping("/update")
    @ResponseBody
    public void update(Article article) throws Exception {
        articleService.update(article);
    }

    //修改文章
    @RequestMapping("/update1")
    @ResponseBody
    public HashMap<String, Object> update1(Article article) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        articleService.update1(article);

        map.put("success", "200");
        return map;
    }

    //添加文章
    @RequestMapping("add")
    @ResponseBody
    public String add(Article article) throws Exception {

        System.out.println("article===" + article);
        articleService.insert(article);

        return "";
    }

    //删除文章
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(String id) throws Exception {
        articleService.delete(id);
        return "";
    }

}
