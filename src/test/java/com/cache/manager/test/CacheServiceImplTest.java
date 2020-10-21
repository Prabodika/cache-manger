package com.cache.manager.test;

import com.cache.manager.test.dto.CacheDto;
import com.cache.manager.test.service.CacheService;
import com.cache.manager.test.util.Configurations;
import com.cache.manager.test.util.FileDataWriter;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class CacheServiceImplTest extends TestApplicationTests {

    @Autowired
    private CacheService cacheService;

    @Autowired
    private Configurations configurations;

    @Before
    public void removeFiles(){

        FileDataWriter.getInstance().deleteFile("1");
        FileDataWriter.getInstance().deleteFile("2");
        FileDataWriter.getInstance().deleteFile("3");
        FileDataWriter.getInstance().deleteFile("4");

    }

   /*
     To run a specific scenario only remove the @Ignore tag  of given  scenario
   */


    /*
    remove @Ignore tag
    Test scenario:
            *first we are adding 2 objects in order corresponding object ids are 1,2
            *then we access the first object, object id for this is 1
            *then we add a new object object id is 3

     Expected test result
            *least recent used object is object with the id of 2 therefore if get object from id 2 it should be null

    please set application.properties as follows
    cache.level.one.status:true
    cache.level.two.status:false
    cache.level.one.strategy:lru
    cache.level.one.capacity:2
    cache.level.two.strategy:lru
    cache.level.two.capacity:3
     */
    @Test
    @Ignore
    public  void testLruObjectCacheIntigration(){

            CacheDto dto1 = new CacheDto();
            dto1.setId("1");
            dto1.setFirstName("fisrstName1");
            dto1.setLastName("lasttName1");
            cacheService.saveCache(dto1);

            CacheDto dto2 = new CacheDto();
            dto2.setId("2");
            dto2.setFirstName("fisrstName2");
            dto2.setLastName("lasttName2");
            cacheService.saveCache(dto2);

            cacheService.getCache("1");

            CacheDto dto3 = new CacheDto();
            dto3.setId("3");
            dto3.setFirstName("fisrstName3");
            dto3.setLastName("lastName3");
            cacheService.saveCache(dto3);


            CacheDto cacheDto = cacheService.getCache("2");
            Assert.assertNull(cacheDto);


    }


    /*
   remove @Ignore tag

   Test scenario:
           *first we are adding 3 objects in order corresponding object ids are 1,2,3
           *then we access the first object for once (object id for this is 1) second object for twice (object id 2)
           *then we add a new object object id is 4

    Expected test result
           *least frequent used object is object with the id of 3 therefore if get object from id 3 it should be null

   please set application.properties as follows
   cache.level.one.status:true
   cache.level.two.status:false
   cache.level.one.strategy:lfu
   cache.level.one.capacity:3
   cache.level.two.strategy:lru
   cache.level.two.capacity:3
    */
    @Test
    @Ignore
    public  void testLfuObjectCacheIntigration(){


            CacheDto dto1 = new CacheDto();
            dto1.setId("1");
            dto1.setFirstName("fisrstName1");
            dto1.setLastName("lasttName1");
            cacheService.saveCache(dto1);

            CacheDto dto2 = new CacheDto();
            dto2.setId("2");
            dto2.setFirstName("fisrstName2");
            dto2.setLastName("lasttName2");
            cacheService.saveCache(dto2);

            CacheDto dto3 = new CacheDto();
            dto3.setId("3");
            dto3.setFirstName("fisrstName3");
            dto3.setLastName("lastName3");
            cacheService.saveCache(dto3);

            cacheService.getCache("1");
            cacheService.getCache("2");
            cacheService.getCache("2");


            CacheDto dto4 = new CacheDto();
            dto4.setId("4");
            dto4.setFirstName("fisrstName4");
            dto4.setLastName("lastName4");
            cacheService.saveCache(dto4);

            CacheDto cacheDto = cacheService.getCache("3");
            Assert.assertNull(cacheDto);


    }



    /*
   remove @Ignore tag
   Test scenario:
           *first we are adding 2 objects in order corresponding object ids are 1,2
           *then we access the first object, object id for this is 1
           *then we add a new object object id is 3

    Expected test result
           *least recent used object is object with the id of 2 therefore if get object from id 2 it should be null

   please set application.properties as follows
    cache.level.one.status:false
    cache.level.two.status:true
    cache.level.one.strategy:lru
    cache.level.one.capacity:2
    cache.level.two.strategy:lru
    cache.level.two.capacity:2
    */
    @Test
    @Ignore
    public  void testLruOFileCacheIntigration(){



            CacheDto dto1 = new CacheDto();
            dto1.setId("1");
            dto1.setFirstName("fisrstName1");
            dto1.setLastName("lasttName1");
            cacheService.saveCache(dto1);

            CacheDto dto2 = new CacheDto();
            dto2.setId("2");
            dto2.setFirstName("fisrstName2");
            dto2.setLastName("lasttName2");
            cacheService.saveCache(dto2);

            cacheService.getCache("1");

            CacheDto dto3 = new CacheDto();
            dto3.setId("3");
            dto3.setFirstName("fisrstName3");
            dto3.setLastName("lastName3");
            cacheService.saveCache(dto3);


            CacheDto cacheDto = cacheService.getCache("2");
            Assert.assertNull(cacheDto);


    }

    /*
    remove @Ignore tag
    Test scenario:
           *first we are adding 3 objects in order corresponding object ids are 1,2,3
           *then we access the first object for once (object id for this is 1) second object for twice (object id 2)
           *then we add a new object object id is 4

    Expected test result
           *least frequent used object is object with the id of 3 therefore if get object from id 3 it should be null

    please set application.properties as follows
    cache.level.one.status:false
    cache.level.two.status:true
    cache.level.one.strategy:lfu
    cache.level.one.capacity:3
    cache.level.two.strategy:lfu
    cache.level.two.capacity:3
    */
    @Test
    public  void testLfuFileCacheIntigration(){


            CacheDto dto1 = new CacheDto();
            dto1.setId("1");
            dto1.setFirstName("fisrstName1");
            dto1.setLastName("lasttName1");
            cacheService.saveCache(dto1);

            CacheDto dto2 = new CacheDto();
            dto2.setId("2");
            dto2.setFirstName("fisrstName2");
            dto2.setLastName("lasttName2");
            cacheService.saveCache(dto2);

            CacheDto dto3 = new CacheDto();
            dto3.setId("3");
            dto3.setFirstName("fisrstName3");
            dto3.setLastName("lastName3");
            cacheService.saveCache(dto3);

            cacheService.getCache("1");
            cacheService.getCache("2");
            cacheService.getCache("2");


            CacheDto dto4 = new CacheDto();
            dto4.setId("4");
            dto4.setFirstName("fisrstName4");
            dto4.setLastName("lastName4");
            cacheService.saveCache(dto4);

            CacheDto cacheDto = cacheService.getCache("3");
            Assert.assertNull(cacheDto);


    }



}
