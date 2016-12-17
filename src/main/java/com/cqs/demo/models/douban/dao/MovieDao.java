package com.cqs.demo.models.douban.dao;

import com.cqs.demo.commons.base.dao.BaseDao;
import com.cqs.demo.models.douban.entity.Movie;

import java.util.List;

/**
 * Created by cqs on 10/12/16.
 */
public interface MovieDao extends BaseDao<Integer, Movie> {
    List<Movie> queryAll();//查询全部电影

    List<Movie> findByName(String title);//根据名称查询电影

    Movie findTitleAndRateById(int id);//根据主键查询电影


}
