package com.yangs.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Ytadpole on 2018/2/16.
 */
public class DbAccess {

    //获取mybatis的sqlSession
    public SqlSession getSqlSession() throws IOException {
        Reader reader = Resources.getResourceAsReader("com/yangs/mybatis/config/Configuration.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        return sqlSessionFactory.openSession();
    }
}
