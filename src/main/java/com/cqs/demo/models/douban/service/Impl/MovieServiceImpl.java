package com.cqs.demo.models.douban.service.Impl;

import com.cqs.demo.commons.base.dao.BaseDao;
import com.cqs.demo.commons.base.service.BaseServiceImpl;
import com.cqs.demo.models.douban.dao.MovieDao;
import com.cqs.demo.models.douban.entity.Movie;
import com.cqs.demo.models.douban.service.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqs on 10/15/16.
 */
@Transactional
@Service
public class MovieServiceImpl extends BaseServiceImpl<Integer, Movie> implements MovieService {

    @Resource
    private MovieDao movieDao;

    @Override
    protected BaseDao<Integer, Movie> getBaseDao() {
        return movieDao;
    }

    @Override
    public List<Movie> findByName(String title) {
        return movieDao.findByName(title);
    }

    @Override
    public Movie findTitleAndRateById(int id) {
        return movieDao.findTitleAndRateById(id);
    }



}
