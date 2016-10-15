package com.cqs.demo.models.commons.mongo;

import com.cqs.demo.models.mongo.MongoDBTemplateDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by cqs on 11/12/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-mongo.xml"})
public class mongoDBClinet2Test {

    @Resource
    MongoDBTemplateDemo clinet2;

    @Test
    public void testInsert() throws Exception {
        clinet2.insert();
    }
}