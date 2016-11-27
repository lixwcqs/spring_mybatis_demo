package com.cqs.demo.models.douban.controller;

import com.cqs.demo.models.douban.entity.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cqs on 11/1/16.
 */
@Controller
@RequestMapping("/movie")
public class MovieController {

    @ResponseBody
    @RequestMapping("/list")
    public List<Movie> list(ModelMap modelMap) {
        List<Movie> list = new ArrayList();
        Movie movie = new Movie();
        movie.setTitle("大话西游");
        movie.setRate(9.5f);
        list.add(movie);
        Movie movie2 = new Movie();
        movie2.setTitle("喜剧之王");
        movie2.setRate(9.3f);
        list.add(movie2);
        return list;
    }

}
