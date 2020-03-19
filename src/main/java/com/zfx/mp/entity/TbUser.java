package com.zfx.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author zheng_fx
 * @since 2020-01-18
 */
@Data
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_user")
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
//    @TableId(value = "id", type = IdType.AUTO)
    @TableId(value = "id", type = IdType.ID_WORKER)//适用于分布式自增id
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     * 在MP中通过@TableField注解可以指定字段的一些属性
     */
    @TableField("email")//解决字段名不一致
    private String mail;

    @TableField(exist = false)//该字段在数据库表中不存在
    private String address;

}
