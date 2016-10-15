package com.cqs.demo.models.douban.dao;

import com.cqs.demo.models.douban.entity.Movie;

import java.util.List;

/**
 * Created by cqs on 10/12/16.
 */
public interface MovieDao {
    List<Movie> queryAll();//查询全部电影

    void insertMovie(Movie movie);//插入一条电影记录

    void batchInsertMovies(List<Movie> movies);

}
