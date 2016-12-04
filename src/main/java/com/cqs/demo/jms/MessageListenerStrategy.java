package com.cqs.demo.jms;

import com.cqs.demo.mock.StrategyMock;
import com.cqs.demo.models.unit.strategy.entity.Strategy;
import com.cqs.demo.models.unit.strategy.service.StrategyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by cqs on 16-11-30.
 */
@Component
public class MessageListenerStrategy implements MessageListener {

    @Resource
    private StrategyService service;

    @Override
    @Transactional(transactionManager = "jtaTransactionManager")
    public void onMessage(Message message) {
//        System.out.println("接受消息:" + message);
        System.out.println((message instanceof ObjectMessage));
        if (message instanceof ObjectMessage) {
            ObjectMessage objectMessage = (ObjectMessage) message;
            try {
//                System.out.println(objectMessage.getObject());
//                Strategy strategy = (Strategy) objectMessage.getObject();
                Strategy strategy = StrategyMock.randStrategy();
                System.out.println("接受消息" + strategy);
                service.insert(strategy);
                System.out.println("接受消息" + strategy);
            } catch (Exception e) {
                try {
                    throw new JMSException("转化失败");
                } catch (JMSException e1) {
                    e.printStackTrace();
                }
            }
        }
        try {
            throw new RuntimeException("处理消息异常");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
