package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface AlbumService {

    //添加专辑
    public String insert(Album album);

    //删除专辑
    public void delete(String id);

    //修改专辑
    public void update(Album album);

    //修改专辑
    public void update1(Album album);

    //查询所有专辑
    public List<Album> all();


    //专辑分页                //当前页号                //每页展示的条数
    public List<Album> page(Integer page,Integer rows);

    //查询总条数
    public Integer totalcount();

    //专辑文件上传
    public void upload(MultipartFile src, String id, HttpServletRequest request);

}
