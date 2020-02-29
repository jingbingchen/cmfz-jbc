package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.City;
import com.baizhi.jbc.entity.Mouth;
import com.baizhi.jbc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    //用户分页
    public List<User> page(@Param("page")Integer page,@Param("rows")Integer rows);

    //查询所有总条数
    public Integer totalcount();

    //修改用户状态
    public void update(User user);

    //导出用户
    public List<User>  export();


    //查询地图男
    public List<City> selectBycity(String sex);

    //查询每月
    public List<Mouth> selectByMonth(String sex);

    //模拟
    public void insert(User user);

}
