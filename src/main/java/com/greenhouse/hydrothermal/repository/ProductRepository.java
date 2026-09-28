package com.greenhouse.hydrothermal.repository;

import com.greenhouse.hydrothermal.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}