package com.devsuperior.produto_departamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.produto_departamento.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
