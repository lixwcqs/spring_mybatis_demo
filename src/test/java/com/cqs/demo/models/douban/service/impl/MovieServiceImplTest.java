package com.cqs.demo.models.douban.service.impl;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.models.douban.entity.Movie;
import com.cqs.demo.models.douban.service.MovieService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqs on 16-12-12.
 */
public class MovieServiceImplTest extends BaseConfigurationTest {

    @Resource
    @Qualifier("movieServiceImpl")
//    @Qualifier("movieServiceHessian")
    MovieService service;

    @Test
    public void queryAll() throws Exception {
        List<Movie> movies = service.queryAll();
        System.out.println(movies.size());
    }

    @Test
    public void findByName() throws Exception {
        List<Movie> movies = service.findByName("喜剧之王");
        System.out.println(movies.size());
    }

    @Test
    public void findById() throws Exception {
        Movie movie = service.findById(30);
        System.out.println(movie);
    }

    @Test
    public void findTitleAndRateById() throws Exception {
        Movie movie = service.findTitleAndRateById(30);
        System.out.println(movie);
    }

    @Test
    public void insertMovie() throws Exception {

    }

    @Test
    public void batchInsertMovies() throws Exception {

    }

}