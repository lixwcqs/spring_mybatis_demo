package com.cqs.demo.models.unit.strategy.service;

import com.cqs.demo.base.BaseConfigurationTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by cqs on 16-11-24.
 */
public class StrategyServiceTest extends BaseConfigurationTest {
    @Resource
    private StrategyService service;

    @Test
    public void insert() throws Exception {

    }

    @Test
    public void selectById() throws Exception {
        service.findAll();
    }

    @Test
    public void batchInsert() throws Exception {

    }

    @Test
    public void findAll() throws Exception {

    }

}