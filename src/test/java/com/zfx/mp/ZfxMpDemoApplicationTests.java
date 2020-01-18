package com.zfx.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zfx.mp.entity.TbUser;
import com.zfx.mp.mapper.TbUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

   /*
    * 功能描述: 
    *   mp插入测试
    * @Param: []
    * @Return: void
    * @Author: Administrator
    * @Date: 2020/1/18 0018 19:20
    */
    @Test
    public void testInsert() {

        TbUser tbUser = new TbUser();
        tbUser.setAge(19).setName("xiang").setMail("15478922@qq.com").setPassword("123456").setUserName("社会翔");
        int insert = tbUserMapper.insert(tbUser);

        System.out.println(insert);
        System.out.println("自增后的id会回填到对象中---"+tbUser.getId());
    }

    /*
     * 功能描述: 
     *     update 1.根据id更新
     * @Param: []
     * @Return: void
     * @Author: Administrator
     * @Date: 2020/1/18 0018 19:20
     */
    @Test
    public void testUpdate1() {
        TbUser tbUser = new TbUser();
        tbUser.setId(3L);
        tbUser.setUserName("小二郎");
        int update = tbUserMapper.updateById(tbUser);
        System.out.println(update);

    }
    
    /*
     * 功能描述: 
     *     update 2.根据条件更新
     * @Param: []
     * @Return: void
     * @Author: Administrator
     * @Date: 2020/1/18 0018 19:23
     */
    @Test
    public void testUpdate2() {
        TbUser tbUser = new TbUser();
        tbUser.setAge(22); //更新的字

        QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
        wrapper.eq("id",7);//类似于 where id =7;
        
        //类似于： UPDATE tb_user SET age=? WHERE id = ? 
        int update = this.tbUserMapper.update(tbUser, wrapper);
        System.out.println(update);

    }

    @Test
    public void testUpdate3() {
        //更新的条件以及字段 
        UpdateWrapper<TbUser> wrapper = new UpdateWrapper<>(); 
        wrapper.eq("id", 6).set("user_name", "ceshi"); 
        //执行更新操作 
        int result = this.tbUserMapper.update(null, wrapper);
        System.out.println("result = " + result);

    }

    /*
     * 功能描述: 
     *      delete 1.通过id删除数据
     * @Param: []
     * @Return: void
     * @Author: Administrator
     * @Date: 2020/1/18 0018 19:49
     */
    @Test
    public void testDeleteById(){
        //执行删除操作 
        int result = this.tbUserMapper.deleteById(6L); 
        System.out.println("result = " + result);
        
    }
    
    /*
        delete 2。多条件删除
     */
    @Test
    public void testDeleteByMap(){

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("age",18); 
        columnMap.put("name","张三");
        //将columnMap中的元素设置为删除的条件，多个之间为and关系
        int result = this.tbUserMapper.deleteByMap(columnMap);

        System.out.println("result = " + result);
    }

    /*
      delete 3.根据 entity 条件，删除记录
      DELETE FROM tb_user WHERE name=? AND age=? 
   */
    @Test
    public void testDelete(){
        TbUser tbUser = new TbUser();
        tbUser.setAge(47).setName("gua");
        //将实体对象进行包装，包装为操作条件 
        QueryWrapper<TbUser> wrapper = new QueryWrapper<>(tbUser);
        int result = this.tbUserMapper.delete(wrapper);
        System.out.println("result = " + result);
    }
    
    /*
        delete 4.根据id集合批量删除
        DELETE FROM tb_user WHERE id IN ( ? , ? , ? ) 
     */
    @Test
    public void testDeleteByIds(){

        int result = this.tbUserMapper.deleteBatchIds(Arrays.asList(12L, 14L, 13L));
        System.out.println("result = " + result);
    }
    
    /*
        查询 1.通过id查询
     */
    @Test
    public void testQueryById(){

        TbUser tbUser = this.tbUserMapper.selectById(10L);
        System.out.println("tbUser = " + tbUser);
    }
    
    /*
        查询 2.通过id集合查询
     */
    @Test
    public void testQueryByIds(){

        List<TbUser> tbUsers = this.tbUserMapper.selectBatchIds(Arrays.asList(15L, 16L, 17L));
        for (TbUser tbUser : tbUsers) {
            System.out.println("tbUser = " + tbUser);
        }
        
    }
    
    /*
        查询 3.根据条件查询一条数据，如果结果超过一条会报错
     */
    @Test
    public void testQueryByOne(){
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>(); 
        wrapper.eq("name", "xiang");

        TbUser tbUser = this.tbUserMapper.selectOne(wrapper);
        System.out.println("tbUser = " + tbUser);
    }

    /*
       查询 4.根据条件查询数据条数
    */
    @Test
    public void testQueryByCount(){
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>(); 
        wrapper.gt("age", 20); //年龄大于20岁

        Integer count = this.tbUserMapper.selectCount(wrapper);
        System.out.println("根据条件查询数据条数 = " + count);
    }

    /*
      查询 5.查询所有
   */
    @Test
    public void testSelectList(){

        List<TbUser> tbUsers = this.tbUserMapper.selectList(null);
        for (TbUser tbUser : tbUsers) {
            System.out.println("tbUser = " + tbUser);
        }
    }


    /*
     查询 6.分页查询
  */
    @Test
    public void testSelectByPage(){
        QueryWrapper<TbUser> wrapper = new QueryWrapper<TbUser>();
        wrapper.gt("age", 20); //年龄大于20岁

        Page<TbUser> page = new Page<>(1,2);//从第1页开始，每页显示2条

        //根据条件查询数据 
        IPage<TbUser> iPage = this.tbUserMapper.selectPage(page, wrapper); 
        
        System.out.println("数据总条数：" + iPage.getTotal()); 
        System.out.println("总页数：" + iPage.getPages()); 
        List<TbUser> users = iPage.getRecords();//返回的就是第1页
        
        for (TbUser user : users) { 
            System.out.println("user = " + user); 
        }
    }
        
}
