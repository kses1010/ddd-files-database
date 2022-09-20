package com.whatap.productservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    protected Product() {

    }

    @Builder
    private Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
