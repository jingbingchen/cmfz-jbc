package com.baizhi.jbc.Service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.jbc.Dao.UserDao;
import com.baizhi.jbc.entity.City;
import com.baizhi.jbc.entity.Mouth;
import com.baizhi.jbc.entity.User;
import com.baizhi.jbc.util.UUIDUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //用户分页
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<User> page(Integer page, Integer rows) {
        List<User> page1 = userDao.page(page, rows);
        return page1;
    }

    //查询所有总条数
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer totalcount() {
        Integer totalcount = userDao.totalcount();
        return totalcount;
    }

    //修改用户状态
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    //导出用户数据
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void export() {
        List<User> users = userDao.export();
        for (User user : users) {
            user.setImg("/upload/photo/" + user.getImg());
        }
        ExportParams exportParams = new ExportParams("用户信息", "用户信息表");
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, users);
        try {
            workbook.write(new FileOutputStream(new File("E://用户信息表")));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //查询地图男
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<City> selectBycity(String sex) {
        List<City> cities = userDao.selectBycity(sex);
        return cities;
    }

    //查询月份
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Mouth> selectBymonth(String sex) {
        List<Mouth> mouths = userDao.selectByMonth(sex);
        return mouths;
    }

    //模拟
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public void insert(User user) {
        for(int i=0;i<5;i++){
            String uuid = UUIDUtil.getUUID();
            user.setId(uuid);
            user.setPhone(null);
            user.setSalt(null);
            user.setStatus(null);
            user.setImg(null);
            user.setName(null);
            user.setLegal_name(null);
            user.setSex("男");
            user.setCity(null);
            user.setSign(null);
            user.setTime(new Date());
            user.setPassword(null);
        }
        for(int i=0;i<5;i++){
            String uuid = UUIDUtil.getUUID();
            user.setId(uuid);
            user.setPhone(null);
            user.setSalt(null);
            user.setStatus(null);
            user.setImg(null);
            user.setName(null);
            user.setLegal_name(null);
            user.setSex("女");
            user.setCity(null);
            user.setSign(null);
            user.setTime(new Date());
            user.setPassword(null);

        }
        userDao.insert(user);
    }

}
