package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ChapterService {
    //添加章节
    public String insert(Chapter chapter);

    //删除章节
    public void delete(String id);

    //修改章节
    public void update(Chapter chapter);

    //修改章节
    public void update1(Chapter chapter);

    //查询所有章节
    public List<Chapter> selectall(String id);

    //章节分页                     //当前页号                //每页展示的条数
    public List<Chapter> page(Integer page,Integer rows,String id);

    //查询所有总条数
    public Integer totalcount();

    //章节文件上传
    public void  upload(MultipartFile img, String id, HttpServletRequest request);

    //章节文件下载
    public  void download(String img1, HttpServletRequest request, HttpServletResponse response);

}
