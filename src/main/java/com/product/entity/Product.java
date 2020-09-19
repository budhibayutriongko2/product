package com.product.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PRODUCT")
@DynamicUpdate
@Data
public class Product implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "PRODUCT_CODE")
    private String productCode;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_PRICE")
    private int productPrice;

    @Column(name = "STORE_NAME")
    private String storeName;

    @Column(name = "BRAND_NAME")
    private String brandName;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

  
}
