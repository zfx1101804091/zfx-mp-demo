package com.zfx.mp;

import com.zfx.mp.entity.TbUser;
import com.zfx.mp.mapper.TbUserMapper;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZfxMpDemoApplication.class)
public class ZfxMpDemoApplicationTests {
    
    @Autowired
    private TbUserMapper tbUserMapper;

    /*以前的mybatis查询所有*/
    @Test
    public void findALl() {

        System.out.println("hahahahahaha");
    }

    @Test
    public void testInsert() {

        TbUser tbUser = new TbUser();
        tbUser.setAge(18).setName("zhang").setEmail("187558@qq.com").setPassword("123456").setUserName("无敌");
        int insert = tbUserMapper.insert(tbUser);

        System.out.println(insert);
    }


}
