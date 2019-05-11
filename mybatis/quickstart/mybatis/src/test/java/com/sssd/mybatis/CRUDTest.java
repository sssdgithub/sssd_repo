package com.sssd.mybatis;

import com.sssd.mybatis.entity.QueryVo;
import com.sssd.mybatis.entity.User;
import com.sssd.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRUDTest {
    private SqlSession session;
    private UserMapper userMapper;
    @Before
    public void init() throws Exception{
        InputStream in
                = org.apache.ibatis.io.Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }
    @After
    public void destroy(){
        session.close();
    }

    @Test
    public void findAll(){
        List<User> userList = userMapper.findAll();
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void findById(){
        User user = userMapper.findById(5);
        System.out.println(user);
    }
    @Test
    public void findByUsername(){
        List<User> userList= userMapper.findByUsername("%y%");
        for(User user:userList){
            System.out.println(user);
        }
    }
    @Test
    public void findByVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%y%");
        queryVo.setUser(user);
        List<User> userList = userMapper.findByVo(queryVo);
        for (User u:userList){
            System.out.println(u);
        }
    }
    @Test
    public void getCount(){
        Integer count = userMapper.getCount();
        System.out.println(count);
    }
    @Test
    public void findByCondition(){
        User user = new User();
//        user.setBirthday(new Date());
//        user.setUsername("xyf");
        user.setId(5);
        List<User> userList = userMapper.findByCondition(user);
        for(User u:userList){
            System.out.println(u);
        }
    }
    @Test
    public void findByIds(){
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        queryVo.setIds(ids);
        List<User> userList = userMapper.findByIds(queryVo);
        for (User user:userList){
            System.out.println(user);
        }
    }
}
