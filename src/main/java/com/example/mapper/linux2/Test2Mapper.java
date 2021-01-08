package com.example.mapper.linux2;

import com.example.entity.linux2.Test2;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
public interface Test2Mapper extends BaseMapper<Test2> {

    Test2 test2(int i);
}
