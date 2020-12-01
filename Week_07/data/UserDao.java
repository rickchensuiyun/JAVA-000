package com.mk.stu.course.week07.data;

import java.sql.*;

/**
 * 这里使用了批量插入和单条插入的方式。都是采用预编译的方式。
 *
 * 批量插入百万数据的时间大概是90s，单条插入的时间大概是240s。批量插入的效率比单条插入高得多。
 * 如果不采用预编译的方式，相信会更慢。
 */
public class UserDao {

    public static final String URL = "jdbc:mysql://localhost:3306/devrepo?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "ginga";

    public static void main(String[] args) throws InterruptedException {
        add();
//        batchAdd();

    }


    public static void add() {
        String sql = "insert into t_ecomm_user (id , user_name , user_phone ,user_address ) values (" +
                " ? , ? , ? , ? )";

        Connection conn = getConn();
        PreparedStatement pt = null;

        try {
            pt = conn.prepareStatement(sql);

            for (int i = 0; i < 1000; i++) {
                for (int j = 1; j < 1001; j++) {
                    int num = i * 1000 + j;
                    pt.setInt(1, num);
                    pt.setString(2, "用户" + num);
                    pt.setString(3, null);
                    pt.setString(4, "地址" + num);
                    pt.execute();
                }
                System.out.println(">>>>>>>>>>>>>>>>>>>>>执行了：" + i);
            }


            conn.commit();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, pt, null);
        }
    }


    public static void batchAdd() throws InterruptedException {
        String sql = "insert into t_ecomm_user (id , user_name , user_phone ,user_address ) values (" +
                " ? , ? , ? , ? )";

        Connection conn = getConn();
        PreparedStatement pt = null;

        try {
            pt = conn.prepareStatement(sql);

            for (int i = 0; i < 1000; i++) {
                for (int j = 1; j < 1001; j++) {
                    int num = i * 1000 + j;
                    pt.setInt(1, num);
                    pt.setString(2, "用户" + num);
                    pt.setString(3, null);
                    pt.setString(4, "地址" + num);
                    pt.addBatch();
                }

                pt.executeBatch();
                System.out.println(">>>>>>>>>>>>>>>>>>>>>执行了：" + i);
            }

            conn.commit();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(conn, pt, null);
        }
    }

    public static Connection getConn() {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);//手动提交/回滚事务
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }


    /**
     * 关闭
     *
     * @param conn
     * @param st
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
