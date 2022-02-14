package com.example.mapper.linux1;

import com.example.entity.linux1.Test;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@Repository
public interface TestMapper extends BaseMapper<Test> {

    Test test1(int i);

    List<Test> selectAll();
}
