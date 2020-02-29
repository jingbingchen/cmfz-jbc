package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.GrunDao;
import com.baizhi.jbc.entity.Grun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GrunServiceImpl implements GrunService {

    @Autowired
    private GrunDao grunDao;

    //分页
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Grun> page(Integer page, Integer rows) {
        List<Grun> page1 = grunDao.page(page, rows);
        return page1;
    }

    //查询上师总条数
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer totalcount() {
        Integer totalcount = grunDao.totalcount();
        return totalcount;
    }
}
