package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.BannerDao;
import com.baizhi.jbc.entity.Banner;
import com.baizhi.jbc.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BannerSerivceImpl implements BannerService {

    @Autowired
    private BannerDao bannerDao;

    //分页
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Banner> page(Integer page, Integer rows) {
        List<Banner> page1 = bannerDao.page(page, rows);
        return page1;
    }

    //所有条数
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer totalcount() {
        Integer totalcount = bannerDao.totalcount();
        return totalcount;
    }

    //查询所有轮播图
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Banner> all() {
        List<Banner> all = bannerDao.all();
        return all;
    }

    //添加轮播图
    @Override
    public String insert(Banner banner) {

        String uuid = UUIDUtil.getUUID();
        banner.setId(uuid);
        banner.setStatus("1");
        banner.setTime(new Date());
        bannerDao.insert(banner);
        return uuid;

    }

    //删除轮播图
    @Override
    public void delete(String id) {
        bannerDao.delete(id);

    }

    //修改轮播图
    @Override
    public void update(Banner banner) {
        bannerDao.update(banner);

    }

    //修改轮播图
    @Override
    public void update1(Banner banner) {
        bannerDao.update1(banner);
    }

    //文件上传
    @Override
    public void upload(MultipartFile src, String id, HttpServletRequest request) {
        //1.相对路径获取绝对路径
        System.out.println(id);
        String realPath = request.getServletContext().getRealPath("/upload/img");
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }

        //2.获取路径名
        String originalFilename = src.getOriginalFilename();
        //重新给图片命名
        String newName = new Date().getTime() + "-" + originalFilename;

        //3.文件上传
        try {
            src.transferTo(new File(realPath,newName));

            //修改轮播图信息
            Banner banner=new Banner();

            banner.setId(id);
            banner.setSrc(newName);

            System.out.println(newName);


            //System.out.println()
            //调用修改方法
            bannerDao.update(banner);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
