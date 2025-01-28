package com.redis.controller;


import com.redis.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/products/")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable long id){
        log.info("from {} method","getProductById");
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductFromCache(@PathVariable long id){
        log.info("from {} method with id {}","deleteProductFromCache",id);
        productService.removeProductFromCache(id);
    }
}
