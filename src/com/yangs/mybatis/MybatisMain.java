package com.yangs.mybatis;

import com.yangs.mybatis.bean.Info;
import com.yangs.mybatis.utils.DbAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ytadpole on 2018/2/16.
 */
public class MybatisMain {

    public static void main(String[] args){
        //条件
        String name = "";
        String description = "啊";

        SqlSession sqlSession = null;

        //获取sqlSession
        DbAccess dbAccess = new DbAccess();
        try {
            sqlSession = dbAccess.getSqlSession();

            //设置条件
            Info info = new Info();
            info.setName(name);
            info.setDescription(description);

            //执行sql
            List<Info> list = sqlSession.selectList("Info.find", info);
            for(Info i : list){
                System.out.println(i.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
