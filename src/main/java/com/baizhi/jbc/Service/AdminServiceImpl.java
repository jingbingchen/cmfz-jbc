package com.baizhi.jbc.Service;

import com.baizhi.jbc.Dao.AdminDao;
import com.baizhi.jbc.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    //管理员登陆
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    @Override
    public Admin login(String name, String password) {
        Admin login = adminDao.login(name, password);
        return login;
    }
}
