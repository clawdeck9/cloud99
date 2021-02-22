package com.cluster9.billing.jpa;

import com.cluster9.billing.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface ProductItemRepo extends JpaRepository<ProductItem, Long> {
    public Collection<ProductItem> findByBillId(Long billId);
}
