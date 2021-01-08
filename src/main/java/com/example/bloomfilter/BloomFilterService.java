package com.example.bloomfilter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/17 14:44
 * @version:1.0
 */
@Slf4j
@Service
public class BloomFilterService {



    private BloomFilter<Integer> bf;

    /**
     * 创建布隆过滤器
     *
     * @PostConstruct：程序启动时候加载此方法
     */
    @PostConstruct
    public void initBloomFilter() {


    }

    /**
     * 判断id可能存在于布隆过滤器里面
     *
     * @param id
     * @return
     */
    public boolean testIdExists(int id) {
        return bf.mightContain(id);
    }
}
