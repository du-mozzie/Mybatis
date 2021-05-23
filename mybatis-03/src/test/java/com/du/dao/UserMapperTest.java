package com.du.dao;

import com.du.pojo.User;
import com.du.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test02() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userById = userMapper.getUserById(1);

        System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void log4jTest() {
        logger.info("info：进入了log4jTest");
        logger.debug("debug：进入了log4jTest");
        logger.error("error：进入了log4jTest");
    }

    @Test
    public void limitTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",2);
        map.put("pageSize",2);

        List<User> userLimit = mapper.getUserLimit(map);
        for (User user : userLimit) {
            System.out.println(user);
        }


        sqlSession.close();
    }

}
