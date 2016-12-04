package com.cqs.demo.jms;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.models.unit.strategy.entity.Strategy;
import com.cqs.demo.models.unit.strategy.service.StrategyService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqs on 16-11-30.
 */
public class JmsMessageProducerTest extends BaseConfigurationTest {

    @Resource
    JmsMessageProducer<Strategy> producer;

    @Resource
    private StrategyService service;

    @Test
    public void sendMessage() throws Exception {

    }

    @Test
    public void mockSyncStrategy() throws Exception {
        int len = service.findAll().size();
        boolean flag = false;
//        flag = true;
        try {
            producer.mockSyncStrategy(flag);
        } catch (Exception e) {
            logger.error("出现异常", e);
        }
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(service.findAll().size() - len == 1);

    }

}