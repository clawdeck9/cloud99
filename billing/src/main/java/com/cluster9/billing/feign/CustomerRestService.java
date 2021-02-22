package com.cluster9.billing.feign;

import com.cluster9.billing.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

////// not clear!!!!
@FeignClient(name = "CUSTOMER-APP")
// @FeignClient(value = "CustomerRestService", url = "http://localhost:8081/")
public interface CustomerRestService {

    @GetMapping(path = "/customers/{id}")
    public Customer getCustomerById(@PathVariable(name = "id") Long id);
}
