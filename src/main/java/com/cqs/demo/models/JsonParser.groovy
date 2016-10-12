package com.cqs.demo.models

import groovy.json.JsonSlurper

/**
 * Created by cqs on 10/7/16.
 */
class JsonParser {

    private void requestMoive() {
        def movieUrl = "https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=30&page_start=0"
        def json = new JsonSlurper().parse(new URL(movieUrl))

        println json.subjects.getClass()
        List list = json.subjects
        list.forEach({
            movie ->
//                println movie
                println parseMovie(movie)
        })
//        Movie movie = parseMovie(json.subjects[0])
    }

    def parseMovie(subj) {
        def movie = new Movie();
        movie.setTitle(subj.title)
        movie.setRate(subj.rate.toFloat())
        movie.setIs_beetle_subject(subj.is_beetle_subject.toBoolean())
        movie.setPlayable(subj.playable.toBoolean())
        movie.setCover(subj.cover)
        movie.setIs_new(subj.is_new)
        movie.setUrl(subj.url)
        return movie
    }

    public static void main(String[] args) {
        new JsonParser().requestMoive()
    }
}
