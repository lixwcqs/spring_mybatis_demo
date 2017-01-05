package com.cqs.demo.models.douban.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by cqs on 17-1-3.
 */
public class MovieCache {
    private static Cache<String, Object> cache = CacheBuilder
            .newBuilder()
            .maximumSize(10000)
//            .expireAfterWrite(5, TimeUnit.SECONDS)//put5秒之后,一定失效
            .expireAfterAccess(5, TimeUnit.SECONDS)//read5秒之后,一定失效[读之后,重新计数]
            .removalListener(notification -> {
                System.out.println("缓存失效监听器工作了...");//声明一个监听器，以便缓存项被移除时做一些额外操作。缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值
            }).recordStats()
            .build();


    public synchronized static Cache<String, Object> getCache() {
        return cache;
    }




    public static Object getCallableCache(final String key) {
        try {
            //Callable只有在缓存值不存在时，才会调用
            return cache.get(key, new Callable() {
                @Override
                public Object call() throws Exception {
//                    return cacheInvoke.method.invoke(cacheInvoke.instance,cacheInvoke.objects);
                    return null;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


    //通过反向代理来
    //实例,方法名,参数
    private static class CacheInvoke {
        private Object instance;
        private Method method;
        private Object[] objects;

        public CacheInvoke(Object instance, Method method, Object[] objects) {
            this.instance = instance;
            this.method = method;
            this.objects = objects;
        }
    }

    private static CacheInvoke cacheInvoke;

    public static CacheInvoke getCacheInvoke() {
        return cacheInvoke;
    }

    public void setCacheInvoke(CacheInvoke cacheInvoke) {
        this.cacheInvoke = cacheInvoke;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try {
            System.out.println(Lists.newArrayList(List.class.getDeclaredMethods()));
            Method method = ArrayList.class.getMethod("add",Object.class);
            method.invoke(list,"Hello");
            System.out.println(list.get(0));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}