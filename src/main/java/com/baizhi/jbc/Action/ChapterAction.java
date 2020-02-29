package com.baizhi.jbc.Action;


import com.baizhi.jbc.Service.ChapterService;
import com.baizhi.jbc.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Chapter")
public class ChapterAction {

    @Autowired
    private ChapterService chapterService;

    //增删改
    String id=null;
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Chapter chapter, String oper, String id) throws Exception {
        if ("add".equals(oper)) {
            id=chapterService.insert(chapter);
        } else if ("edit".equals(oper)) {
            chapterService.update1(chapter);
        } else if ("del".equals(oper)) {
            chapterService.delete(id);
            System.out.println(id);
        }
        return id;

    }

    //查询所有章节
    @RequestMapping("/all")
    @ResponseBody
    public List<Chapter> selectall(String id)throws Exception{
        List<Chapter> selectall = chapterService.selectall(id);
        return selectall;
    }

    //章节分页
    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> page(Integer page, Integer rows,String id) throws Exception {
        Map<String, Object> maps = new HashMap<>();
        //获取当前页的数据
        List<Chapter> page1 = chapterService.page(page, rows,id);
        //设置当前页的数据
        maps.put("rows", page1);
        //设置当前页号
        maps.put("page", page);
        //设置总条数
        //获取总条数
        Integer totalcount = chapterService.totalcount();
        maps.put("records", totalcount);
        //设置总页数
        Integer pagecount = 0;
        if (totalcount % rows == 0) {
            pagecount = totalcount / rows;
        } else {
            pagecount = totalcount / rows + 1;
        }
        maps.put("total", pagecount);
        return maps;
    }

    //章节文件上传
    @RequestMapping("/upload")
    public void upload(MultipartFile img, String id, HttpServletRequest request) throws Exception {

        chapterService.upload(img,id,request);

    }

    //文件上传
    @RequestMapping("/download")
    public  void download(String img1, HttpServletRequest request, HttpServletResponse response){
        chapterService.download(img1,request,response);
    }

}
