package com.devsuperior.produto_departamento.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.devsuperior.produto_departamento.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
