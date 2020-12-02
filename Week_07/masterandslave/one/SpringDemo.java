package com.mk.stu.course.week07.masterandslave.one;

import com.mk.stu.course.week07.masterandslave.one.service.MasterService;
import com.mk.stu.course.week07.masterandslave.one.service.SlaveService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 在配置文件中配置了两个数据源，来分别完成读和写的操作
 */
public class SpringDemo {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MasterService masterService = (MasterService) context.getBean("masterService");
        masterService.write();

        SlaveService slaveService = (SlaveService) context.getBean("slaveService");
        slaveService.query();

    }
}
