package com.cache.manager.test.controller;

import com.cache.manager.test.dto.CacheDto;
import com.cache.manager.test.exception.NotFoundException;
import com.cache.manager.test.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;


    /**
     * This  is the controller method to get cache details by key
     * @param key : key to get cache details
     * @return CacheDto: cache details
     */
    @GetMapping("/cache/{key}")
    public CacheDto getCache(@PathVariable String key) {
        CacheDto dto= cacheService.getCache(key);
        if(dto==null){
           throw new NotFoundException("No data found for given key" +key);
        }
        return  dto;
    }

    /**
     * This method save cache details by key
     * @param cacheDto : cache data
     */
    @PostMapping("/cache")
    public void saveCache(CacheDto cacheDto) {
        cacheService.saveCache(cacheDto);
    }
}
