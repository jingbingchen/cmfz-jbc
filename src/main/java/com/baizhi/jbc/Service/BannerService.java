package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BannerService {


    //分页                          //当前页号          //每页展示的条数
    public List<Banner> page(Integer page,Integer rows);

    //总条数
    public Integer totalcount();

    //查询所有轮播图
    public List<Banner> all();

    //添加轮播图
    public String insert(Banner banner);

    //删除轮播图
    public  void delete(String id);

    //修改轮播图
    public  void  update(Banner banner);

    //修改轮播图
    public  void  update1(Banner banner);

    //文件上传
    public void upload(MultipartFile src, String id, HttpServletRequest request);

}
