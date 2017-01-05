package com.cqs.demo.models.douban;

import org.springframework.stereotype.Component;

/**
 * Created by cqs on 17-1-4.
 */
@Component
public class AopClient {

    public void say() {
        System.out.println("hello aop");
    }

    public String say(String word) {
        System.out.println("word:" + word);
        return "hello," + word;
    }
}
