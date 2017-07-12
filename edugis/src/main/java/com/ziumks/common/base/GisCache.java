package com.ziumks.common.base;

import java.io.InputStream;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class GisCache
{
    /**
     * The CacheManager provides us access to individual Cache instances
     */
    private static final CacheManager cacheManager;
     
    static
    {
         
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = contextClassLoader.getResourceAsStream("cache/ehcache.xml");
        cacheManager = CacheManager.create(resourceAsStream);
    }
     
    /**
     * A cache that we're designating to hold Employee instances
     */
    private Ehcache gisCache;
     
    public GisCache()
    {
        // Load our employees cache:
        gisCache = cacheManager.getEhcache("gis");
    }
     
    public void setCache(String key, String retStr)
    {

        Element element = new Element(key, retStr);
         
        gisCache.put(element);
        
    }
     

    public String getCache(String key)
    {
        Element element = gisCache.get(key);
        if (element != null)
        {
             
            return (String) element.getObjectValue();
        }
         
        return null;
    }
}