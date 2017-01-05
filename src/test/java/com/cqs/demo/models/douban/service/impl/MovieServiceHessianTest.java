package com.cqs.demo.models.douban.service.impl;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.mock.MovieMock;
import com.cqs.demo.models.douban.cache.MovieCache;
import com.cqs.demo.models.douban.entity.Movie;
import com.cqs.demo.models.douban.service.MovieService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by cqs on 17-1-3.
 */
public class MovieServiceHessianTest extends BaseConfigurationTest {

    @Resource
    @Qualifier("movieServiceHessian")
    private MovieService service;

    @Test
    public void queryAll() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        Movie movie = service.findById(1);
        System.out.println("1秒不超过过期时间5");
        movie = service.findById(1);
        //超过过期时间5
        TimeUnit.SECONDS.sleep(6);
        System.out.println("6秒超过过期时间5");
        movie = service.findById(1);

        //不超过过期时间
        TimeUnit.SECONDS.sleep(4);
        System.out.println("4秒不超过过期时间");
        //重新计算过期时间
        movie = service.findById(1);
        //不超过过期时间,但是3+4>5
        TimeUnit.SECONDS.sleep(3);
        System.out.println("假设重新计算过期时间");
        movie = service.findById(1);
        System.out.println("证明重新计算过期时间不成立!!!!");
        assertEquals(movie.getId(), 1);
        System.out.println(MovieCache.getCache().stats());
    }

    @Test
    public void insert() throws Exception {
        int i = service.insert(MovieMock.randMovie());
        Assert.assertEquals(i, 1);
    }

    @Test
    public void batchInsert() throws Exception {

    }

    @Test
    public void findByName() throws Exception {

    }

    @Test
    public void findTitleAndRateById() throws Exception {

    }

}