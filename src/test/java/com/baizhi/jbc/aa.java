package com.baizhi.jbc;

import com.baizhi.jbc.Dao.UserDao;
import com.baizhi.jbc.entity.Mouth;
import com.baizhi.jbc.entity.User;
import com.baizhi.jbc.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CmfzJbcApplication.class)
public class aa {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<Mouth> mouths = userDao.selectByMonth("男");
        for (Mouth mouth : mouths) {
            System.out.println(mouth);

        }

    }

    @Test
    public void test1() {
        User user = new User();

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
        for (int i = 0; i < 5; i++) {
            String uuid = UUIDUtil.getUUID();
            user.setId(uuid);
            userDao.insert(user);

        }
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
        for (int i = 0; i < 5; i++) {
            String uuid = UUIDUtil.getUUID();
            user.setId(uuid);
            userDao.insert(user);
        }


    }
}
