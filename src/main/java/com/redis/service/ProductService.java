package com.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class ProductService {

    private static final Map<Long,String> productDatabase = new HashMap<>();

    static{
        log.info("simulating the db ... using hashmap implementation");
      productDatabase.put(101L,"Dell Laptop");
      productDatabase.put(102L,"IPhone mobile phone");
      productDatabase.put(103L,"Tablet");
    }

    @Cacheable(value="product",key="#id")
    public String getProductById(Long id){
     log.info("fetching product id from db");
     return productDatabase.get(id);
    }

    @CacheEvict(value= "products",key = "#id")
    public void removeProductFromCache(Long id){
        log.info("removing product {}, from redis cache",id);
    }
}
