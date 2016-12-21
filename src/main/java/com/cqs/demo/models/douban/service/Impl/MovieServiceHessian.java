package com.cqs.demo.models.douban.service.Impl;

import com.caucho.hessian.server.HessianServlet;
import com.cqs.demo.models.douban.entity.Movie;
import com.cqs.demo.models.douban.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqs on 10/15/16.
 */
@Transactional
@Service
public class MovieServiceHessian extends HessianServlet implements MovieService {


    @Resource
    @Qualifier("movieServiceImpl")
    private MovieService movieService;

    @Override
    public List<Movie> queryAll() {
        return movieService.queryAll();
    }

    @Override
    public Movie findById(Integer id) {
        return movieService.findById(id);
    }

    @Override
    public int insert(Movie entity) {
        return movieService.insert(entity);
    }

    @Override
    public void batchInsert(List<Movie> list) {
        movieService.batchInsert(list);
    }

    @Override
    public List<Movie> findByName(String title) {
        return movieService.findByName(title);
    }

    @Override
    public Movie findTitleAndRateById(int id) {
        return movieService.findTitleAndRateById(id);
    }
}
