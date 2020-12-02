package com.mk.stu.course.week07.masterandslave.one.service;

import com.mk.stu.course.week07.masterandslave.one.dao.IMasterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("masterService")
public class MasterService  {

    @Autowired
    private IMasterDao dao;

    public void write(){
        dao.write();
    }

    public void setDao(IMasterDao dao) {
        this.dao = dao;
    }
}
