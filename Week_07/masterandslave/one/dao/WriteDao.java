package com.mk.stu.course.week07.masterandslave.one.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class WriteDao extends JdbcDaoSupport implements IMasterDao{



    @Override
    public void write() {
        super.getJdbcTemplate().execute("insert into t_ecomm_user values (1,'admin' ,'12322226666','testAddress')");
    }
}
