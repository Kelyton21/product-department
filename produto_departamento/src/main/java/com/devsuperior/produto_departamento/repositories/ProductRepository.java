package com.devsuperior.produto_departamento.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.produto_departamento.entities.Department;
import com.devsuperior.produto_departamento.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
   
}
