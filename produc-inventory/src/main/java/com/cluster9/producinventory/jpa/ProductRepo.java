package com.cluster9.producinventory.jpa;

import com.cluster9.producinventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
