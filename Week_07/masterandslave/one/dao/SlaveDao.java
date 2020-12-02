package com.mk.stu.course.week07.masterandslave.one.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;
import java.util.Map;

public class SlaveDao extends JdbcDaoSupport implements ISlaveDao{


    @Override
    public void query(){

        List<Map<String,Object>> list =  super.getJdbcTemplate().queryForList("select * from t_ecomm_user");
        System.out.println(list.size());
    }
}
