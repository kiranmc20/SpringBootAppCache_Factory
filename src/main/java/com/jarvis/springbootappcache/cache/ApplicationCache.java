package com.jarvis.springbootappcache.cache;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationCache<V> {

    private static Object instance = null;
    private final ConcurrentHashMap<CacheItem, V> cache = new ConcurrentHashMap<>();

    private ApplicationCache(){}

    public static ApplicationCache getInstance(){
        if(instance == null)
            instance = new ApplicationCache<>();

        return (ApplicationCache) instance;
    }

    public V get(CacheItem key){
        return cache.get(key);
    }

    public V put(CacheItem key, V value){
        return cache.put(key, value);
    }

    public V putIfAbsent(CacheItem key, V value){
        return cache.putIfAbsent(key, value);
    }

    public V remove(CacheItem key){
        return cache.remove(key);
    }

    protected void clear(){
        cache.clear();
    }
}
