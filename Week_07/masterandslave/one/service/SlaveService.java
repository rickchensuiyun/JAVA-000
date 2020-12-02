package com.mk.stu.course.week07.masterandslave.one.service;

import com.mk.stu.course.week07.masterandslave.one.dao.ISlaveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("slaveService")
public class SlaveService{

    @Autowired
    private ISlaveDao dao;

    public void query(){
        dao.query();
    }

    public void setDao(ISlaveDao dao) {
        this.dao = dao;
    }
}
