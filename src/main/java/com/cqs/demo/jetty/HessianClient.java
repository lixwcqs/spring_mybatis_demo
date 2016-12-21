package com.cqs.demo.jetty;


import com.caucho.hessian.client.HessianProxyFactory;
import com.cqs.demo.models.douban.service.MovieService;

public class HessianClient {



    public static void main(String[] args) throws Exception {
        HessianProxyFactory factory = new HessianProxyFactory();
        Basic basic = (Basic) factory.create(Basic.class,"http://localhost:8080/test");
        System.out.println(factory.create(Basic.class,"http://localhost:8080/movie").getClass());
        MovieService movieService = (MovieService) factory.create(MovieService.class,"http://localhost:8080/movie");
        System.out.println("Hello: " + basic.hello());
        System.out.println("Hello: " + basic.hello2());
        System.out.println("movie: " + movieService.findByName("喜剧之王"));

    }

}