package com.du.dao;

import com.du.pojo.User;
import com.du.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test(){
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行sql
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
        
    }

    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("id",7);
        hashMap.put("name","d");
        hashMap.put("password","121633416");

        mapper.addUser(hashMap);

        sqlSession.commit();
        sqlSession.close();
    }

    //模糊查询
    @Test
    public void getUserlike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userlike = mapper.getUserlike("%小%");
        for (User user : userlike) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userById = userMapper.getUserById(1);

        System.out.println(userById);

        sqlSession.close();

    }

    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.insertUser(new User(4,"小明","1111111"));

        //增删改需要提交事务
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.updateUser(new User(4,"小白","654123"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);
        sqlSession.commit();
        sqlSession.close();
    }
}
