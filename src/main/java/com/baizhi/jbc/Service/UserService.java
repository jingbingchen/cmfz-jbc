package com.baizhi.jbc.Service;

import com.baizhi.jbc.entity.City;
import com.baizhi.jbc.entity.Mouth;
import com.baizhi.jbc.entity.User;

import java.util.List;

public interface UserService {

    //分页
    public List<User> page(Integer page,Integer rows);

    //查询所有总条数
    public Integer totalcount();

    //修改用户状态
    public void update(User user);

    //导出用户
    public void  export();

    //查询地图男
    public List<City> selectBycity(String sex);

    //查询月份
    public List<Mouth> selectBymonth(String sex);

    //模拟
    public  void insert(User user);
}
