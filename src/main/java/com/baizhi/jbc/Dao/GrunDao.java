package com.baizhi.jbc.Dao;

import com.baizhi.jbc.entity.Grun;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GrunDao {

    //上师分页
    public List<Grun> page(@Param("page")Integer page,@Param("rows")Integer rows);

    //查询所有总条数
    public Integer totalcount();
}
