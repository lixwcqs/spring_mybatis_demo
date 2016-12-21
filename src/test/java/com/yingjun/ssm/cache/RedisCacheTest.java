package com.yingjun.ssm.cache;

import com.cqs.demo.base.BaseConfigurationTest;
import com.cqs.demo.mock.MovieMock;
import com.cqs.demo.models.douban.entity.Movie;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqs on 16-12-18.
 */
public class RedisCacheTest extends BaseConfigurationTest {

    @Resource
    private RedisCache redisCache;

    private Movie movie = MovieMock.randMovie();
    private Random random = new Random();

    @Test
    public void putCache() throws Exception {
        redisCache.deleteCache("film1");
        boolean exists = redisCache.getCache("film2", Movie.class) != null;
        //不存在
        Assert.assertTrue(!exists);
        redisCache.putCache("film1", movie);
        exists = redisCache.getCache("film1", Movie.class) != null;
        //存在
        Assert.assertTrue(exists);

    }

    @Test
    public void putCacheWithExpireTime() throws Exception {
        long expireTime = 5;
        redisCache.deleteCache("film2");
        boolean exists = redisCache.getCache("film2", Movie.class) != null;
        //不存在
        Assert.assertTrue(!exists);
        redisCache.putCacheWithExpireTime("film2", movie, expireTime);
        exists = redisCache.getCache("film2", Movie.class) != null;
        //存在
        Assert.assertTrue(exists);
        //等待
        TimeUnit.SECONDS.sleep(expireTime);
        exists = redisCache.getCache("film2", Movie.class) != null;
        //不存在
        Assert.assertTrue(!exists);
    }

    @Test
    public void putListCache() throws Exception {

    }

    @Test
    public void putListCacheWithExpireTime() throws Exception {

    }

    @Test
    public void getCache() throws Exception {
        redisCache.putCache("film5", movie);
        boolean exists = redisCache.getCache("film5", Movie.class) != null;
        //存在
        Assert.assertTrue(exists);

    }

    @Test
    public void getListCache() throws Exception {
        redisCache.deleteCache("integers");
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(random.nextInt(100));
        }
        redisCache.putListCache("integers", integers);
        List<Integer> integers2 = redisCache.getListCache("integers", Integer.class);
        Assert.assertArrayEquals(integers.toArray(), integers2.toArray());
    }

    @Test
    public void deleteCache() throws Exception {
        redisCache.putCache("film7", movie);
        boolean exists = redisCache.getCache("film7", Movie.class) != null;
        //存在
        Assert.assertTrue(exists);
        redisCache.deleteCache("film7");
        exists = redisCache.getCache("film7", Movie.class) != null;
        //存在
        Assert.assertTrue(!exists);

    }

    @Test
    public void deleteCacheWithPattern() throws Exception {
        redisCache.deleteCacheWithPattern("film_p*");
        //
        redisCache.putCache("film_p1", MovieMock.randMovie());
        redisCache.putCache("film_p2", MovieMock.randMovie());
        redisCache.putCache("film_p3", MovieMock.randMovie());
        redisCache.putCache("film_p4", MovieMock.randMovie());

        Assert.assertTrue(redisCache.getCache("film_p1", Movie.class) != null);
        Assert.assertTrue(redisCache.getCache("film_p2", Movie.class) != null);
        Assert.assertTrue(redisCache.getCache("film_p3", Movie.class) != null);
        Assert.assertTrue(redisCache.getCache("film_p4", Movie.class) != null);
        //
        redisCache.deleteCacheWithPattern("film_p*");
        Assert.assertTrue(redisCache.getCache("film_p1", Movie.class) == null);
        Assert.assertTrue(redisCache.getCache("film_p2", Movie.class) == null);
        Assert.assertTrue(redisCache.getCache("film_p3", Movie.class) == null);
        Assert.assertTrue(redisCache.getCache("film_p4", Movie.class) == null);
    }

    @Test
    public void clearCache() throws Exception {
        redisCache.putCache("cache|film_p1", MovieMock.randMovie());
        redisCache.putCache("cache|film_p2", MovieMock.randMovie());
        redisCache.putCache("cache|film10", MovieMock.randMovie());
        redisCache.clearCache();
        Assert.assertTrue(redisCache.getCache("cache|film10", Movie.class) == null);
    }

}