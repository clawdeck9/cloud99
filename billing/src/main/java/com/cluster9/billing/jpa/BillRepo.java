package com.cluster9.billing.jpa;

import com.cluster9.billing.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BillRepo extends JpaRepository<Bill, Long> {
}
