package com.cqs.demo.models.mongo;

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
public class MongoDBTemplateDemoTest {

    @Resource
    MongoDBTemplateDemo templateDemo;

    @Test
    public void testInsert() throws Exception {
        templateDemo.insert();
    }

    @Test
    public void testInsertByCollection() throws Exception {
        templateDemo.insertByCollection();
    }

    @Test
    public void testFindAll() throws Exception {
        templateDemo.findAll();
    }
}