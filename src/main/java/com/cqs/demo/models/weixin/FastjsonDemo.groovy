package com.cqs.demo.models.weixin

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.cqs.demo.models.douban.entity.Movie

/**
 * Created by cqs on 11/1/16.
 */
class FastjsonDemo {
    public static void main(String[] args) {
        toJson()
    }


    private static void toJson() {
        def list = new ArrayList();
        def movie = new Movie();
        movie.setTitle("大话西游")
        movie.setRate(9.5f)
        list.add(movie)

        def movie2 = new Movie();
        movie2.setTitle("喜剧之王")
        movie2.setRate(9.3f)
        list.add(movie2)
        println JSONObject.toJSONString(list)
        println JSON.toJSONString(list)
    }
}
