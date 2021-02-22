package com.cluster9.billing.feign;

import com.cluster9.billing.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT-APP")
// @FeignClient(value = "ProductRestService", url = "http://localhost:8082/")
public interface ProductRestService {
    @GetMapping(path = "/products/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id);
    @GetMapping(path = "/products")
    public PagedModel<Product> getProducts(@RequestParam(value = "page") String page, @RequestParam(value = "size") String size);
}
