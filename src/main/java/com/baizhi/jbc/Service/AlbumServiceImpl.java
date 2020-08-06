package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.AlbumDao;
import com.baizhi.jbc.entity.Album;
import com.baizhi.jbc.entity.User;
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
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumDao albumDao;

    //添加专辑
    @Override
    public String insert(Album album) {
        String uuid = UUIDUtil.getUUID();
        album.setId(uuid);
        album.setTime(new Date());
        albumDao.insert(album);
        System.out.println(uuid);
        return uuid;
    }

    //删除专辑
    @Override
    public void delete(String id) {
        albumDao.delete(id);

    }

    //修改专辑
    @Override
    public void update(Album album) {
        albumDao.update(album);

    }

    //修改专辑
    @Override
    public void update1(Album album) {
        albumDao.update1(album);

    }

    //查询所有专辑
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Album> all() {
        List<Album> all = albumDao.all();
        return all;
    }

    //专辑分页
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Album> page(Integer page, Integer rows) {
        List<Album> page1 = albumDao.page(page, rows);
        return page1;
    }

    //查询所有总条数
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Integer totalcount() {
        Integer totalcount = albumDao.totalcount();
        return totalcount;
    }


    //专辑文件上传
    @Override
    public void upload(MultipartFile src, String id, HttpServletRequest request) {
        //1.相对路径获取绝对路径
        String realPath = request.getServletContext().getRealPath("/upload/img");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }

        //2.获取路径名
        String originalFilename = src.getOriginalFilename();
        //重新给图片命名
        String newName = new Date().getTime() + "-" + originalFilename;

        //3.文件上传
        try {
            src.transferTo(new File(realPath, newName));


            Album album = new Album();

            album.setId(id);
            album.setSrc(newName);


         //System.out.println()
            //调用修改方法
            albumDao.update(album);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
