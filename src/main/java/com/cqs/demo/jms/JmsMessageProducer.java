package com.cqs.demo.jms;

import com.cqs.demo.mock.StrategyMock;
import com.cqs.demo.models.unit.strategy.entity.Strategy;
import com.cqs.demo.models.unit.strategy.service.StrategyService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by cqs on 16-11-30.
 */
@Component
public class JmsMessageProducer<T> {

    ///模拟下发策略
    @Resource
    private StrategyService service;

    @Resource
    private JmsTemplate jmsTemplate;


    public void sendMessage(final T obj) {
        System.out.println("发送消息成功");
    }


    @Transactional(transactionManager = "jtaTransactionManager")
    public void mockSyncStrategy(boolean flag) {
        Strategy strategy = StrategyMock.randStrategy();
        jmsTemplate.convertAndSend(strategy);
        try {
            // service.insert(strategy);
            System.out.println(1 / 0);
        } catch (Exception e) {
            System.err.println("出现1/0异常");
        }
        if (flag) {
            throw new RuntimeException("模拟异常");
        }
    }
}
