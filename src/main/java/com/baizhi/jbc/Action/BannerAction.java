package com.baizhi.jbc.Action;

import com.baizhi.jbc.Service.BannerService;
import com.baizhi.jbc.entity.Banner;
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
@RequestMapping("/Banner")
public class BannerAction {

    @Autowired
    private BannerService bannerService;

    //查询所有轮播图
    @RequestMapping("/banner")
    @ResponseBody
    public List<Banner> all(HttpServletRequest request) throws Exception {
        List<Banner> all = bannerService.all();
        return all;

    }


    //增删改
    String id = null;

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(Banner banner, String oper, String id) throws Exception {
        if ("add".equals(oper)) {
            id = bannerService.insert(banner);
        } else if ("edit".equals(oper)) {
            bannerService.update1(banner);
        } else if ("del".equals(oper)) {
            bannerService.delete(id);
        }
        return id;


    }

    //分页
    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> page(Integer page, Integer rows) throws Exception {
        Map<String, Object> maps = new HashMap<>();
        //获取当前页的数据
        List<Banner> page1 = bannerService.page(page, rows);
        //设置当前页的数据
        maps.put("rows", page1);
        //设置当前页号
        maps.put("page", page);
        //设置总条数
        //获取总条数
        Integer totalcount = bannerService.totalcount();
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

    //文件上传
    @RequestMapping("/upload")
    public void upload(MultipartFile src, String id, HttpServletRequest request) throws Exception {

        bannerService.upload(src, id, request);

    }


}
