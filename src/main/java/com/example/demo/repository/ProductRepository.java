package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{ //"Create a repository for my Product entity, whose primary key is an Integer."
    
}
