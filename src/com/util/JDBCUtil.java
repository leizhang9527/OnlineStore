package com.util;

/**
 * @Author: Decadence
 * @Email: leizhang9527@163.com
 * @Date: 2020/3/23 14:36
 * @Version 1.0
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    public static Connection getConnection() throws SQLException  {
  /*      String[] path={"WebRoot/WEB-INF/applicationContext.xml","out/artifacts/OnlineStore_war_exploded/WEB-INF/applicationContext.xml"};
        ApplicationContext context = new FileSystemXmlApplicationContext(path);
        context.getBean("dataSource");
        Object topicEventcodes = context.getBean("dataSource");

        final String driver =StringUtils.getValueByKey(topicEventcodes,"driverClassName");
        final String url = StringUtils.getValueByKey(topicEventcodes,"url");
        final String user  = StringUtils.getValueByKey(topicEventcodes,"username");
        final String password = StringUtils.getValueByKey(topicEventcodes,"password");*/
        final String driver ="com.mysql.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/onlinestore";
        final String user  = "root";
        final String password = "root";
        Connection  conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeResourse(Connection conn,Statement st,ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }else {
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(st!=null) {
                st.close();
            }else {
                st = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }else {
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeResourse(Connection conn,PreparedStatement ps,ResultSet rs) {
        try {
            if(rs!=null) {
                rs.close();
            }else {
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(ps!=null) {
                ps.close();
            }else {
                ps = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null) {
                conn.close();
            }else {
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}