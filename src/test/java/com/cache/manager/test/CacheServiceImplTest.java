package com.cache.manager.test;

import com.cache.manager.test.dto.CacheDto;
import com.cache.manager.test.service.CacheService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CacheServiceImplTest extends TestApplicationTests {

    @Autowired
    private CacheService cacheService;

    /*
    please set application.properties as follows
    cache.level.one.status:true
    cache.level.two.status:false
    cache.level.one.strategy:lru
    cache.level.one.capacity:2
    cache.level.two.strategy:lru
    cache.level.two.capacity:3
     */
    @Test
    public  void testLruObjectCacheIntigration(){

        CacheDto dto1=new CacheDto();
        dto1.setId("1");
        dto1.setFirstName("fisrstName1");
        dto1.setFirstName("fisrstName2");
        cacheService.saveCache(dto1);

        CacheDto dto2=new CacheDto();
        dto2.setId("2");
        dto2.setFirstName("fisrstName2");
        dto2.setFirstName("fisrstName2");
        cacheService.saveCache(dto2);

        CacheDto dto3=new CacheDto();
        dto3.setId("3");
        dto3.setFirstName("fisrstName3");
        dto3.setFirstName("fisrstName3");
        cacheService.saveCache(dto3);


        CacheDto cacheDto=  cacheService.getCache("1");
        Assert.assertNull(cacheDto);



    }

}
