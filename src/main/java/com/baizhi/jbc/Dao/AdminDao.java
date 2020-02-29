package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.Admin;
import org.springframework.stereotype.Component;

@Component
public interface AdminDao {

    //管理员登陆
    public Admin  login(String name,String password);
}
