package com.cqs.demo.models.douban;

import com.cqs.demo.base.BaseConfigurationTest;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by cqs on 17-1-4.
 */
public class AopClientTest extends BaseConfigurationTest {

    @Resource
    AopClient client;

    @Test
    public void say() throws Exception {
        client.say();
    }

    @Test
    public void say2() throws Exception {
        //**************************//
        client.say("world");
    }

}