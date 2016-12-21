package com.cqs.demo.mock;

import com.cqs.demo.models.douban.entity.Movie;

import java.util.Random;

/**
 * Created by cqs on 16-12-18.
 */
public class MovieMock {
    private static Random random = new Random();


    public static Movie randMovie() {
        Movie movie = new Movie();
        movie.setCover("http://bai.cqs.wwu.image");
        movie.setIsNew(random.nextBoolean());
        movie.setIsBeetleSubject(random.nextBoolean());
        movie.setRate(random.nextFloat());
        movie.setId(random.nextInt(1000000));
        movie.setTitle("http://bai.cqs.wwu.movie");
        return movie;
    }
}
