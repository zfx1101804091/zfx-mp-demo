package com.zfx.mp.controller;


import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.zfx.mp.entity.TbUser;
import com.zfx.mp.mapper.TbUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zheng_fx
 * @since 2020-01-18
 */
@RestController
@RequestMapping("user")
public class TbUserController {

    @Autowired
    private TbUserMapper tbUserMapper;

    /*老式mybatis和spring整合使用用例*/
    @RequestMapping("/find")
    public String findALL() {
        
        String config = "mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(config);
            //原始mybatis构造器
            /*SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
            
            //mybatis-plus 构造器
            SqlSessionFactory sessionFactory = new MybatisSqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sessionFactory.openSession();
            TbUserMapper userMapper = sqlSession.getMapper(TbUserMapper.class);

            List<TbUser> tbUsers = userMapper.findALL();

            return tbUsers.toString();
        } catch (IOException e) {
            return e.getMessage();
        }

       
    }
    

    /*整合mybatis-plus*/
    @RequestMapping("selectList")
    public List<TbUser> selectList() {
        return tbUserMapper.selectList(null);
    }
    
}
