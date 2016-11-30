package com.cqs.demo.models.unit.strategy.service;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.mock.StrategyMock;
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
        service.insert(StrategyMock.randStrategy());
    }

    @Test
    public void selectById() throws Exception {
        service.selectById(1);
    }

    @Test
    public void batchInsert() throws Exception {

    }

    @Test
    public void findAll() throws Exception {
        service.findAll();
    }

}