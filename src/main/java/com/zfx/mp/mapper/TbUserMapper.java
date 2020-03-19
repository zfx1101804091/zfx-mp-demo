package com.zfx.mp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zfx.mp.entity.TbUser;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zheng_fx
 * @since 2020-01-18
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    List<TbUser> findALL();
}
