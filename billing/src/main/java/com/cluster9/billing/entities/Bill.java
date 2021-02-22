package com.cluster9.billing.entities;

import com.cluster9.billing.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @ToString
public class Bill{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Customer customer;
    private Long customerId;


    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<ProductItem> items;

    public Bill(Customer customer, Long customerId) {
        this.customer = customer;
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }

    public Bill() {
        this.items = new ArrayList<>();
    }
}
