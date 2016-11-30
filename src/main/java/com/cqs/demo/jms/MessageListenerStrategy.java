package com.cqs.demo.jms;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by cqs on 16-11-30.
 */
@Component
public class MessageListenerStrategy implements MessageListener {


    @Override
    public void onMessage(Message message) {
        System.out.println("接受消息:" + message);
    }
}
