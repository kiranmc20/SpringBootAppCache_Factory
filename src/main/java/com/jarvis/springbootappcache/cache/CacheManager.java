package com.jarvis.springbootappcache.cache;

public class CacheManager {

    public static void clearCache(){
        ApplicationCache.getInstance().clear();
    }
}
