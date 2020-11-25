package stu.week05.spring.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDao implements ITestDao{


    @Override
    public void add() {
        System.out.println("》》》》》》》》add");
    }

    @Override
    public void query(){

        List<Map<String,Object>> list =  super.getJdbcTemplate().queryForList("select * from city");
        System.out.println(list.size());
    }
}
