package com.cqs.demo.models

import com.cqs.demo.models.douban.entity.Movie
import groovy.json.JsonSlurper
import groovy.json.internal.LazyMap

import java.util.function.Function

/**
 * Created by cqs on 10/7/16.
 */
class JsonParser {

    private int defaultPageSize = 30;

    public List<Movie> requestMoive(String tag, int pageSize, int pageNo) {
        def movieUrl = "https://movie.douban.com/j/search_subjects?type=movie&tag=" + tag + "&page_limit=" + pageSize + "&page_start=" + (pageNo * pageSize)
        println movieUrl
        def json = new JsonSlurper().parse(new URL(movieUrl))
        List list = json.subjects
        List<Movie> result = transfer(list)
        println result
        return result;
    }

    public List<Movie> requestMoive(String tag, int pageStart) {
        return requestMoive(tag, defaultPageSize, pageStart)
    }

    private List<Movie> transfer(List<LazyMap> json) {
        Function<LazyMap, Movie> function = new Function<LazyMap, Movie>() {
            @Override
            Movie apply(LazyMap lazyMap) {
                return parseMovie(lazyMap);
            }
        };
        return json.stream().map(function).collect();
    }

    def parseMovie(subj) {
        Movie movie = new Movie();
        movie.setTitle(subj.title)
        movie.setRate(subj.rate.toFloat())
        movie.setIsBeetleSubject(subj.is_beetle_subject.toBoolean())
        movie.setPlayable(subj.playable.toBoolean())
        movie.setCover(subj.cover)
        movie.setIsNew(subj.is_new)
        movie.setUrl(subj.url)
        return movie
    }


    public static void main(String[] args) {
        new JsonParser().requestMoive()
    }
}
