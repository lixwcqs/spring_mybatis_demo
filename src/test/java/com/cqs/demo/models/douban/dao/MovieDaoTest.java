package com.cqs.demo.models.douban.dao;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.models.JsonParser;
import com.cqs.demo.models.douban.entity.Movie;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cqs on 10/14/16.
 */
public class MovieDaoTest extends BaseConfigurationTest {

    @Resource
    MovieDao movieDao;

    @Test
    public void testQueryAll() throws Exception {
        List<Movie> movieList = movieDao.queryAll();
        logger.debug("list info: " + movieList);
    }

    @Test
    public void testFindById() throws Exception {
        Movie movie = movieDao.findById(3);
        System.out.println(movie);
    }

    @Test
    public void testFindByName() throws Exception {
        List<Movie> movies = movieDao.findByName("喜剧之王");
        System.out.println(movies.size());
    }

    @Test
    public void testFindTitleAndRate() throws Exception {
        Movie movie = movieDao.findTitleAndRateById(5);
        System.out.println(movie);
    }

    @Test
    public void testInsertMovie() throws Exception {
        Movie movie = new Movie();
        movie.setTitle("喜剧之王");
        movie.setCover("https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1043597424.jpg");
        movie.setPlayable(true);
        movie.setIsBeetleSubject(true);
        movie.setIsNew(false);
        movie.setRate(8.3f);
        movie.setUrl("https://movie.douban.com/subject/1302425/");
        logger.debug("" + movie);
        movieDao.insert(movie);
    }


    @Test
    public void testBatchInsertMovies() throws Exception {
        String[] tags = {
                "热门", "最新", "经典", "可播放", "豆瓣高分", "冷门佳片", "动画",
                "华语", "欧美", "韩国", "日本", "动作", "喜剧", "爱情", "科幻", "悬疑", "恐怖"
        };
        for (int j = 0; j < 10; j++) {
            int count = 0;
            for (int i = 0; i < tags.length; i++) {
                int page = -1;
                while (++page < 100) {
                    List<Movie> movies = new JsonParser().requestMoive(tags[i], page);
                    if (movies.isEmpty()) break;
                    movieDao.batchInsert(movies);
                }
            }
        }

    }
}