package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.Admin;

public interface AdminService {

    //管理员登陆
    public Admin login(String name,String password);

}
