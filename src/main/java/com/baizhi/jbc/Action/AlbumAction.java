package com.baizhi.jbc.Action;

import com.baizhi.jbc.Service.AlbumService;
import com.baizhi.jbc.entity.Album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Album")
public class AlbumAction {

    @Autowired
    private AlbumService albumService;

    //专辑的增删改

    String id=null;
    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Album album, String oper, String id) throws Exception {
        if ("add".equals(oper)) {
            id = albumService.insert(album);
        } else if ("edit".equals(oper)) {
            albumService.update1(album);
        } else if ("del".equals(oper)) {
            albumService.delete(id);
        }

        return id;
    }

    //查询所有专辑
    @RequestMapping("/all")
    @ResponseBody
    public List<Album> all() throws Exception {
        List<Album> all = albumService.all();
        return all;

    }

    //专辑分页
    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> page(Integer page, Integer rows) throws Exception {
        Map<String, Object> maps = new HashMap<>();
        //获取当前页的数据
        List<Album> page1 = albumService.page(page, rows);
        //设置当前页的数据
        maps.put("rows", page1);
        //设置当前页号
        maps.put("page", page);
        //设置总条数
        //获取总条数
        Integer totalcount = albumService.totalcount();
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


    //专辑文件上传
    @RequestMapping("/upload")
    public void upload(MultipartFile src, String id, HttpServletRequest request) throws Exception {

      albumService.upload(src, id, request);

    }
}
