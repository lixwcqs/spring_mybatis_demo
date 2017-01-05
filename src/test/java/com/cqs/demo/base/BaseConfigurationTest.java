package com.cqs.demo.base;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by cqs on 10/14/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml","classpath:spring/spring-mongo.xml"})
@ContextConfiguration(locations = {"classpath:spring/spring.xml","classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml", "classpath:spring/spring-mongo.xml", "classpath:spring/spring-redis.xml", "classpath:spring/spring-activemq.xml"})
public class BaseConfigurationTest {

    protected static Logger logger = LoggerFactory.getLogger(BaseConfigurationTest.class);
}
