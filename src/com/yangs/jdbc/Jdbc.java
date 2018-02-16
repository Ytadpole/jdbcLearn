package com.yangs.jdbc;

import javax.sql.RowSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 一些orm学习之前，我们都需要了解基本jdbc的基本功，
 * 这样我们才能体会到orm框架的好处，
 * Created by Ytadpole on 2018/2/16.
 */
public class Jdbc {

    public static void main(String[] args) throws SQLException {
        //数据库信息
        String username = "root";
        String password = "password";

        //条件查询
        String name = "阿羊";
        String description = "";

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            //加载数据库
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC", username, password);

            //sql语句以及参数准备
            StringBuilder sql = new StringBuilder("select id, name, description from t_info where 1 = 1 ");
            List<String> params = new ArrayList<>();
            System.out.print("查询条件：");
            if( null != name && !"".equals(name) ){
                sql.append("and name = ?");
                params.add(name);
                System.out.print(" name = " + name + "| ");
            }
            if( null != description && !"".equals(description) ){
                sql.append("and description like '%' ? '%'");
                params.add(description);
                System.out.print(" description like " + description );
            }

            //执行准备
            statement = conn.prepareStatement(sql.toString());
            for (int i = 0; i < params.size(); i++){
                statement.setString( i + 1, params.get(i));
            }

            System.out.println("\n查询结果");
            set = statement.executeQuery();
            while(set.next()){
                System.out.println(
                        set.getInt("id") +
                    ": " + set.getString("name") +
                        ": " + set.getString("description")
                );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement.close();
            conn.close();
        }
    }



}
