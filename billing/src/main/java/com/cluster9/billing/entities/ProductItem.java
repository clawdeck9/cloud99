package com.cluster9.billing.entities;

import com.cluster9.billing.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class ProductItem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//.hibernate.MappingException: Repeated column in mapping for entity: com.cluster9.billing.entities.ProductItem column: id (should be mapped with insert="false" update="false")
    //    @JoinColumn(name="bill", referencedColumnName="name",insertable=false, updatable=false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bill_id")
    private Bill bill;

    @Transient
    private Product product;

    private Long productId;
    private double price;
    private double quantity;


}
