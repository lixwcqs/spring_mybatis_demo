package com.cqs.demo.models.douban.service;

import com.cqs.demo.commons.base.service.BaseService;
import com.cqs.demo.models.douban.entity.Movie;

import java.util.List;

/**
 * Created by cqs on 10/15/16.
 */
public interface MovieService extends BaseService<Integer, Movie> {
//public interface MovieService {
    List<Movie> findByName(String title);//根据名称查询电影

    Movie findTitleAndRateById(int id);//根据主键查询电影

//    Movie findById(Integer id);//根据主键查询
//
//    int insert(Movie entity);//插入一条记录
//
//    void batchInsert(List<Movie> list);
//
//    List<Movie> queryAll();
}
