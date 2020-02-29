package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.ChapterDao;
import com.baizhi.jbc.entity.Album;
import com.baizhi.jbc.entity.Chapter;
import com.baizhi.jbc.util.UUIDUtil;
import org.apache.commons.io.IOUtils;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFileFormat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;


    //添加章节
    @Override
    public String insert(Chapter chapter) {
        String uuid = UUIDUtil.getUUID();
        chapter.setId(uuid);
        chapter.setUpload_time(new Date());
        chapterDao.insert(chapter);
        return uuid;

    }

    //删除章节
    @Override
    public void delete(String id) {
        chapterDao.delete(id);
    }

    //修改章节
    @Override
    public void update(Chapter chapter) {
        chapterDao.update(chapter);
    }

    //修改章节
    @Override
    public void update1(Chapter chapter) {
        chapterDao.update1(chapter);
    }


    //查询所有章节
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Chapter> selectall(String id) {
        List<Chapter> selectall = chapterDao.selectall(id);
        return selectall;
    }

    //章节分页
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Chapter> page(Integer page, Integer rows, String id) {
        List<Chapter> page1 = chapterDao.page(page, rows, id);
        return page1;

    }

    //章节总条数
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Integer totalcount() {
        Integer totalcount = chapterDao.totalcount();
        return totalcount;
    }

    //文件上传
    @Override
    public void upload(MultipartFile img, String id, HttpServletRequest request) {
        //1.相对路径获取绝对路径
        String realPath = request.getServletContext().getRealPath("/upload/text");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdir();
        }

        //2.获取路径名
        String originalFilename = img.getOriginalFilename();
        //重新给图片命名
        String newName = new Date().getTime() + "-" + originalFilename;

        //3.文件上传
        try {
            img.transferTo(new File(realPath, newName));

            //获取文件大小
            long size = img.getSize();
            String s = String.valueOf(size);
            Double aDouble = Double.valueOf(size) / 1024 / 1024;
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String sizes = decimalFormat.format(aDouble) + "MB";

            //获取文件的时长 秒
            AudioFile read = AudioFileIO.read(new File(realPath, newName));
            AudioHeader audioHeader = read.getAudioHeader();
            //获取的秒
            int trackLength = audioHeader.getTrackLength();
            String duration = trackLength / 60 + "分" + trackLength % 60 + "秒";


            Chapter chapter = new Chapter();

            chapter.setId(id);
            chapter.setImg(newName);
            chapter.setSize(sizes);
            chapter.setDuration(duration);


            //System.out.println()
            //调用修改方法
            chapterDao.update(chapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //文件下载
    @Override
    public void download(String img1, HttpServletRequest request, HttpServletResponse response) {
        //1.根据相对路径获取绝对路径
        ServletContext servletContext = request.getSession().getServletContext();
        String realPath = servletContext.getRealPath("/upload/text");

        try {
            //2.创建读入流
            FileInputStream fileInputStream = new FileInputStream(new File(realPath, img1));

            //3.设置响应头   attachment:以附件的形式下载    inline:在线打开
            response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(img1 , "UTF-8"));

            //4.文件下载
            IOUtils.copy(fileInputStream, response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
